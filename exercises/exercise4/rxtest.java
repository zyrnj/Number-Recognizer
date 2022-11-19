import java.util.ArrayList;
import java.util.regex.*;
import java.util.List;

public class rxtest {

    public static void main ( String args[] ) {
        // String to be scanned to find the pattern.
        String line1 = "This order was placed for QT3000! OK?";
        String line2 = "dog222222";
        String line3 = "12897 432";
        String line4 = "23578";
        String line5 = "2022-10-22";
        String regex1 = "(.*)(\\d+)(.*)";
        String regex2 = "dog";
        String regex3 = "^\\d+$";
        String regex4 = "\\S{6,}";
        String regex5 = "^\\d{4}\\-\\d{1,2}-\\d{1,2}$";

        // Create a Pattern object
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        Pattern pattern4 = Pattern.compile(regex4);
        Pattern pattern5 = Pattern.compile(regex5);

        // Now create matcher object.
        Matcher m1 = pattern1.matcher(line1);
        Matcher m2 = pattern2.matcher(line2);
        Matcher m3 = pattern3.matcher(line3);
        Matcher m4 = pattern4.matcher(line4);
        Matcher m5 = pattern5.matcher(line5);

        ArrayList<Matcher> list=new ArrayList<>(List.of(m1,m2,m3,m4,m5));
        for(Matcher m:list){
            System.out.println("lookingAt(): "+m.lookingAt());
            System.out.println("matches(): "+m.matches());
        }
    }
}
