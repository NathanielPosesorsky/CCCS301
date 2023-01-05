

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Nathaniel Posesorsky
 * Student ID:260803332
 * 2022-12-04
 * Main.java
 */

public class Main {
    private static final MarketSpace marketSpace = MarketSpace.getInstance();
    private static Computer computer;

    /***
     * buyComputer method used to buy a computer and accessories
     */
    public static void buyComputer(){
        Component c = new Component("Default Computer", 700); // adds default computer
        int choice; // stores the user choice
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = marketSpace.getProducts(); // gets the products from the products ArrayList
        do {
            System.out.println(c.currentBuild());
            System.out.println("What component would you like to add?");
            // for loop goes through the products ArrayList and prints the options and prices
            for (int i = 1; i <= products.size(); i++) {
                String[] product = products.get(i - 1).split(",");
                System.out.println(i + ": " + product[0] + " $" + product[1]);
            }
            System.out.println((products.size()+1) + ": Done" );
            choice = scanner.nextInt() - 1; // stores user choice
            if (choice < products.size()) { // if choice is within the options
                String[] prodChoice = products.get(choice).split(","); // store the chosen product
                c.add(prodChoice[0], Double.parseDouble(prodChoice[1])); // add the chosen product to the computer order
            }
        } while (choice < products.size()); // gives option to keep adding products until the user choice is "Done"
        marketSpace.getCart().add(c); // add the order to the cart for that Order ID
    }

    /***
     * printCart method to print the current cart for all order IDs
     */
    public static void printCart(){
        System.out.println(marketSpace.getCart().toString());
    }

    /***
     * sortByID method to sort the cart by order IDs
     */
    public static void sortByID(){
        SortByOrderID.sort((ArrayList<Computer>) marketSpace.getCart());
    }

    /***
     * sortByPrice method to sort the cart by the price of all orders
     */
    public static void sortByPrice(){
        SortByPrice.sort((ArrayList<Computer>) marketSpace.getCart());
    }

    public static void main(String[] args) {
        marketSpace.loadProducts();
        Scanner scanner = new Scanner(System.in);

        while (true) { // while scanner input is not 5, it will keep repeating these prints and methods
            System.out.println("Hi, what would you like to do?");
            System.out.println("1: Buy a computer");
            System.out.println("2: See my shopping cart");
            System.out.println("3: Sort by order ID (Descending order)");
            System.out.println("4: Sort by order price (Descending order)");
            System.out.println("5: Quit");
            switch (scanner.nextInt()) {
                case 1: // if case 1, user wants to buy a computer so calls buyComputer method
                    buyComputer();
                    break;
                case 2: // if case 2, user wants to print the cart so calls printCart method
                    printCart();
                    break;
                case 3: // if case 3, user wants to sort the cart by order ID so calls sortByID method
                    sortByID();
                    break;
                case 4: // if case 4, user wants to sort the cart by price so calls sortByPrice method
                    sortByPrice();
                    break;
                case 5: // if case 5, Quit so System.exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid integer. Try again");
            }
        }
    }
}
