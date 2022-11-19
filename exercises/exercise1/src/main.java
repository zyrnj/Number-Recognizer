public class main {
    public static void main(String[] args) {
        session session=new session();
        session.populate();
        session.printNameofPartTime();
        session.calAvgQuiz();
       // session.printQuiz("Lily");
        session.printExamOfFullTime();
    }
}
