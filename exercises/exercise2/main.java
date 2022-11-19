public class main {
    public static void main(String[] args) {
        
        Shape s=new rectangle();
        rectangle r=new rectangle();
        Shape s2=new triangle();
        s.color="red";
        System.out.println(s.calculatePerimeter(1,2));
        System.out.println(r.calculatePerimeter(1,2));
        System.out.println(s2.calculatePerimeter(1,2));
    }
}
