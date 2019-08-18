package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;

/**
 * Junit test class for VisitorServiceImpl
 *
 */
public class TestVisitorServiceImpl {

	private List<Event> visitorList;	
	private Visitor visitor;
	private VisitorServiceImpl visitorServiceImpl;

	/**
	 * Set up the initial methods 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		visitorServiceImpl = new VisitorServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		
		visitorServiceImpl = null;
		visitor = null;
		
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testCreateVisitor() {
		/**
		 * @TODO: Set the appropriate values for visitor object and
		 * call the method createVisitor by passing an argument of this visitor 
		 * object and then asserting the returned type of this method
		 */		
		visitor.setUserName("cham");
		visitor.setPassword("4567");
		visitor.setFirstName("mangala");
		visitor.setLastName("raj");
		visitor.setEmail("pranay@gmail.com");
		visitor.setPhoneNumber("9949209290");
		visitor.setAddress("BANGALORE");
		assertTrue(visitorServiceImpl.createVisitor(visitor));
		
		
		
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testSearchVisitor() {
		/**
		 * @TODO: Call searchVisitor method by passing the appropriate arguments 
		 * and then asserting the returned type visitor username with the argument passed
		 */		
		
		assertEquals("pranay", visitorServiceImpl.searchVisitor("pranay", "1234").getUserName());
		
		
	}

	/**
	 * Test case for method RegisterVisitor
	 */
	@Test
	public void testRegisterVisitor() {
		/**
		 * @TODO: Call RegisterVisitor method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of RegisterVisitor method 
		 */		
		visitorServiceImpl.RegisterVisitor(visitorServiceImpl.searchVisitor("venky", "password"),  1006, 10006);
	}

	/**
	 * Test case for method showRegisteredEvents
	 */
	@Test
	public void testShowRegisteredEvents() {
		/**
		 * @TODO: Call showRegisteredEvents method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of showRegisteredEvents method 
		 */		
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		showEvents = visitorServiceImpl.showRegisteredEvents(visitorServiceImpl.searchVisitor("venky", "password"));
				assertEquals(2,showEvents.size());
	}

	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetails() {
		/**
		 * @TODO: Call updateVisitorDetails method by passing the visitor object which
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of updateVisitorDetails
		 */		
		int status;
		status = visitorServiceImpl.updateVisitorDetails(visitorServiceImpl.searchVisitor("venky", "password"));
					assertEquals(1,status);
	}

	/**
	 * Test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Call unregisterEvent method by passing the visitor object which can be
		 * retrieved using searchVisitor method and then asserting the returned type 
		 * of unregisterEvent
		 */		
		
		visitorServiceImpl.unregisterEvent(visitorServiceImpl.searchVisitor("venky", "password"),1005,10005);
	}

}
