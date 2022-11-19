import java.util.List;

public class classroom {
    String location;
    String name;
    int students;
    String className;
    boolean isOccupied;
    int floor;
    List<String> stulist;
    String campus;


    class desk{
        int amount;
        int size;
        int price;
    }

    class chair{
        int amount;
        int size;
        int price;
    }
    public classroom(){
        System.out.println("1st instance:classroom");
    }

    public void haveClass(){

    }
    public void afterClass(){

    }
    public void studentsCome(){

    }


}
