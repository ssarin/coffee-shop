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


/** Interface for a generic Stack data structure
 * 
 * @author JMYERS
 *
 * @param <T> data type
 */
public interface StackInterface<T> {

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull();


	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop();

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size();

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e);

	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	public T[] toArray();

}