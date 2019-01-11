package MeetingSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class PlaceTest {


    private Place place = new Place("wro","plac","na pwr");

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
        place.setAddress("Test 12/3");
        assertSame("Test 12/3", place.getAddress());
    }

    @Test
    void testGetAddres() {
        place.setAddress("Test 12/3");
        String name = place.getAddress();
        String name1 = "Test 12/3";
        assertEquals(name1,name);
    }

    @Test
    void testSetDescryption() {
        place.setDescription("Klub 1");
        assertEquals("Klub 1", place.getDescription());
    }

    @Test
    void testGetDescryption() {
        place.setDescription("Klub 1");
        String name = place.getDescription();
        String name1 = "Klub 1";
        assertEquals(name1,name);
    }
}