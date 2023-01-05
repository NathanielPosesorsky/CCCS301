/*
Student Name: Nathaniel Posesorsky
 */

import org.junit.*;

import static org.junit.Assert.*;

public class ReservationTest {

    Reservation myReservation;
    Room myRoom;

    @Before
    public void setUp() {
        // create a reservation using room myRoom and a name roomName
        myReservation = new Reservation(myRoom,"roomName");
    }

    // Test to confirm that the getName method functions properly and returns the roomName
    @Test
    public void getNameTest() {
        assertEquals("roomName", myReservation.getName());
    }

    // Test to confirm that the getRoom method functions properly and returns myRoom
    @Test
    public void getRoomTest() {
        assertEquals(myRoom, myReservation.getRoom());
    }

}
