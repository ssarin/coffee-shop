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
import java.util.EmptyStackException;

/**Container
 * This class uses a Stack of DonationPackage to simulate stacking and removing DonationPackages to and from the container.
 * 
 * @author Surtej
 *
 */
public class Container implements ContainerInterface {

	//Stack of DonationPackage
	private MyStack <DonationPackage> containerLine = new MyStack <DonationPackage>();

	@Override
	public boolean loadContainer(DonationPackage dPackage) {
		//check if containerLine size is less than 5
		//if true push the donation package onto the stack containerLine
		//if false return false
		if(containerLine.isFull() == false) {
			containerLine.push(dPackage);
			return true;
		} else{
			return false;
		}

	}

	@Override
	public DonationPackage removePackageFromContainer() throws EmptyStackException {
		//check if ContainerEmpty is false
		//if false pop the donation package from the stack containerLine
		//if true throw EmptyStackException
		if(ContainerEmpty() == false) {
			return (DonationPackage) containerLine.pop();
		} else{
			throw new EmptyStackException();
		}
	}

	/**ContainerEmpty
	 * This class returns true if the stack containerLine is empty and false if it is not empty
	 * @return
	 */
	public boolean ContainerEmpty(){
		if(containerLine.isEmpty()){
			return true;
		}
		return false;
	}


	@Override
	public DonationPackage[] toArrayPackage() {

		DonationPackage [] v = new DonationPackage[containerLine.size()];
		for(int i=0; i<containerLine.size(); i ++){
			v[i] = (DonationPackage) containerLine.data.get(i);
		}
		
		return v;
		
		//return (DonationPackage[]) containerLine.toArray();

	}
}
