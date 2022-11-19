import java.io.*;

public class DeserializeDemo {
    public static void main(String [] args)
    {
        rectangle r = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("/tmp/rectangle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            r = (rectangle) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized rectangle...");
        //color is static, so null value
        System.out.println("color: " + r.color);
        System.out.println("name:"+r.name);
    }
}
