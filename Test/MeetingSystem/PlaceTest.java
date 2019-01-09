package MeetingSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {


    private Place place = new Place();

    @Test
    void testSetCity() {
        place.setCity("Miasto");
        assertSame("Miasto", place.getCity());
    }

    @Test
    void testGetCity() {
        place.setCity("Miasto");
        String name = place.getCity();
        String name1 = "Miasto";
        assertEquals(name1,name);
    }

    @Test
    void testSetAddres() {
        place.setAddres("Test 12/3");
        assertSame("Test 12/3", place.getAddres());
    }

    @Test
    void testGetAddres() {
        place.setAddres("Test 12/3");
        String name = place.getAddres();
        String name1 = "Test 12/3";
        assertEquals(name1,name);
    }

    @Test
    void testSetDescryption() {
        place.setDescryption("Klub 1");
        assertEquals("Klub 1", place.getDescryption());
    }

    @Test
    void testGetDescryption() {
        place.setDescryption("Klub 1");
        String name = place.getDescryption();
        String name1 = "Klub 1";
        assertEquals(name1,name);
    }
}