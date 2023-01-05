
/*
Student Name: Nathaniel Posesorsky
 */
public class CheeseMachine extends Thread{
    @Override
    public void run() {
        synchronized (CheeseContainer.class) { // lock CheeseContainer class
            CheeseContainer.remainingCheese += 10; // increment remaining cheese by 10
        } // release CheeseContainer class
    }
}
