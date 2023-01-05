
/*
Student Name: Nathaniel Posesorsky
 */
import java.util.ArrayList;
import java.util.Random;

public class Mouse extends Thread{
    static ArrayList<Mouse> mice = new ArrayList<>(); // ArrayList of mice
    int mouseID, consumeRate; // every mouse gets a mouseID and consumeRate
    static int numOfMice; //number of mice
    Random r = new Random();


    synchronized public void addMouse() { // method to add a mouse
        Mouse m = new Mouse(); // create a mouse
        m.mouseID = ++numOfMice; // assigns the created mouse a mouseID
        m.consumeRate = r.nextInt(3) + 1; // assigns the created mouse a random consumption rate between 1 and 3
        mice.add(m); //adds the created mouse to the mice arrayList
    }

    // method to remove a mouse from the mice ArrayList
    synchronized static public void removeMouse(Mouse m) {
        mice.remove(m);
    }

    @Override
    public void run() {
        if (mice.isEmpty()) { // if there are no more mice
            if (!Trap.trapList.isEmpty()) // if the traps are not empty
                new Owner().run(); // empty them but running Owner method
            // Once that is done, there is no more mice and no mice caught,
            // print total cheese consumed message
            System.out.printf("[Status] Total cheese lost =  %d\n",CheeseContainer.totalCheeseConsumed);
            System.exit(0);
        }

        while(CheeseContainer.remainingCheese == 0) { // while there is no cheese in the container,
            try {
                sleep(500); // wait 1/2 second
            } catch (InterruptedException e) {}
        }

        // select a random mouse from mice ArrayList
        Mouse m = mice.get(r.nextInt(mice.size()));

        // lock the mouse
        synchronized (m) {

            // check to see if mouse gets trapped (50% chance)
            if (Trap.trapMouse(m)) return; // if mouse is trapped, return and nothing is consumed

            // if the mouse is not trapped, it got to eat cheese
            if (m.consumeRate > CheeseContainer.remainingCheese) { // if consumeRate is bigger than remaining cheese
                CheeseContainer.totalCheeseConsumed += CheeseContainer.remainingCheese; // update total cheese consumed
                CheeseContainer.remainingCheese = 0; // deduct all cheese
            } else {
                CheeseContainer.remainingCheese -= m.consumeRate; // deduct cheese consumed
                CheeseContainer.totalCheeseConsumed += m.consumeRate; // update total cheese consumed
            }

            // print messages to console
            System.out.printf("[Action] mouse-%d ate %d grams of cheese\n", m.mouseID, m.consumeRate);
            System.out.printf("[Status] cheese left: %d\n\n", CheeseContainer.remainingCheese);
        } // unlock the mouse
    }

//    @Override
//    public synchronized String toString(){ // to String method
//        String s = "";
//
//        for (Mouse m : mice) {
//            s += "Mouse #" + m.mouseID + "\tConsume rate: " + m.consumeRate + "\n";
//        }
//
//        return s;
//    }

}
