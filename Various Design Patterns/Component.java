

/**
 * Nathaniel Posesorsky
 * Student ID:260803332
 * 2022-12-04
 * Component.java
 */

public class Component extends ComputerDecorator {

    public Component(String descr, double price) {
        super(descr, price);
    } // constructor

    /***
     * Add method to add a component to a computer by extending ComputerDecorator
     * @param descr item description
     * @param price item price
     */
    public void add(String descr, double price) {
        setDescr(getDescription() + " + " + descr);
        setPrice(getPrice() + price);
    }

    /***
     * currentBuild method to print the currentBuild of the order
     * @return string for the order
     */
    public String currentBuild() {
        String str = "";

        str += "Current Build: " + getDescription();
        str += ", and total price is $" + getPrice();

        return str;
    }

    /***
     * toString method to print the current order
     * @return string for the order
     */
    @Override
    public String toString() {
        String str = "";

        str += getOrderID() + ": " + getDescription();
        str += ", and total price is $" + getPrice();

        return str;
    }
}
