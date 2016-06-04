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

/**DonationPackage
 * Holds the information of the package to be donated: description, weight.
 * 
 * @author Surtej
 *
 */
public class DonationPackage {
	String description = "";
	int weight = 0;

	/**DonationPackage
	 * Holds the information of the package to be donated: description, weight.
	 * @param d
	 * @param w
	 */
	public DonationPackage (String d, int w) {
		description = d;
		weight = w;
	}

	/**getDescription
	 * returns the DonationPackage description
	 * @return description
	 */
	public String getDescription(){
		return description;
	}

	/**setDescription
	 * sets the DonationPackage description
	 * @param d
	 */
	public void setDescription(String d){
		description = d;
	}

	/**getWeight
	 * returns the DonationPackage weight
	 * @return weight
	 */
	public String getWeight(){
		return description;
	}

	/**setWeight
	 * sets the DonationPackage weight
	 * @param w
	 */
	public void setWeight(int w){
		weight = w;
	}
	/**toString
	 * returns the description and weight
	 */
	public String toString(){
		return "Description: " + description + " Weight: " + weight;
	}
}
