package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import MeetingSystem.Event;
import MeetingSystem.Place;
import MeetingSystem.User;

import org.junit.Test;

import Application.App;

public class EventTest {
	
	App app = new App();
	Event event = new Event(new User());
	
	@Test
	public void testGetCurrentSlots() {
		event.setCurrentSlots(12);
		int i = event.getCurrentSlots();
		 assertEquals(12, i);
	}

	@Test
	public void testSetCurrentSlots() {
		event.setCurrentSlots(12);
		 assertTrue(event.getCurrentSlots()==12);
	}

	@Test
	public void testIsAccepted() {
		boolean i = event.isAccepted();
		 assertEquals(false, i);
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
		assertTrue(event.getPlace()==place);
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
		assertTrue(event.getDescryption()==desc);
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
		assertTrue(event.getEventCreator()==user234);
	}

	@Test
	public void testGetUserList() {
		User user234 = new User();
		User user235 = new User();
		
		if(event.getUserList().isEmpty()==true)
		{
			app.signUserOnEvent(user234, event);
			app.signUserOnEvent(user235, event);
		if(event.getUserList().contains(user235)==true)
		{
				assertTrue(event.getUserList().contains(user234)==true);
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
