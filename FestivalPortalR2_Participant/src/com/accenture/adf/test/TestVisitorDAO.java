package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Visitor;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {

	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Object[]> registeredEvents;

	/**
	 * Setting up initial objects
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Object[]>();
	}

	/**
	 * Deallocating objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		visitor = null;
		visitorDAO = null;
		registeredEvents = null;
	}

	/**
	 * Test case for method insertData
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testInsertData() throws ClassNotFoundException, SQLException, Exception {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call insertData method by passing this visitor object
		 * Search this new visitor object by calling searchUser method
		 * Assert the values of username
		 */		
		visitor.setUserName("venky");
		visitor.setPassword("password");
		visitor.setFirstName("konda");
		visitor.setLastName("venkatesh");
		visitor.setEmail("venky@gmail.com");
		visitor.setPhoneNumber("9949209292");
		visitor.setAddress("BANGALORE");
		
		boolean Istatus = visitorDAO.insertData(visitor);
		System.out.println(Istatus);
		assertTrue(Istatus);
		
		
	}	

	/**
	 * Test case for method searchUser
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testSearchUser() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call searchUser method for valid values of username
		 * and password and assert the value of username for the returned type of method
		 */		
		assertEquals("cham", visitorDAO.searchUser("cham", "4567").getUserName());
	}

	/**
	 * Test case for method registerVisitorToEvent
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRegisterVisitorToEvent() throws ClassNotFoundException, SQLException, Exception {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registerVisitorToEvent method
		 * and assert the value
		 */	
		
		visitorDAO.registerVisitorToEvent( visitorDAO.searchUser("cham", "4567"),  1001, 10001);
	}	

	/**
	 * Test case for method registeredEvents
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRegisteredEvents() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registeredEvents method
		 * and assert the value
		 */		
		ArrayList<Object []> al = new ArrayList<Object []>();
		//Object [] o = new Object[10];
		al=visitorDAO.registeredEvents(visitorDAO.searchUser("venky", "pass"));
		
		 
		assertEquals(1,al.size());
	}

	/**
	 * Test case for method updateVisitor
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdateVisitor() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 */		

		visitor=visitorDAO.searchUser("venky", "password");
		visitor.setPhoneNumber("123456");
		assertEquals(1,visitorDAO.updateVisitor(visitor));
		
		
			
	}

	/**
	 * Test case for method registeredEvents
	 * @throws Exception 
	 */
	@Test
	public void testUnregisterEvent() throws Exception {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to unregisterEvent method
		 * and assert the value
		 */		
		visitor=visitorDAO.searchUser("venky", "pass");
		visitorDAO.unregisterEvent(visitor, 1001, 10001);
		
	}
	
	/**
	 * Test case for method change password
	 */
	/*@Test
	public void testChangePassword_VisitorNull() {
		*//**
		 * @TODO: Call changePassword method by passing visitor object as null
		 *//*		
	}*/
	
	/**
	 * Test case for method change password
	 */
	@Test
	public void testChangePassword_VisitorNull() {
		
		int status=0;
		try {
			visitor = null;
			status = visitorDAO.changePassword(visitor);
		} catch (SQLException exception) {
			fail("SQL Exception");
		} catch (ClassNotFoundException exception) {
			fail("Class Not Found Exception");
		} catch (Exception exception) {
			fail("NULL Exception");
		}
		//System.out.println(status);
	assertEquals(-1,status);
	}

}
