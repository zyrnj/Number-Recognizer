public class triangle extends Shape{
    static String color;
    double calculateArea(int length, int height){
        return 0.5*length*height;
    };
    int calculatePerimeter(int length,int width,int c){
        return length+width+c;
    };
}