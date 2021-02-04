import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class ArrayTargetSum {

    public static ArrayList<Integer> numPool = new ArrayList();
    public static int answer = 0;
    
    // method to generate random numbers from 1 to 100
    public static void genArray() {
        for (int i = 0; i < 6; i++){ 
            Random rnd = new Random();
            int temp = rnd.nextInt(100) + 1;
            numPool.add(temp);
        }
    }
    
    // generate a random answer
    public static int genAns(ArrayList<Integer> numPool) {
        for (int i = 0; i < 2; i++){
            Random rnd = new Random();
            int temp = rnd.nextInt(6);
            answer += numPool.get(temp);
        }
        return answer;
    }
    
    // find the pair of numbers that generate the answer
    public static void findPair(ArrayList<Integer> numPool, int answer) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numPool.size(); i++) {
            int temp = answer - numPool.get(i);
            if (set.contains(temp)){
                System.out.println(numPool.get(i) + " " + temp);
            }
            set.add(numPool.get(i));
        }
    }
    
    // main method
    public static void main(String[] args){
        genArray();
        System.out.println(numPool);
        genAns(numPool);
        System.out.println(answer);
        findPair(numPool, answer);
    }
    
}