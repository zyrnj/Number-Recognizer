import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class RSA2048 {
    KeyPair keyPair;
    Cipher cipher;
    public byte[] encryptWithRSA(String s) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        keyPair = keyPairGenerator.generateKeyPair();
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] cipherText = cipher.doFinal(s.getBytes());
        return cipherText;
    }

    public String DecrpytWithRSA(byte[] cipherText) throws Exception{

        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] plainText = cipher.doFinal(cipherText);
        return new String(plainText);
    }
}
