import java.io.*; 
import java.util.*;
import java.lang.String;

public class BalancerHard{
    
    // test cases
    static String test1 = "({[a]})(";
    static String test2 = "{{b{}}}c({&}[*])";
    static String test3 = "({7]{}8)";
    static String test4 = "[(#){]g}]";
    static String test5 = "}{%]{";
    static String test6 = "{";
    
    // remove all irrelevant characters
    public static String rinse (String test){
        
        String clean = new String();
        int i = 0;
        
        while (i < test.length()){
            if (Character.toString(test.charAt(i)).equals("(") ||
                Character.toString(test.charAt(i)).equals("{") ||
                Character.toString(test.charAt(i)).equals("[") ||
                Character.toString(test.charAt(i)).equals(")") ||
                Character.toString(test.charAt(i)).equals("}") ||
                Character.toString(test.charAt(i)).equals("]")){
                clean = clean + Character.toString(test.charAt(i));
            }
        i += 1;
        }
        return clean;
    }
    
    // check function
    public static boolean check (String test){
        
        // instance variable
        String temp = rinse(test);
        String compare = "";
        int i = 0;
        Stack<String> stack = new Stack<String>();
        
        // show the String being checked
        System.out.println(temp);
        
        // if String length is 1, it must not be balanced
        if (temp.length() == 1){
            System.out.println("Your String is too short to be balanced!");
            return false;
        }
        
        // if start with ) } ] immediately return false
        if (Character.toString(temp.charAt(i)).equals(")") ||
            Character.toString(temp.charAt(i)).equals("]") ||
            Character.toString(temp.charAt(i)).equals("}")){
            System.out.println("There is no way to balance a String starting with an open bracket!");
            return false;
        }
        
        // else normal case starts with open brackets
        while (i < temp.length()){
            if (Character.toString(temp.charAt(i)).equals("(") ||
                Character.toString(temp.charAt(i)).equals("[") ||
                Character.toString(temp.charAt(i)).equals("{")){
                stack.push(Character.toString(temp.charAt(i)));
                i += 1;
            }
            // loop until closing brackets appear 
            else {
                // only continue if the brackets can be closed
                compare = stack.pop();
                if (compare.equals("(") && Character.toString(temp.charAt(i)).equals(")")){
                    i += 1;
                }
                else if (compare.equals("[") && Character.toString(temp.charAt(i)).equals("]")){
                    i += 1;
                }
                else if (compare.equals("{") && Character.toString(temp.charAt(i)).equals("}")){
                    i += 1;
                }
                // if brackets are not matching, it cannot be closed, hence not balanced
                else {
                    System.out.println("Your String is not closed! " + stack + " remaining!");
                    return false;
                }
            }
        
        }
        
        // if the loop is able to end without issue, it is balanced, else not balanced
        if (stack.size() == 0){
            return true;
        }
        else{
            System.out.println("Your String is not closed! " + stack + " remaining!");
            return false;
        }
        
    }
    
    // main method
    public static void main(String []args){
        System.out.println(check(test1) + "\n");
        System.out.println(check(test2) + "\n");
        System.out.println(check(test3) + "\n");
        System.out.println(check(test4) + "\n");
        System.out.println(check(test5) + "\n");
        System.out.println(check(test6) + "\n");
    }
    
}
