

/**
 * Nathaniel Posesorsky
 * Student ID:260803332
 * 2022-12-04
 * MarketSpace.java
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MarketSpace {
    private List<Computer> cart = new ArrayList<Computer>(); // List for all components added in an order
    private ArrayList<String> products = new ArrayList(); // list of all products available

    private static MarketSpace instance = new MarketSpace(); // used to ensure only one MarketSpace instance

    private MarketSpace() {}

    /***
     * Method to read "products.txt" file and store all products in the products ArrayList
     */
    public void loadProducts() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("products.txt"));
            String line = reader.readLine();
            do{ // add one product per line to ArrayList products until there is no more lines
                products.add(line);
                line = reader.readLine();
            } while (line != null);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static MarketSpace getInstance() {  return instance;  } // getter method for the instance (should be 1)

    public void sort() { }

    public ArrayList getProducts() {  return products;  } // getter method for the products

    public List<Computer> getCart() {  return cart;  } // getter method for the the cart


}
