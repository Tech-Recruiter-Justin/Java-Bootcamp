import java.util.Arrays;
import java.util.Stack;
import java.lang.String;

public class IsPalindrome{
    
    // test cases
    static String test1 = "1121";
    static String test2 = "11211";
    static String test3 = "7";
    static String test4 = "00";
    static String test5 = "6789009876";
    static String test6 = "00900";
    
    public static boolean checker(String input){
        // validate input and all single digit numbers must not be palindrome
        if (input.charAt(0) == '0'){
            System.out.println("Please use a positive integer and don't start with zero!!!");
            return false;
        } else if (input.length() == 1){
            System.out.println(input + " is NOT palindrome.");
            return false;            
        }
        // create original stack
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++){
            stack.push(input.charAt(i));
        }
        // create a reversed stack
        Stack<Character> clone = (Stack<Character>)stack.clone();
        Stack<Character> reversed = new Stack<Character>();
        for (int i = 0; i < input.length(); i++){
            reversed.push(clone.pop());
        }
        // generate result
        if(stack.equals(reversed)){
            System.out.println(input + " is palindrome.");
            return true; 
        } else {
            System.out.println(input + " is NOT palindrome.");
            return false;
        }
    }

    public static void main(String []args){
        checker(test1); // 1121 is NOT palindrome.
        checker(test2); // 11211 is palindrome.
        checker(test3); // 7 is NOT palindrome.
        checker(test4); // Please use a positive integer and don't start with zero!!!
        checker(test5); // 6789009876 is palindrome.
        checker(test6); // Please use a positive integer and don't start with zero!!!
    }
