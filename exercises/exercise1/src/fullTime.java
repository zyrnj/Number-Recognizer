public class fullTime extends student{
    int[] exam;

    public fullTime(String name){
        super(name);
        exam=new int[2];
        partOrFull="full";
    }

    public int[] getExam() {
        return exam;
    }
}
