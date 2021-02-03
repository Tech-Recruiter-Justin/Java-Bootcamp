import java.util.Arrays;
import java.lang.String;

public class Fibonacci {
    
    public static String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
        case 11:
        case 12:
        case 13:
            return i + "th";
        default:
            return i + suffixes[i % 10];
        }
    }
    
    public static int findNth(int n) {
        int answer = 0;
        String nth = ordinal(n);
        int first = 0;
        int second = 1;
        if (n < 2)
        {
            answer = n;
        }
        else
        {
            for (int i = 0; i < n - 1; i++) {
                answer = first + second;
                first = second;
                second = answer;
            }
        }
        System.out.println("The " + nth + " Fibonacci number is " + Integer.toString(answer));
        return answer;
    }
    
    public static void main(String[] args) {
        int nthNumber = 0;
        try
        {
            nthNumber = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Please use a positive integer or zero as argument.");
            System.exit(1);
        }
        if (nthNumber < 0) {
            System.out.println("Please use a positive integer or zero as argument.");
            System.exit(2);
        }
        else {
            findNth(nthNumber);
        }

    }
}