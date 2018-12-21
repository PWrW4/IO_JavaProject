package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import MeetingSystem.Place;

public class PlaceTest {

   
	 Place place = new Place();
	
	@Test
	public void testSetCity() {
		 place.setCity("Miasto");
		 assertTrue(place.getCity()=="Miasto");
	}
	
	@Test
	public void testGetCity() {
		place.setCity("Miasto");
		String name = place.getCity();
		String name1 = "Miasto";
		assertEquals(name1,name);
	}
	
	@Test
	public void testSetAddres() {
		place.setAddres("Test 12/3");
		 assertTrue(place.getAddres()=="Test 12/3");
	}
	
	@Test
	public void testGetAddres() {
		place.setAddres("Test 12/3");
		String name = place.getAddres();
		String name1 = "Test 12/3";
		assertEquals(name1,name);
	}

	@Test
	public void testSetDescryption() {
		place.setDescryption("Klub 1");
		 assertTrue(place.getDescryption()=="Klub 1");
	}
	
	@Test
	public void testGetDescryption() {
		place.setDescryption("Klub 1");
		String name = place.getDescryption();
		String name1 = "Klub 1";
		assertEquals(name1,name);
	}
}
