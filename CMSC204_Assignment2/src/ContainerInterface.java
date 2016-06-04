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

/**
 * Container Interface represents the interface for the Container Class

 * The class that uses this  interface uses a Stack of DonationPackage to simulate stacking and removing DonationPackages
 * to and from the container.
 * @author khandan Monshi
 *
 */

public interface ContainerInterface {

	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 */
	public boolean loadContainer(DonationPackage dPackage);

	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws EmptyStackException an EmptyStackException if there is no package in
	 * the container.
	 */

	public  DonationPackage removePackageFromContainer() throws EmptyStackException;

	/**
	 * Returns an array of the DonationPackage in the stack
	 * @return an array of the DonationPackage in the stack
	 */
	public DonationPackage[] toArrayPackage();

}