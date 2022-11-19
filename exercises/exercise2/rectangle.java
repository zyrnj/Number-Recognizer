public class rectangle extends Shape{
    static String color;
    double calculateArea(int length, int width){
        return length*width;
    };
    int calculatePerimeter(int length,int width){
        return 2*length+2*width;
    };
}
