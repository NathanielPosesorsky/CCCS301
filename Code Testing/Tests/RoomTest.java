/*
Student Name: Nathaniel Posesorsky
 */

import org.junit.*;

import static org.junit.Assert.*;

public class RoomTest {

    Room doubleRoom;
    Room queenRoom;
    Room kingRoom;
    Room invalidRoom;

    @Before
    public void setUp() {
        doubleRoom = new Room("double");
        queenRoom = new Room("queen");
        kingRoom = new Room("king");
    }

    // Test expects an exception and passes if so, to confirm that invalid room cannot be added
    @Test
    public void addInvalidRoomTest() {
        try {
            new Room("");
            fail("created invalid room type");
        } catch (Exception e) {
            return; // catches the expected exception for invalid room and passes the test
        }
    }

    // Test to confirm that the getType method functions if given a valid room, and returns null if given invalid room
    @Test
    public void getTypeTest() {
        assertEquals("doubleTest", "double", doubleRoom.getType());// assert that method returns double
        assertEquals("queenTest", "queen", queenRoom.getType());// assert that method returns queen
        assertEquals("kingTest", "king", kingRoom.getType());// assert that method returns king
        assertNull("invalidTest", invalidRoom); // assert that method returns null
    }

    // Test to confirm that the getPrice method functions and returns the proper prices
    @Test
    public void getPriceTest() {
        assertEquals(90, doubleRoom.getPrice(),0); // assert that method returns 90
        assertEquals(110, queenRoom.getPrice(),0); // assert that method returns 110
        assertEquals(150, kingRoom.getPrice(),0); // assert that method returns 150
    }

    // Test to confirm that the getAvailability method functions and returns proper availability
    @Test
    public void availabilityTest(){
        assertTrue("doubleRoomAvailabilityTest",doubleRoom.getAvailability());// assert that method returns true
        assertTrue("queenRoomAvailabilityTest",queenRoom.getAvailability());// assert that method returns true
        assertTrue("kingRoomAvailabilityTest",kingRoom.getAvailability());// assert that method returns true
    }

    // Test to confirm that the changeAvailability method properly changes availability of a room
    @Test
    public void changeAvailabilityTest(){
        Room room = new Room("double"); // creates a room that is available
        room.changeAvailability(); // makes the room unavailable
        assertFalse(room.getAvailability()); // assert that method returns false for availability
        room.changeAvailability();// makes the room available
        assertTrue(room.getAvailability()); // assert that method returns true for availability
    }

    // Test to confirm that the findAvailableRoom method doesn't find invalid or unavailable rooms
    @Test
    public void noAvailableRoomTest() {
        // assert that method returns null for invalid room
        assertNull(Room.findAvailableRoom(new Room[]{doubleRoom,queenRoom,kingRoom},"invalidRoom"));
        Room myRoom = new Room("double"); // create a double room
        myRoom.changeAvailability(); // makes the room unavailable
        // assert that the method returns null for unavailable room
        assertNull(Room.findAvailableRoom(new Room[]{myRoom,queenRoom,kingRoom},"double"));
    }

    // Test to confirm that the findAvailableRoom method works properly when given a valid room
    @Test
    public void findAvailableRoomTest(){
        // asserts that the found room is the same as the passed type
        assertEquals("doubleFindAvailableRoomTest",doubleRoom,Room.findAvailableRoom(new Room[]{doubleRoom,queenRoom,kingRoom},"double"));
        assertEquals("queenFindAvailableRoomTest",queenRoom,Room.findAvailableRoom(new Room[]{doubleRoom,queenRoom,kingRoom},"queen"));
        assertEquals("kingFindAvailableRoomTest",kingRoom,Room.findAvailableRoom(new Room[]{doubleRoom,queenRoom,kingRoom},"king"));
    }

}
