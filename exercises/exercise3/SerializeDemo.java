import java.io.*;

public class SerializeDemo {
    public static void main(String [] args)
    {
        rectangle e = new rectangle();
        e.color= "Red";
        e.name="abc";
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/rectangle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/rectangle.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
