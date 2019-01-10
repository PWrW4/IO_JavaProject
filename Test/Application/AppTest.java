package Application;

import MeetingSystem.Builders.EventBuilder;
import MeetingSystem.Event;
import MeetingSystem.Place;
import MeetingSystem.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private App app = new App();
    private Event event=initEvent();




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
    void testAddEvent() {


        app.addEvent(event);

        if (app.addEvent(event)){
            assertTrue(app.getEventList().contains(event));
        }
    }

    @Test
    void testAddEventWhichExist() {

        app.addEvent(event);

        assertFalse(app.addEvent(event));
    }

    @Test
    void testSignUserOnEvent(){

        User user = new User();

        event.setMaxSlots(12);
        event.setCurrentSlots(0);

        app.signUserOnEvent(user, event);


        assertTrue(event.getUserList().contains(user));
    }

    @Test
    void testSignUserOnEventFull(){

        User user = new User();

        event.setMaxSlots(12);
        event.setCurrentSlots(12);

        app.signUserOnEvent(user, event);


        assertFalse(event.getUserList().contains(user));
    }

    @Test
    void testSignOffUserFromEvent(){
        User user = new User();

        event.setMaxSlots(12);
        event.setCurrentSlots(0);

        app.signUserOnEvent(user, event);
        app.signOffUserFromEvent(user, event);

        assertFalse(event.getUserList().contains(user));
    }

    @Test
    void testSignOffUserFromEventUnsigned(){
        User user = new User();

        event.setMaxSlots(12);
        event.setCurrentSlots(0);

        app.signOffUserFromEvent(user, event);

        assertFalse(event.getUserList().contains(user));
    }

    @Test
    void testAcceptEvent() {
        app.acceptEvent(event);

        assertTrue(event.isAccepted());
    }

    @Test
    void testSearchEventsReturnsTrue()
    {
        app.addEvent(event);
        boolean i = app.isEventExisting(event);

        assertTrue(i);
        //assertEquals(false, i);
    }

    @Test
    void testRemoveEvent(){

        app.addEvent(event);
        app.removeEvent(event);

        assertFalse(app.getEventList().contains(event));
    }


    @Test
    void testRemoveNotExistingEvent(){

        app.removeEvent(event);

        assertFalse(app.getEventList().contains(event));
    }
}