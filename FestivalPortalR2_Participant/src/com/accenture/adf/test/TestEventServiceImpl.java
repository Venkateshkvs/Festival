package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;

/**
 * Junit test case to test class EventServiceImpl
 * 
 */
public class TestEventServiceImpl {

	private List<Object[]> eventList;
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;

	/**
	 * Set up the objects required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		eventServiceImpl= null;
		visitor = null;
		
	}

	/**
	 * Test case to test the method getAllEvents
	 */
	@Test
	public void testGetAllEvents() {
		/**
		 * @TODO: Call getAllEvents method and assert it for the size of returned array
		 */	
		List<Object[]> al = new ArrayList<Object[]>();
	al  = 	eventServiceImpl.getAllEvents();
	assertEquals(7, al.size());

		
		
		
	}

	/**
	 * Test case to test the method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsofVisitor() {
		/**
		 * @TODO: Call checkEventsofVisitor and assert the returned type of this method
		 * for appropriate return type
		 */	
		boolean status = eventServiceImpl.checkEventsofVisitor(visitor, 1001, 10001);
		assertEquals(false,status);
	}

	/**
	 * Test case to test the method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions() {
		/**
		 * @TODO: Call updateEventDeletions and assert the return type of this method
		 */	
		eventServiceImpl.updateEventDeletions(1001, 10001);
	
	}

	/**
	 * Junit test case for getEventCoordinator
	 */
	@Test
	public void testGetEventCoordinator() {
		/**
		 * @TODO: Call getAllEventCoordinators and assert the size of return type of this method
		 */		
		
		  assertEquals(5, eventServiceImpl.getAllEventCoordinators().size());
	}

	/**
	 * Junit test case for getEvent
	 */
	@Test
	public void testGetEvent() {
		/**
		 * @TODO: Call getEvent and assert the event id of this event with 
		 * passed event id 
		 */		
		  int id = eventServiceImpl.getEvent(1001, 10001).getEventid();
		    assertEquals(1001,id );
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testInsertEvent() {
		/**
		 * @TODO: Call insertEvent
		 * Create event object by setting appropriate values
		 * Assert the status of insertEvent method
		 */		
		   
	    Event event = new Event();
	  
	    event.setName("Sports");
	    event.setDescription("competive");
	    event.setPlace("bangalore");
	    event.setDuration("3 hrs");
	    event.setEventtype("play");
	    
	    assertEquals(0, eventServiceImpl.insertEvent(event));
	    
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call updateEvent method
		 * Assert the status of updateEvent method
		 * 
		 */
		
		Event event = new Event();
	  
	    
	    event.setEventid(1001);
	    event.setEventSession(10001);
	    event.setSeatsavailable("2000");
	  
	    assertEquals(0,eventServiceImpl.updateEvent(event));
	}

	/**
	 * Junit test case for deleteEvent
	 */
	@Test
	public void testDeleteEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call deleteEvent method
		 * Assert the status of deleteEvent method
		 */	
		 assertEquals(1, eventServiceImpl.deleteEvent(1002, 10004));
	}

}
