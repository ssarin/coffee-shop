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

/**VolunteerLine
 * VolunteerLine class will implement the VolunteerLineInterface.
 * 
 * @author Surtej
 *
 */
public class VolunteerLine implements VolunteerLineInterface{

	//Queue of Volunteer
	private MyQueue <Volunteer> volunteerLine = new MyQueue <Volunteer>();

	@Override
	public boolean addNewVolunteer(Volunteer v) {
		if(volunteerLine.size() < 5) {
			volunteerLine.enqueue(v);
			return true;
		} else{
			return false;

		}
	}


	@Override
	public Volunteer volunteerTurn() throws NoSuchElementException {
		if(volunteerLineEmpty() == true){
			throw new NoSuchElementException();
		} else{
			return volunteerLine.dequeue();
		}
	}

	@Override
	public boolean volunteerLineEmpty() {
		if(volunteerLine.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public Volunteer[] toArrayVolunteer() {
		
		Volunteer [] v = new Volunteer[volunteerLine.size()];
		for(int i=0; i<volunteerLine.size(); i ++){
			v[i] = (Volunteer) volunteerLine.data.get(i);
		}
		
		
		return v;
		
		//return (Volunteer[]) volunteerLine.toArray();
	}




}
