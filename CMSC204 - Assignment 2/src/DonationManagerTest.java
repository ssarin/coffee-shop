/**Assignment 2
 * Office Depo is an office supply retailing company donates its surpluses to colleges at the end of each year.
 * In the program volunteers will help deliver packages of supplies to representative of colleges (Recipient of supplies).
 * This application simulates delivering packages from the container of packages by the volunteers to recipients.  
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/18/2016
 * 
 * @author	Surtej
 * 
 */

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi
 *
 */
public class DonationManagerTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	@Test
	public void testManagerLoadcontainer()   {
	
		try {
			manager.ManagerLoadcontainer(new DonationPackage("Pens",12));
			manager.ManagerLoadcontainer(new DonationPackage("Books",12));
			manager.ManagerLoadcontainer(new DonationPackage("NoteBooks",11));
			manager.ManagerLoadcontainer(new DonationPackage("chairs",20));
			manager.ManagerLoadcontainer(new DonationPackage("laptop",14));
			 
			 
		} catch (ContainerException e) {
			fail("Should not throw exception ");
		}	 	 
	}
	 
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.ManagerQueueVolunteer(new  Volunteer("John"));
			manager.ManagerQueueVolunteer(new  Volunteer("Adam"));
			manager.ManagerQueueVolunteer(new  Volunteer("Nichole"));
			manager.ManagerQueueVolunteer(new  Volunteer("Allan"));
			manager.ManagerQueueVolunteer(new  Volunteer("Mary"));
			manager.ManagerQueueVolunteer(new  Volunteer("David"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e);
		}
	 
	}

	/**
	 * Test method for  ManagerQueueRecipient, should be implemented by STUDENTS
	 */
	@Test
	public void testManagerQueueRecipientSTUDENT() {
		try {
			manager.ManagerQueueRecipient(new  Recipient("John"));
			manager.ManagerQueueRecipient(new  Recipient("Adam"));
			manager.ManagerQueueRecipient(new  Recipient("Nichole"));
			manager.ManagerQueueRecipient(new  Recipient("Allan"));
			manager.ManagerQueueRecipient(new  Recipient("Mary"));
			manager.ManagerQueueRecipient(new  Recipient("David"));

		} catch (RecipientException e) {

			System.out.println(e);
		}
	}

 
	@Test
	public void testDonatePackage() {
	    Volunteer v1;
	    Recipient r1;
	    DonationPackage d1,d2;
	    
	    v1 = new Volunteer("Monica"); 
		r1 =  new Recipient("MC College");
		
		d1 =  new DonationPackage("Pens",10);
		d2 =  new DonationPackage("Books",20);
		
		try {
			manager.ManagerLoadcontainer(d1);
			manager.ManagerLoadcontainer(d2);
			assertEquals(manager.donatePackage(),1 );  //There are no volunteers in the queue
			
			manager.ManagerQueueVolunteer(v1);    //add a volunteer
			assertEquals(manager.donatePackage(),2 );  // There are no recipients in the queue
			
			manager.ManagerQueueRecipient(r1);   //Add a recipient
			assertEquals(manager.donatePackage(),0);    // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line.
			
			assertEquals(manager.donatePackage(),2); //There is no recipient in the queue
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

}