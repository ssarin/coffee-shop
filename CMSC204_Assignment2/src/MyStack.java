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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**MyStack
 * Generic stack class called MyStack to place the DonationPackage on a Container.
 * MyStack will implement the Stack Interface. 
 * @author Surtej
 *
 * @param <T>
 */
public class MyStack <T> implements StackInterface <T>{

	//int top = -1, size = 5, topLocation = 0;
	//private T[] data;
	ArrayList <Object> data = new ArrayList<Object>();
	
	//List<?>[] data = new List<?>[size];
	//listArr[0] = new ArrayList<String>();

	@Override
	public boolean isEmpty() {
		if(data.size() == 0){
			return true;
		} else{
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if(data.size() == 5){
			return true;
		} else{
			return false;
		}
	}

	@Override
	public T pop() {
		T element = (T) data.get(data.size()-1);
		data.remove(element);
		return element;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean push(T e) {
		return data.add(e);
	}

	@Override
	public T[] toArray() {

		//T [] arr = (T[]) new Object [5];
		/*Object [] arr = new Object [5];;
		for(int i=0; i<data.size(); i++){
			arr[i] = data.get(i) ;
		}
		
		return (T[]) arr;*/
		T[] a = (T[]) data.toArray(new DonationManager[data.size()]);
		//T[] a = (T[]) data.toArray();
		return a;
	}

}
