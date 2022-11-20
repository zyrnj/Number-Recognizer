import java.security.Signature;
import java.sql.SQLOutput;

public class main {
    public static void main(String[] args) throws Exception {
        Alice a=new Alice("This is Alice");
        AES256 Aes=new AES256();
        byte[] test1=Aes.encryptWithAES(a.message);
        System.out.print("This is for AES test: ");
        for(byte b:test1)
            System.out.print(b);
        System.out.println(Aes.DecrpytWithAES(test1));

        Bob b=new Bob("This is Bob");
        RSA2048 Rsa=new RSA2048();
        byte[] test2=Rsa.encryptWithRSA(b.message);
        System.out.print("This is for RSA test: ");
        for(byte c:test2)
            System.out.print(c);
        System.out.println(Rsa.DecrpytWithRSA(test2));

        a.message="for validation";
        signaturetest s=new signaturetest();
        byte[] test3=s.signaturetest(a.message);
        for(byte d:test2)
            System.out.print(d);
        System.out.println(s.verify(test3));
        System.out.println(s.verify2(test3));
    }
}
