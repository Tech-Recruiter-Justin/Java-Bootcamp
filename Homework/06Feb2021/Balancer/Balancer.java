import java.lang.String;

public class Balancer{
    
    // test cases
    static String test1 = "(((())))";
    static String test2 = "()()()";
    static String test3 = "()()((((()))))";
    static String test4 = "((()";
    static String test5 = ")((()))";
    static String test6 = "((()))()()(((())))(";
    
    // check function
    public static void check (String test){
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
                System.exit(1);
            // normal start of case with "("
            } else if (Character.toString(test.charAt(i)).equals("(")){
                counter += 1;
                start = false;
                i += 1;
            // switching to ")"
            } else if (Character.toString(test.charAt(i)).equals(")") && start == false){
                counter -= 1;
                i += 1;
                // continue to stack down if there are more ")"
                    while (i < test.length()){
                        if (Character.toString(test.charAt(i)).equals(")")){
                            counter -= 1;
                            i += 1;
                        // switching back to "(" indicates a new start of cycle
                        } else {
                            // if counter is 0, restart the 
                            if (counter == 0){
                                start = true;
                                break;
                                // counter greater or less that 0 means unbalance
                            } else {
                                System.out.println("not balanced");
                                System.exit(1);
                            }
                        }
                    }
                }
            }
        // if counter is 0, restart the 
        if (counter == 0){
            System.out.println("balanced");
        // counter greater or less that 0 means unbalance
        } else {System.out.println("not balanced");}
    }
    
    // main method
    public static void main(String []args){
        check(test1);
        check(test2);
        check(test3);
        check(test4);
        check(test5);
        check(test6);
    }
}
