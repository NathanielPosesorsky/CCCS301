/*
Student Name: Nathaniel Posesorsky
Student ID:260803332
 */

import org.junit.*;

import static org.junit.Assert.*;

public class BookingSystemTest {

    // Test to confirm that the createRooms method functions
    @Test
    public void createRoomsTest(){
        int numOfRooms = BookingSystem.getRandomNumberOfRooms(); // assigns random number of rooms
        Room[] roomList = BookingSystem.createRooms(numOfRooms); // create random number of rooms and assign to roomList
        assertEquals(roomList.length,numOfRooms); // assert that roomList length is the same as the number of rooms
        for(Room r: roomList){
            // for very room in roomList, assert not null
            assertNotNull("Asserting room is not null",r);
        }
    }

    // Test to confirm that when creating a BookingSystem, it is not null
    @Test
    public void bsTest() {
        BookingSystem bs = new BookingSystem();
        assertNotNull(bs);
    }


}
