
/*
Student Name: Nathaniel Posesorsky
 */
import java.util.ArrayList;
import java.util.Random;

public class Trap {
        static int numberOfTraps = 10; // stores total number of traps;initialized at 10 but changed based on user input
        static ArrayList<Mouse> trapList = new ArrayList<>(); // stores total list of mice currently trapped

        // method to trap a mouse
        synchronized public static boolean trapMouse(Mouse m) {
            Random r = new Random();
            // if mouse is unlucky AND there is a trap available for it
            if (r.nextBoolean() && trapList.size() < numberOfTraps) {
                trapList.add(m); // the mouse gets trapped
                Mouse.removeMouse(m); // removes the mouse from the mice ArrayList

                // print message to console
                System.out.printf("[Action] mouse-%d get caught by trap\n\n",m.mouseID);

                // since the mouse got trapped, return true
                return true;
            }
            return false; // otherwise, return false
        }

}
