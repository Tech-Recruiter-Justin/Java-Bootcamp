import java.util.Arrays;
import java.lang.String;

public class Fibonacci {
    // ordinal method for printing a verbal response
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
    // iterative findNth method
    public static void findNth(int n) {
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
        print(answer, ordinal(n));
    }
    // recursive helper method
    public static int helper(int n) {
        int answer = 0;
        if (n < 2)
        {
            return answer = n;
        }
        else
        {
            return answer = helper(n - 1) + helper(n - 2);
        }
    }
    // recursive findNthRec method
    public static void findNthRec(int i) {
        print(helper(i), ordinal(i));
    }
    // print method
    public static void print(int answer, String ordinal) {
        System.out.println("The " + ordinal + " Fibonacci number is " + Integer.toString(answer));
    }
    // main method
    public static void main(String[] args) {
        int nthNumber = 0;
        // parse user input String into int, catch error if the number is double
        try
        {
            nthNumber = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Please use a positive integer or zero as argument.");
            System.exit(1);
        }
        // filter out negative numbers
        if (nthNumber < 0) {
            System.out.println("Please use a positive integer or zero as argument.");
            System.exit(2);
        }
        // run iterative method and recursive method, then print them out
        else {
            System.out.print("This is iterative - ");
            findNth(nthNumber);
            System.out.print("This is recursive - ");
            findNthRec(nthNumber);
        }
    }
}