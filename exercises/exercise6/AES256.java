import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AES256 {
    SecretKey key;
    Cipher cipher;
    public byte[] encryptWithAES(String s) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        key = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(s.getBytes());
        return cipherText;
    }

    public String DecrpytWithAES(byte[] cipherText) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        GCMParameterSpec spec = new GCMParameterSpec(128, cipher.getIV());
        cipher.init(Cipher.DECRYPT_MODE, key,spec);
        byte[] plainText = cipher.doFinal(cipherText);
        return new String(plainText);
    }

}
