
/*
Student Name: Nathaniel Posesorsky
 */
import java.util.ArrayList;

// method for Owner to empty traps
public class Owner extends Thread{
    @Override
    public void run(){
        synchronized (Trap.class) { // lock Trap class
            if (Trap.trapList.isEmpty()) // if there are no mice currently trapped
                return; // nothing to do so return.

            // If there is a mouse in a trap:
            System.out.println("========================================================");

            // lock Mouse class
            synchronized (Mouse.class) {
                // for each mouse in the trapList
                for (Mouse m : Trap.trapList) {
                    System.out.println("[Action] Store owner remove mouse-" + m.mouseID);
                }
            } // release Mouse class

            // reset the trapList
            Trap.trapList = new ArrayList<>();

            System.out.println("========================================================");
            System.out.println();
        } // release Trap class
    }
}
