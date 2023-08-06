package DataCoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Coder
{
    public Coder() {}

    // Encrypting data to file backup
    public static String encrypt(String userName, String password)
    {
        try {
            SecretKey secretKey = generateSecretKey(userName);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encrypted = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Decrypting data from file backup
    public static String decrypt(String userName, String encryptedPassword)
    {
        try
        {
            SecretKey secretKey = generateSecretKey(userName);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
            return new String(decrypted);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Generating secret key for encryption and decryption
    private static SecretKey generateSecretKey(String userName)
    {
        try
        {
            char[] passwordChars = userName.toCharArray();
            byte[] salt = {0x1A, 0x5B, 0x7C, 0x4F, 0x3E, 0x2D, 0x1C, 0x5A};
            var iterationCount = 10000;
            var keyLength = 128;

            var factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            var spec = new PBEKeySpec(passwordChars, salt, iterationCount, keyLength);

            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}