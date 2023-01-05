

/**
 * Nathaniel Posesorsky
 * Student ID:260803332
 * 2022-12-04
 * ComputerDecorator.java
 */

import java.util.ArrayList;
import java.util.Random;

public class ComputerDecorator implements Computer{
    private static ArrayList<Integer> idList = new ArrayList(); // ArrayList to store order IDs
    private String descr, oID;
    private  double price;

    public ComputerDecorator(String descr, double price) { //constructor
        this.descr = descr;
        this.price = price;
        Random random = new Random();
        int id ;
        do { // generates a random ID number between 1 and 100 and makes sure nobody else gets the same random ID
            id = (random.nextInt(100) + 1);
        } while (idList.contains((Integer) id));
        idList.add(id); // adds the generated ID to the IDlist
        this.oID = "OrderID@" + id; // stores the ID to the variable
    }

    public String getDescription(){  return this.descr;  } // getter method for description
    public double getPrice(){  return this.price;  } // getter method for price
    public String getOrderID(){  return this.oID;  } // getter method for order ID

    public void setDescr(String descr) {  this.descr = descr;  } // setter method for description
    public void setPrice(double price) {  this.price = price;  } // setter method for price
}
