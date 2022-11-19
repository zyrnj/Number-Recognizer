import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES256 {

    public byte[] encryptWithAES(String s) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey key = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(s.getBytes());
        return cipherText;
    }

    public void DecrpytWithAES() throws Exception{
        Cipher cipher = Cipher.getInstance("AES");

    }

}
