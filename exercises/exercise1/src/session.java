import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class session {
    List<student> stulist;
    List<fullTime> fulltimelist;
    public session(){
        stulist=new ArrayList<>();
        fulltimelist=new ArrayList<>();
    }

    public void populate(){
        Random random=new Random();
        stulist.add(new partTime("Lily"));
        stulist.add(new partTime("Ada"));
        stulist.add(new partTime("Anna"));
        stulist.add(new partTime("Daisy"));
        stulist.add(new partTime("Debby"));
        stulist.add(new partTime("Elizabeth"));
        stulist.add(new partTime("Fiona"));
        stulist.add(new fullTime("Jennifer"));
        stulist.add(new fullTime("Kathy"));
        stulist.add(new fullTime("Lindsay"));
        stulist.add(new fullTime("Lucia"));
        stulist.add(new fullTime("Madeleine"));
        stulist.add(new fullTime("Maria"));
        stulist.add(new fullTime("Naomi"));
        stulist.add(new fullTime("Priscilla"));
        stulist.add(new fullTime("Salome"));
        stulist.add(new fullTime("Tabitha"));
        stulist.add(new fullTime("Vera"));
        stulist.add(new fullTime("Violet"));
        stulist.add(new fullTime("Zoe"));
        for(student stu:stulist){
            for(int i=0;i<15;i++){
                stu.quiz[i]= random.nextInt(100);
            }
            if(stu.partOrFull=="full"){
                fulltimelist.add((fullTime) stu);
            }
        }
        for(fullTime fullstu :fulltimelist){
            fullstu.exam[0]=random.nextInt(100);
            fullstu.exam[1]=random.nextInt(100);
        }
    }

    public List<Integer> calAvgQuiz(){
        List<Integer> ans=new ArrayList<>();
        for(student stu:stulist){
            int sum=0;
            for(int score:stu.quiz){
                sum+=score;
            }
            ans.add(sum/15);
            System.out.println(stu.name+" average score of quiz is"+sum/15);
        }
        return ans;
    }

    public void printQuiz(String name){
        for(student stu:stulist){
            if(stu.name==name){
                Arrays.sort(stu.quiz);
                System.out.print(name+ "'s quiz scores are ");
                for(int score:stu.quiz)
                    System.out.print(score + " ");
            }
        }
    }

    public void printNameofPartTime(){
        System.out.print("part time students are: ");
        for(student stu:stulist){
            if(stu.partOrFull=="part")
                System.out.print(stu.name+"\t ");
        }
        System.out.println();
    }

    public void printExamOfFullTime(){
        for(fullTime stu:fulltimelist){
                System.out.println(stu.name+" exam score is"+stu.exam[0]+"and"+stu.exam[1]);
        }
    }
}
