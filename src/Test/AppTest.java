package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Application.App;
import MeetingSystem.Event;
import MeetingSystem.User;

public class AppTest {
	
	App app = new App();
	Event event = new Event(new User());

	@Test
	public void testAddEvent() {
		
		 app.addEvent(event);

	        if (app.addEvent(event)){
	            assertTrue(app.getEventList().contains(event));
	        }
	}
	
	@Test
	public void testAddEventWhichExist() {
        
        app.addEvent(event);

        assertFalse(app.addEvent(event));
    }
	
	@Test
	 public void testSignUserOnEvent(){
		
        User user = new User();
        
        event.setMaxSlots(12);
        event.setCurrentSlots(0);
        
        app.signUserOnEvent(user, event);
        
        
        assertTrue(event.getUserList().contains(user)==true);
    }
	
	@Test
	public void testSignOffUserFromEvent(){
		User user = new User();
        
        event.setMaxSlots(12);
        event.setCurrentSlots(0);
        
        app.signUserOnEvent(user, event);
        app.signOffUserFromEvent(user, event);
          
        assertFalse(event.getUserList().contains(user)==true);
    }
	@Test
	public void testAcceptEvent() {
		 app.acceptEvent(event);

	        assertTrue(event.isAccepted());
	}
	
	@Test
	 public void testSearchEventsReturnsTrue()
    {
    	app.addEvent(event);
    	boolean i = app.searchEventReturnsTrue(event);
    	
    	assertEquals(true, i);
    	//assertEquals(false, i);
    } 
	
	@Test
	public void testRemoveEvent(){
		
		app.addEvent(event);
        app.removeEvent(event);
        
        assertFalse(app.getEventList().contains(event));
	}
}