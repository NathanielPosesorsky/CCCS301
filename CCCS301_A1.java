
/*
Student Name: Nathaniel Posesorsky
 */
import java.util.ArrayList;

public class CCCS301_A1 {
    public static void main(String[] args) {
        System.out.println(crazySeries(5, new ArrayList<Integer>(),true)); // pos must always be true
        System.out.println(crazySeries(9, new ArrayList<Integer>(),true)); // pos must always be true

        System.out.println(benNumber(2,5,0,false)); // s must be 0 and even must be false
        System.out.println(benNumber(3,8,0,false)); // s must be 0 and even must be false
        System.out.println(benNumber(1,1,0,false)); // s must be 0 and even must be false

    }

    private static ArrayList<Integer> crazySeries(int c, ArrayList<Integer> al, boolean pos) {
        al.add(c); // adds the input c to the array

        // c is the used value for the method and pos is a boolean representing positive or negative numbers
        if (c > 0 && pos) // if c>0 and pos = true,
            crazySeries(c-3, al, true); // run crazySeries method recursively but with c-3 which is added to al
        else if(al.get(0) == c) // once the first element of the array=c
            return al; // return the array
        else // Once c<0, pos becomes false and the following line applies
            return crazySeries(c+3,al,false);

        return al; // return the final array
    }

        public static int benNumber(int m, int n, int s, boolean even){
        if (n < 1) // if n<1
            return s; // Once n becomes smaller than 1, return s (sum)
        else if(n <= 0 || m <= 0) return s; // checks that m and n are >0, if not, return s
        else if (even) // if index is even (index starts at 1)
            // run the method recursively with m*2 and add it to s, then decrease n by 1
            return benNumber((m*2),n-1, s+(m*2), false);
        else // if index is odd (index starts at 1)
            // run the method recursively with m+1 and add it to s, then decrease n by 1
            return benNumber((m+1),n-1, s+(m+1),true);


    }
}
