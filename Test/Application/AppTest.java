package Application;

import Helpers.SearchType;
import MeetingSystem.Builders.EventBuilder;
import MeetingSystem.Event;
import MeetingSystem.Place;
import MeetingSystem.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private App app;
    private Event event;

    private String name = "a";
    private String time = "jutro";
    private int minSlots = 1;
    private int maxSlots = 10;

    String desc = "b";
    Place p = new Place("wro","plac","na pwr");
    String theme = "t";


    private Event initEvent(){
        EventBuilder eventBuilder = new EventBuilder(name,new User(),minSlots,maxSlots,time);
        Event e = eventBuilder.build();

        return e;
    }

    @Test
    void testSearchName(){
        app = new App();
        event = initEvent();
        app.addEvent(event);

        assertEquals(app.searchEvent(SearchType.Name, name), event);
    }

    @Test
    void testSearchPlace(){
        app = new App();
        event = initEvent();
        event.setPlace(p);
        app.addEvent(event);

        assertEquals(app.searchEvent(SearchType.Place, p.toString()), event);
    }

    @Test
    void testSearchNullPlace(){
        app = new App();
        event = initEvent();
        app.addEvent(event);

        assertNull(app.searchEvent(SearchType.Place, p.toString()));
    }

    @Test
    void testSearchHost(){
        app = new App();
        event = initEvent();
        app.addEvent(event);

        assertEquals(app.searchEvent(SearchType.HostUser, event.getEventCreator().toString()), event);
    }

    @Test
    void testSearchTimeDate(){
        app = new App();
        event = initEvent();
        app.addEvent(event);

        assertEquals(app.searchEvent(SearchType.Date, time), event);
    }

    @Test
    void testAddEvent() {
        app = new App();
        event = initEvent();
        app.addEvent(event);

        if (app.addEvent(event)){
            assertTrue(app.getEventList().contains(event));
        }
    }

    @Test
    void testAddEventWhichExist() {
        app = new App();
        event = initEvent();
        app.addEvent(event);
        assertFalse(app.addEvent(event));
    }

    @Test
    void testSignUserOnEvent(){
        app = new App();
        User user = new User();
        event = initEvent();

        event.setMaxSlots(12);
        event.setCurrentSlots(0);

        app.signUserOnEvent(user, event);


        assertTrue(event.getUserList().contains(user));
    }

    @Test
    void testSignUserOnEventFull(){
        app = new App();
        User user = new User();
        event = initEvent();

        event.setMaxSlots(12);
        event.setCurrentSlots(12);

        app.signUserOnEvent(user, event);


        assertFalse(event.getUserList().contains(user));
    }

    @Test
    void testSignOffUserFromEvent(){
        app = new App();
        User user = new User();
        event = initEvent();

        event.setMaxSlots(12);
        event.setCurrentSlots(0);

        app.signUserOnEvent(user, event);
        app.signOffUserFromEvent(user, event);

        assertFalse(event.getUserList().contains(user));
    }

    @Test
    void testSignOffUserFromEventUnsigned(){
        app = new App();
        User user = new User();
        event = initEvent();

        event.setMaxSlots(12);
        event.setCurrentSlots(0);

        app.signOffUserFromEvent(user, event);

        assertFalse(event.getUserList().contains(user));
    }

    @Test
    void testAcceptEvent() {
        app = new App();
        event = initEvent();
        app.acceptEvent(event);

        assertTrue(event.isAccepted());
    }

    @Test
    void testRemoveEvent(){
        app = new App();
        event = initEvent();

        app.addEvent(event);
        app.removeEvent(event);

        assertFalse(app.getEventList().contains(event));
    }


    @Test
    void testRemoveNotExistingEvent(){
        app = new App();
        event = initEvent();


        app.removeEvent(event);

        assertFalse(app.getEventList().contains(event));
    }

    @Test
    void testCheckEvent(){
        app = new App();
        event = initEvent();
        event.setMinSlots(2);
        event.setCurrentSlots(1);
        app.addEvent(event);
        app.checkAndRemoveSlotsEvent(event);

        assertFalse(app.getEventList().contains(event));
    }

    @Test
    void testValidateEventMinMax(){
        app = new App();
        event = initEvent();
        event.setMinSlots(2);
        event.setMaxSlots(1);
        app.addEvent(event);

        assertFalse(app.getEventList().contains(event));
    }

    @Test
    void testValidateEventNoName(){
        app = new App();
        event = initEvent();
        event.setName("");
        app.addEvent(event);

        assertFalse(app.getEventList().contains(event));
    }

    @Test
    void testValidateEventCorrect(){
        app = new App();
        event = initEvent();
        app.addEvent(event);

        assertTrue(app.getEventList().contains(event));
    }

    @Test
    void testValidateEventTimeNull(){
        app = new App();
        event = initEvent();
        event.setTime("");
        app.addEvent(event);

        assertFalse(app.getEventList().contains(event));
    }
}