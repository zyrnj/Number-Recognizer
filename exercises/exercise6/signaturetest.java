import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;

public class signaturetest {
    KeyPair keyPair;
    Signature sign;
    byte[] s;
    public byte[] signaturetest(String s) throws Exception {
        sign = Signature.getInstance("SHA256withRSA");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        keyPair = keyPairGenerator.generateKeyPair();
        sign.initSign(keyPair.getPrivate());
        this.s=s.getBytes();
        sign.update(s.getBytes());
        byte[] signature=sign.sign();
        return signature;
    }

    public boolean verify(byte[] signature) throws Exception{
        sign.initVerify(keyPair.getPublic());
        return sign.verify(signature);
    }
    public boolean verify2(byte[] signature) throws Exception{
        sign.initVerify(keyPair.getPublic());
        sign.update(s);
        return sign.verify(signature);
    }

}
