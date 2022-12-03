import java.util.List;

public class main {
    public static void main(String[] args) {
        dataStructure d=new dataStructure();
        System.out.println(d.countOdd(List.of(1,2,3,5,7)));
        int test[]=new int[]{1,2,3,4,5};
        d.exchange(test,2,3);
        for(int a:test)
            System.out.print(a);
        System.out.println();
        System.out.println(d.findMaximum(List.of(1,2,3,5,7,6),2,5));

    }
}
