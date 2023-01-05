

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Nathaniel Posesorsky
 * Student ID:260803332
 * 2022-12-04
 * SortByPrice.java
 */

public class SortByPrice extends SortStrategy {
    public static void sort(ArrayList<Computer> list) {
        // list.sort calls the overridden compare method below in order to sort the list
        list.sort(new Comparator<Computer>() {
            @Override
            public int compare(Computer c1, Computer c2) {
                // if c2.getPrice() >= c1.getPrice() is true, returns 0. Else, return -1 to say that c2 is smaller
                return c2.getPrice() >= c1.getPrice() ? 0 : -1;
            }
        });
    }
}
