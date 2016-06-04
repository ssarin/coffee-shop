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

import java.util.ArrayList;
import java.util.LinkedList;

/**MyQueue
 * Generic queue class called MyQueue to implement the queue of volunteers and recipients line.
 * MyQueue will implement the QueueInterface. 
 * 
 * @author Surtej
 *
 * @param <T>
 */
public class MyQueue <T> implements QueueInterface<T> {

	//int size = 5, numOfNodes = 0, front = 0, frontLocation = 0, rear = 0;
	//ArrayList <T> data = new ArrayList<T>();
	LinkedList<Object> data = new LinkedList<Object>();

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public T dequeue() {
		T t = null;
		if(data.isEmpty() == false){
			t = (T) data.removeFirst();
		}
		return t;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean enqueue(T e) {
		if(data.size() <= 5){
			data.addLast(e);
			return true;
		} else{
			return false;
		}

	}

	@Override
	public T[] toArray() {

		/*T [] arr = (T[]) new Object [5];

		for(int i=0; i<data.size(); i++){
			arr[i] = data.get(i) ;
		}

		return arr;

		//return (T[]) data.toArray();
		 *
		 */

		//T [] arr = (T[]) new Object [5];
		/*Object [] arr = new Object [5];;
		for(int i=0; i<data.size(); i++){
			arr[i] = data.get(i) ;
		}

		return (T[]) arr;*/
		
		//T[] a = (T[]) data.toArray();
		T[] a = (T[]) data.toArray(new Object[data.size()]);
		//		T[] a = (T[]) data.toArray(new Volunteer[data.size()]);
		return a;
		
	}

}
