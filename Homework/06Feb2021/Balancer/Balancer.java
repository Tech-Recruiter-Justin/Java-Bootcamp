import java.lang.String;

public class Balancer{
    
    // test cases
    static String test1 = "(((())))(";
    static String test2 = "()()((((()))))";
    static String test3 = "((()))()()(((()))())";
    static String test4 = "(()))))))";
    static String test5 = "((((((((((((((((((((((((()))))))))))))))))))))))))(((())(())())())()(())()(())";
    
    // check function
    public static boolean check (String test){
        // instance variable
        int counter = 0;
        boolean start = true;
        int i = 0;
        
        // show the String being checked
        System.out.println(test);
        
        // loop through each character
        while (i < test.length()){
            // if start at ")", must be unbalanced
            if (Character.toString(test.charAt(i)).equals(")") && start == true){
                System.out.println("not balanced");
                return false;
            // normal start of case with "("
            } else if (Character.toString(test.charAt(i)).equals("(")){
                counter += 1;
                start = false;
                i += 1;
            // switching to ")"
            } else if (Character.toString(test.charAt(i)).equals(")") && start == false){
                counter -= 1;
                i += 1;
                }
            }
        // if counter is 0 and the loop has ended, the String is balanced
        if (counter == 0){
            System.out.println("balanced");
            return true;
        // counter greater or less that 0 means unbalance
        } else {
            System.out.println("not balanced");
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
    }
}
