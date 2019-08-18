package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test class for EventDAO class
 * 
 */
public class TestEventDAO {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private ArrayList<Object[]> showAllEvents;
	private EventDAO dao;

	/**
	 * Sets up database connection before other methods are executed in this
	 * class
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Closes the database connection after all the methods are executed
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		/**
		 * @TODO: Close connection object here  
		 */
		
		FERSDataConnection.closeConnection();

	}

	/**
	 * Sets up the objects required in other methods
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		showAllEvents = new ArrayList<Object[]>();
		dao = new EventDAO();
	}

	/**
	 * Deallocate the resources after execution of method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		
		showAllEvents = null;
		dao = null;
	}

	/**
	 * Positive test case to test the method showAllEvents
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testShowAllEvents_Positive() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call showAllEvents method and assert it for
		 * size of returned type list
		 */
		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		
	   eventList  =	dao.showAllEvents();
		
	   assertEquals(8,eventList.size());
		
	}
	
	/**
	 * Junit test case to test positive case for updateEventDeletions
	 * @throws Exception 
	 */
	@Test
	public void testUpdateEventDeletions_Positive() throws Exception {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventDeletions for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
		 */		int before;
		 		int after;
		        connection = FERSDataConnection.createConnection();
		        statement= connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTID=1001");
		        resultSet = statement.executeQuery();
		        resultSet.next();
		       
		        before = resultSet.getInt(1);
		        System.out.println(before);
		        dao.updateEventDeletions(1001, 10001);
		        statement= connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTID=1001");
		      resultSet=  statement.executeQuery();
		        resultSet.next();
			       
		        after = resultSet.getInt(1);
		        System.out.println(after);
	}

	/**
	 * Negative test case for method updateEventDeletions
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdateEventDeletions_Negative() throws ClassNotFoundException, SQLException, Exception {
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 * throw an exception 
		 * */
		
		
		dao.updateEventDeletions(2000, 10001);
	}

	/**
	 * Positive test case for method updateEventNominations
	 * @throws Exception 
	 */
	@Test
	public void testUpdateEventNominations_Positive() throws Exception {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventNominations for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 less then testSeatsAvailableAfter
		 */
		int before;
		int after;
		connection = FERSDataConnection.createConnection();
        statement= connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTID=1001");
        resultSet = statement.executeQuery();
        resultSet.next();
        before = resultSet.getInt(1);
        System.out.println(before);
        dao.updateEventNominations(1001, 10001);
        statement= connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTID=1001");
        resultSet = statement.executeQuery();
        resultSet.next();
        after = resultSet.getInt(1);
        System.out.println(after);
	}

	/**
	 * Negative test case for method updateEventNominations
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdateEventNominations_Negative() throws ClassNotFoundException, SQLException, Exception {
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it should
		 * throw an exception
		 */	
		dao.updateEventNominations(2000, 10001);
	}

	/**
	 * Positive test case for method checkEventsofVisitor
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testCheckEventsOfVisitor_Positive() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call checkEventsofVisitor method by passing this visitor object and
		 * valid eventId
		 * Assert the value of return type 
		 */	
		
				Visitor visitor = new Visitor();
				visitor.setVisitorId(1008);
				boolean status = dao.checkEventsofVisitor(visitor, 2000, 10001);
				assertTrue(status);
				
	}
	
	/**
	 * Junit test case for getEventCoordinator
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testGetEventCoordinator() throws ClassNotFoundException, SQLException{
		/**
		 * @TODO: Call getEventCoordinator method
		 * Assert the size of return type arraylist
		 *
		 */
		List<EventCoordinator> ecl = new ArrayList<EventCoordinator>();
		ecl = dao.getEventCoordinator();
		assertEquals(5,ecl.size());
		
		
		
	}
	
	/**
	 * Junit test case for getEvent
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testGetEvent() throws ClassNotFoundException, SQLException{
		/**
		 * @TODO: Call getEvent method 
		 * Assert the returned Event type with the passed value of event id
		 */		
		
		Event e = new Event();
		e=dao.getEvent(1001, 10001);
		assertEquals(1001,e.getEventid());
		
	}
	
	/**
	 * Junit test case for updateEvent
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testInsertEvent() throws ClassNotFoundException, SQLException{
		/**
		 * @TODO: Create Event object by setting appropriate values
		 * Call insertEvent method by passing this event object
		 * Assert the status of return type of this insertEvent method
		 */	
		Event e= new Event();
		e.setName("Rangoli");
		e.setDescription("haha");
		e.setPlace("dept");
		e.setDuration("2");
		e.setEventtype("game");
		e.setSeatsavailable("2000");
		e.setEventid(1001);
		e.setSessionId(10001);
		e.setEventCoordinatorId(101);
		int status=dao.insertEvent(e);	
		
			
		assertEquals(1,status);
			
			
		
		
		
		
		
	}
	
	/**
	 * Junit test case for updateEvent
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdateEvent() throws ClassNotFoundException, SQLException{
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method
		 * Update the values of event object
		 * Call updateEvent method by passing this modified event as object
		 * Assert the status of return type of updateEvent method
		 */			
		
				int status;	
				Event e = new Event();
				e.setName("xyz");
				e.setDescription("dfdf");
				e.setPlace("kml");
				e.setDuration("2");
				e.setEventtype("dfdsf");
				e.setSeatsavailable("2000");
				e.setEventid(1001);
				e.setSessionId(10001);
				status = dao.updateEvent(e);	
					
				assertEquals(1,status);
					
					
				
					
					
		 
		 
	}
	
	/**
	 * Junit test case for deleteEvent
	 * @throws FERSGenericException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testDeleteEvent() throws ClassNotFoundException, SQLException, FERSGenericException{
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method		 * 
		 * Call deleteEvent method by passing this event id and event session id as object
		 * Assert the status of return type of updateEvent method
		 */	
		
	int status =dao.deleteEvent(1007, 10005);
	assertEquals(1,status);
	
	
	
		
		
		
		
	}

}
