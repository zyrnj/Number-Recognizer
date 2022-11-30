public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton Instance(){
        return instance;
    }

    public void build(){
        System.out.println("build a vehicle");
    }

}
