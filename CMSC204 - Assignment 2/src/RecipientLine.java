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

import java.util.NoSuchElementException;

/**RecipientLine
 * RecipientLine class will implement the RecipientLineInterface  class.
 * @author Surtej
 *
 */
public class RecipientLine implements RecipientLineInterface{

	//Queue of Recipient
	MyQueue <Recipient> recipientLine = new MyQueue <Recipient>();

	@Override
	public boolean addNewRecipient(Recipient rc) {
		if(recipientLine.size() < 5) {
			recipientLine.enqueue(rc);
			return true;

		} else{
			return false;

		}
	}

	@Override
	public Recipient recipientTurn() throws NoSuchElementException {
		if(recipientLineEmpty() == true){
			throw new NoSuchElementException();
		} else{
			return (Recipient) recipientLine.dequeue();
		}
	}

	@Override
	public boolean recipientLineEmpty() {
		if(recipientLine.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public Recipient[] toArrayRecipient() {
		// TODO Auto-generated method stub
		//Recipient[] r = new Recipient[recipientLine.size()];
		
		Recipient [] v = new Recipient[recipientLine.size()];
		for(int i=0; i<recipientLine.size(); i ++){
			v[i] = (Recipient) recipientLine.data.get(i);
		}
		
		return v;
		
		//return (Recipient[]) recipientLine.toArray();
	}


}
