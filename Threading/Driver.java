
/*
Student Name: Nathaniel Posesorsky
 */
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter X number of mice to generate: ");
        int numMice = s.nextInt();

        System.out.print("Enter Y number of traps to generate: ");
        Trap.numberOfTraps = s.nextInt();

        System.out.println(); // skip a line in the console
        System.out.println("[Status] cheese left: "+CheeseContainer.remainingCheese); // skip a line in the console
        System.out.println(); // skip a line in the console

        Mouse m = new Mouse(); // create a mouse m
        for (int i = 0; i < numMice; i++){ // add each mouse m in mice ArrayList for numMice
            m.addMouse();
        }

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        // After the first 5 seconds, the owner will empty traps and will do so again every 5 seconds
        executorService.scheduleAtFixedRate(new Owner(), 5, 5, TimeUnit.SECONDS);

        // After the first 2 seconds, the cheese machine will add cheese and will do so again every 2 seconds
        executorService.scheduleAtFixedRate(new CheeseMachine(), 2, 2, TimeUnit.SECONDS);

        // Every second, one random remaining mouse will try to consume cheese
        executorService.scheduleAtFixedRate(m, 0, 1, TimeUnit.SECONDS);
    }
}
