package MeetingSystem;

import Application.App;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private App app = new App();
    private Event event = new Event(new User());

    @Test
    void testGetCurrentSlots() {
        event.setCurrentSlots(12);
        int i = event.getCurrentSlots();
        assertEquals(12, i);
    }

    @Test
    void testSetCurrentSlots() {
        event.setCurrentSlots(12);
        assertEquals(12, event.getCurrentSlots());
    }

    @Test
    void testIsAccepted() {
        boolean i = event.isAccepted();
        assertFalse(i);
    }

    @Test
    void testSetAccepted() {
        event.setAccepted(true);
        assertTrue(event.isAccepted());
    }

    @Test
    void testGetPlace() {
        Place place = new Place();
        event.setPlace(place);
        Place i = event.getPlace();
        assertEquals(place, i);
    }

    @Test
    void testSetPlace() {
        Place place = new Place();
        event.setPlace(place);
        assertSame(event.getPlace(), place);
    }

    @Test
    void testGetDescryption() {
        String desc = "abcd efgh";
        event.setDescryption(desc);
        String i = event.getDescryption();
        assertEquals(desc, i);
    }

    @Test
    void testSetDescryption() {
        String desc = "abcd efgh";
        event.setDescryption(desc);
        assertSame(event.getDescryption(), desc);
    }

    @Test
    void testGetEventCreator() {
        User user234 = new User();
        event.setEventCreator(user234);
        User i = event.getEventCreator();
        assertEquals(user234,i);
    }

    @Test
    void testSetEventCreator() {
        User user234 = new User();
        event.setEventCreator(user234);
        assertSame(event.getEventCreator(), user234);
    }

    @Test
    void testGetUserList() {
        User user234 = new User();
        User user235 = new User();

        if(event.getUserList().isEmpty())
        {
            app.signUserOnEvent(user234, event);
            app.signUserOnEvent(user235, event);
            if(event.getUserList().contains(user235))
            {
                assertTrue(event.getUserList().contains(user234));
            }
        }
    }

    @Test
    void testSetUserList() {
        List<User> testuserList = new ArrayList<>();
        event.setUserList(testuserList);
        assertEquals(testuserList, event.getUserList());
    }

}