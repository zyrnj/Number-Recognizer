import java.io.Serializable;

public class rectangle extends Shape implements Serializable {
    static String color;
    String name;
    double calculateArea(int length, int width){
        return length*width;
    };
    int calculatePerimeter(int length,int width){
        return 2*length+2*width;
    };
}
