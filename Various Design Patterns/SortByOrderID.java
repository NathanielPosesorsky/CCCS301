

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Nathaniel Posesorsky
 * 2022-12-04
 * SortByOrderID.java
 */

public class SortByOrderID extends SortStrategy {
    /***
     * sort method used to sort the list of orders per OrderID
     * @param list list of orders
     */
    public static void sort(ArrayList<Computer> list) {
        list.sort(new Comparator<Computer>() {
            @Override
            public int compare(Computer c1, Computer c2) {
                return c2.getOrderID().compareTo(c1.getOrderID());
            }
        });
    }
}
