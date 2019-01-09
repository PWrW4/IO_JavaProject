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
    public void testGetCurrentSlots() {
        event.setCurrentSlots(12);
        int i = event.getCurrentSlots();
        assertEquals(12, i);
    }

    @Test
    public void testSetCurrentSlots() {
        event.setCurrentSlots(12);
        assertEquals(12, event.getCurrentSlots());
    }

    @Test
    public void testIsAccepted() {
        boolean i = event.isAccepted();
        assertFalse(i);
    }

    @Test
    public void testSetAccepted() {
        event.setAccepted(true);
        assertTrue(event.isAccepted());
    }

    @Test
    public void testGetPlace() {
        Place place = new Place();
        event.setPlace(place);
        Place i = event.getPlace();
        assertEquals(place, i);
    }

    @Test
    public void testSetPlace() {
        Place place = new Place();
        event.setPlace(place);
        assertSame(event.getPlace(), place);
    }

    @Test
    public void testGetDescryption() {
        String desc = "abcd efgh";
        event.setDescryption(desc);
        String i = event.getDescryption();
        assertEquals(desc, i);
    }

    @Test
    public void testSetDescryption() {
        String desc = "abcd efgh";
        event.setDescryption(desc);
        assertSame(event.getDescryption(), desc);
    }

    @Test
    public void testGetEventCreator() {
        User user234 = new User();
        event.setEventCreator(user234);
        User i = event.getEventCreator();
        assertEquals(user234,i);
    }

    @Test
    public void testSetEventCreator() {
        User user234 = new User();
        event.setEventCreator(user234);
        assertSame(event.getEventCreator(), user234);
    }

    @Test
    public void testGetUserList() {
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
    public void testSetUserList() {
        List<User> testuserList = new ArrayList<>();
        event.setUserList(testuserList);
        assertEquals(testuserList, event.getUserList());
    }

}