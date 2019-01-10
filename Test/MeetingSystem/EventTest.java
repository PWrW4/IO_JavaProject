package MeetingSystem;

import Application.App;
import MeetingSystem.Builders.EventBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private App app = new App();
    private Event event = initEvent();

    private Event initEvent(){
        String name = "a";
        String time = "jutro";
        int minSlots = 1;
        int maxSlots = 10;

        String desc = "b";
        Place p = new Place("wro","plac","na pwr");
        String theme = "t";

        EventBuilder eventBuilder = new EventBuilder(name,new User(),minSlots,maxSlots,time);
        Event e = eventBuilder.build();

        return e;
    }

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
        Place place = new Place("wro","plac","na pwr");
        event.setPlace(place);
        Place i = event.getPlace();
        assertEquals(place, i);
    }

    @Test
    void testSetPlace() {
        Place place = new Place("wro","plac","na pwr");
        event.setPlace(place);
        assertSame(event.getPlace(), place);
    }

    @Test
    void testGetDescryption() {
        String desc = "abcd efgh";
        event.setDescription(desc);
        String i = event.getDescription();
        assertEquals(desc, i);
    }

    @Test
    void testSetDescryption() {
        String desc = "abcd efgh";
        event.setDescription(desc);
        assertSame(event.getDescription(), desc);
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