/*
Student Name: Nathaniel Posesorsky
 */

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HotelTest {
    Hotel myHotel;
    Room doubleRoom;
    Room queenRoom;
    Room kingRoom;
    Room[] roomList;
    Reservation[] reservations;
    int numOfReservations;

    @Before
    public void setUp() {
        doubleRoom = new Room("double");
        queenRoom = new Room("queen");
        kingRoom = new Room("king");
        roomList = new Room[]{doubleRoom, queenRoom, kingRoom};
        myHotel = new Hotel("myHotel", roomList);
        reservations = new Reservation[roomList.length];
        numOfReservations = 0;
    }

    // Test to confirm output of createReservation method if given invalid room type
    @Test
    public void createReservationWithInvalidRoomTest(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        myHotel.createReservation("Bob", "invalid");
        assertEquals("Sorry Bob, we have no available rooms of the desired type.\r\n",out.toString());
    }

    // Test to confirm functionality of createReservation method if given valid room type
    @Test
    public void createReservationWithValidRoomTest(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        myHotel.createReservation("Bob", "double");
        assertEquals("You have successfully reserved a double room under the name Bob. We look forward having you at myHotel\r\n",out.toString());
    }

    // Test to confirm functionality of createReservation method if given valid available room type
    @Test
    public void createReservationWithValidRoomAndAvailableReservationTest(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        myHotel.createReservation("Bob", "double");
        assertEquals("You have successfully reserved a double room under the name Bob. We look forward having you at myHotel\r\n",out.toString());
    }

    // Test to confirm functionality of cancelReservation method on valid reservation
    @Test
    public void cancelReservationTest(){
        myHotel.createReservation("Bob", "double"); // create reservation
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        myHotel.cancelReservation("Bob","double"); // cancel reservation
        // assert expected string after cancelling reservation
        assertEquals("Bob, your reservation for a doubleroom has been successfully cancelled.\r\n",out.toString());
    }

    // Test to confirm functionality of cancelReservation method on invalid reservation
    @Test
    public void cancelInvalidReservationTest(){
        myHotel.createReservation("Bob", "double"); // create valid reservation
        try {
            myHotel.cancelReservation("Bob","invalid"); // attempt to cancel invalid reservation
        } catch (Exception e) { // exception caught and test passes
            return;
        }
    }

    // Test to confirm the functionality of printInvoice method for valid reservation
    @Test
    public void printInvoiceTest(){
        myHotel.createReservation("Bob", "double"); // create reservation
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        myHotel.printInvoice("Bob"); // print invoice for that reservation
        // assert expected string
        assertEquals("Bob's invoice is of $90.0\r\n",out.toString());
    }

    // Test to confirm the functionality of printInvoice method for valid reservation while ignoring capital letters
    @Test
    public void printInvoiceIgnoreCaseTest(){
        myHotel.createReservation("BOB", "double");// create reservation
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        myHotel.printInvoice("bob");// print invoice for that reservation
        // assert expected string
        assertEquals("bob's invoice is of $90.0\r\n",out.toString());
    }

    // Test to confirm the functionality of toString method
    @Test
    public void toStringTest(){
        String expected = "Hotel name: myHotel\nAvailable Rooms: 1 double, 1 queen, 1 king.";
        String actual = myHotel.toString(); // myHotel contains 1 double, 1 queen, 1 king
        // assert both strings are equal
        assertEquals(expected,actual);
    }

    // Test to confirm the functionality of toString method when a room is unavailable
    @Test
    public void toStringWithUnavailableRoomsTest(){
        String expected = "Hotel name: myHotel\nAvailable Rooms: 1 double, 1 queen, 0 king.";
        myHotel.createReservation("Bob", "king"); // make reservation for king -> unavaialble room
        String actual = myHotel.toString();
        // assert both strings are equal
        assertEquals(expected,actual);
    }
}
