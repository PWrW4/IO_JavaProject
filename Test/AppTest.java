import Application.App;
import MeetingSystem.Event;
import MeetingSystem.User;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @org.junit.jupiter.api.Test
    void searchEvent() {
    }

    @org.junit.jupiter.api.Test
    void addEvent() {
        Event event = new Event(new User());
        App app = new App();

        app.addEvent(event);

        if (app.addEvent(event)){
            assertTrue(app.getEventList().contains(event));
        }
    }

    @org.junit.jupiter.api.Test
    void addEventWhichExist() {
        Event event = new Event(new User());
        App app = new App();

        app.addEvent(event);

        assertFalse(app.addEvent(event));
    }

    @org.junit.jupiter.api.Test
    void acceptEvent() {

        Event event = new Event(new User());

        App app = new App();

        app.acceptEvent(event);

        assertTrue(event.isAccepted());
    }

    @org.junit.jupiter.api.Test
    void removeEvent() {
    }

    @org.junit.jupiter.api.Test
    void signUserOnEvent() {
    }

    @org.junit.jupiter.api.Test
    void checkEvent() {
    }

    @org.junit.jupiter.api.Test
    void signOffUserFromEvent() {
    }

    @org.junit.jupiter.api.Test
    void editEvent() {
    }
}