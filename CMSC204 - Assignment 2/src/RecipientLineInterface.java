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


/** RecipientLineInterface Container Interface represents the interface for the RecipientLine Class

 * The class that uses this  interface uses a Queue of Recipients to simulate queuing and dequeuing Recipients
 * to and from the RecipientLine.
 * @author khandan Monshi
 *
 */
import java.util.NoSuchElementException;


public interface RecipientLineInterface {

	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully , false if queue is full
	 */
	public boolean  addNewRecipient(Recipient rc );

	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws NoSuchElementException if there is no Recipient in the line
	 */

	public  Recipient recipientTurn ()  throws NoSuchElementException ;

	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	public  boolean recipientLineEmpty();

	/**
	 * Returns an array of the Recipients in the queue
	 * @return an array of the Recipients in the queue
	 */
	public Recipient[] toArrayRecipient();


}