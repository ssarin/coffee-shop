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

/**
 * The DonationManager class  will manage adding a new package to the container, a new volunteer to the volunteer queue line , a new recipient to the recipient queue and donating  package by the volunteer to the recipient.  
 * DonationManager will implement the interface DonationManager Interface.  
 * @author Surtej
 *
 */
public class DonationManager implements DonationManageInterface{

	//Instantiating a new RecipientLine class object rl
	RecipientLine rl = new RecipientLine();
	//Instantiating a new VolunteerLine class object vl
	VolunteerLine vl = new VolunteerLine();
	//Instantiating a new Container class object c
	Container c = new Container();

	@Override
	public boolean ManagerLoadcontainer(DonationPackage dPackage) throws ContainerException {

		//Check if loadContainer is false
		//throw ContainerException
		if(c.loadContainer(dPackage) == false){
			throw new ContainerException("Container Stack is full");
		} else{
			return true;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public boolean ManagerQueueVolunteer(Volunteer v) throws VolunteerException {
		//Check if addNewVolunteer is false
		//throw VolunteerException
		if(vl.addNewVolunteer(v) == false){
			throw new VolunteerException("Volunteer Line is full");
		} else{
			return true;
		}

		// TODO Auto-generated method stub
	}

	@Override
	public boolean ManagerQueueRecipient(Recipient r) throws RecipientException {
		//Check if addNewRecipient is false
		//throw RecipientException
		if(rl.addNewRecipient(r) == false){
			throw new RecipientException("Recipient Line is full");
		}else{
			return true;
		}

		// TODO Auto-generated method stub
	}

	//Retrieve stack and queue array
	public DonationPackage[] managerArrayPackage(){
		return c.toArrayPackage();
	}
	public Volunteer [] managerArrayVolunteer(){
		return vl.toArrayVolunteer();
	}
	public Recipient [] managerArrayRecipient(){
		return rl.toArrayRecipient();
	}

	@Override
	public int donatePackage() {
		
		//return if the volunteer, recipient, or container is empty
		//otherwise return 0 if none are empty

		Volunteer vol;
		
		if(vl.volunteerLineEmpty() == true){
			return 1;
		} else if(rl.recipientLineEmpty() == true){
			return 2;
		} else if (c.ContainerEmpty() == true) {
			return 3;
		} else{
			//donate package
			//empty the container
			c.removePackageFromContainer();
			//dequeue recipient line
			rl.recipientTurn();
			//VolunteerLine array index 0
			vol = managerArrayVolunteer()[0];
			//vol = vl.toArrayVolunteer()[0];
			//dequeue volunteer line
			vl.volunteerTurn();	
			//add volunteer
			vl.addNewVolunteer(vol);
			//System.out.print("hello");
			return 0;
		}
	}
}

