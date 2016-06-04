/**Assignment 3
 * 
 * The assignment is to write a generic doubly-linked list class and a generic sorted doubly-linked list class that inherits from your generic doubly-linked class.
 * There is no additional GUI required for this assignment.
 * The list classes will be tested with Junit tests.
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/28/2016
 * 
 * @author	Surtej
 * 
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**BasicDoubleLinkedList
 * 
 * This generic double-linked list relies on a head (reference to first element of the list) and tail (reference to the last element of the list). 
 * Both are set to null when the list is empty. Both point to the same element when there is only one element in the list.
 * A node structure has only three fields: data and the prev and next references.
 * The class must only define the following entities: an inner class Node, an inner class that implements ListIterator (for the iterator method), head and tail references and an integer representing the list size.
 * However only the hasNext(), next(), hasPrevious() and previous() methods of ListIterator need to be implemented, all other methods can throw the UnsupportedOperationException:
 * 
 * @author Surtej
 *
 * @param <T>
 */
public class BasicDoubleLinkedList <T> extends java.lang.Object implements java.lang.Iterable<T>{

	//size of the linkedList
	protected int listSize;
	//reference to first element of the list
	protected Node head;
	//reference to last element of the list
	protected Node tail;

	/** default constructor
	 * sets the size to 0
	 */
	public BasicDoubleLinkedList(){
		listSize = 0;
		//	head = new Node();
		//	tail = new Node();
		//	head.next = tail;
		//	tail.prev = head;
	}

	/**Node class
	 * creates the data, next and prev
	 * @author Surtej
	 *
	 */
	public class Node{

		//Generic type data
		T data;
		//Nodes for next and prev
		Node next;
		Node prev;

		//Node parameterized constructor
		Node(T data, Node next, Node prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		//		Node(T data){
		//			this.data = data;
		//		}
	}

	/**Return the size of the linkedList
	 * 
	 * @return size
	 */
	public int getSize(){
		//return size of LinkedList
		return listSize;
	}

	/**Return if the linkedList is or is not empty
	 * 
	 * @return true or false
	 */
	public boolean isEmpty(){
		//check if list size equals zero
		if(listSize == 0){
			return true;
		}
		return false;
	}

	/**Add an element to the front of the linkedList
	 * 
	 * @param data
	 * @return this
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){

		//creates a new node
		Node temp = new Node(data, head, null);

		//check if head is not empty
		if(head != null){
			//sets the previous node to temp
			head.prev = temp;
		}

		//sets head to the temp
		head = temp;

		//check if tail is null
		if(tail == null){
			//sets tail to temp
			tail = temp;
		}

		//increase list size
		listSize++;
		return this;
		//return (BasicDoubleLinkedList<T>) temp.data;
	}

	/**Add an element to the end of the linkedList
	 * 
	 * @param data
	 * @return this
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){

		//creates a new node
		Node temp = new Node(data, null, tail);

		//check if tail is not empty
		if(tail != null){
			//set tail.next to temp
			tail.next = temp;
		}

		//assign temp to tail
		tail = temp;

		//check if head is null
		if(head == null){
			//assign temp to head
			head = temp;
		}

		//increase the list size
		listSize++;
		return this;
		//return (BasicDoubleLinkedList<T>) temp.data;

		//		while(temp.next != null){
		//			temp = temp.next;
		//		}	
	}

	/**Returns but does not remove the first element from the list.
	 * 
	 * @return head.data
	 */
	public T getFirst(){
		//call isEmpty method which returns if list is empty
		if(isEmpty() == true){
			return null;
		}
		//return the first element
		return head.data;
	}

	/**Returns but does not remove the last element from the list.
	 * 
	 * @return tail.data
	 */
	public T getLast(){
		//call isEmpty method which returns if list is empty
		if(isEmpty()==true){
			return null;
		}
		//return the last element
		return tail.data;
	}

	/** iterator method calls iterateList method
	 *  @return new iterateList();
	 */
	public java.util.ListIterator<T> iterator() throws java.lang.UnsupportedOperationException, java.util.NoSuchElementException{
		//call to the inner class that implements ListIterator
		return new iterateList();

	}

	/**iterateList method is implemented as an inner class that implements ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous().	 * 
	 *
	 * @author Surtej
	 *
	 */
	public class iterateList implements java.util.ListIterator<T> {

		//implement hasNext(), next(), hasPrevious() and previous()

		//Node is assigned the first/head element
		private Node N = head;
		//Node is assigned the last/tail element
		private Node N2 = tail;
		//set boolean variables to true
		//represents the first occurence
		boolean firstNode = true;
		boolean lastNode = true;

		/**Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
		 * @return true or false
		 */
		public boolean hasNext() {
			return (N.next != null);
		}

		/**Returns the next element in the iteration.
		 * 
		 * @return N.data
		 */
		public T next() {
			if (hasNext() == false){
				throw new NoSuchElementException();
			} else {
				//if it is the first element then return that element
				if(firstNode == true){
					//set firstNode to false meaning N.next
					firstNode = false;
					return N.data;
				} else{
					N = N.next;
					return N.data;
				}
				//return N.next.data;
			}
		}

		//Returns the previous element in the list and moves the cursor position backwards.
		//This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next() to go back and forth.
		//(Note that alternating calls to next and previous will return the same element repeatedly.)

		@Override
		public T previous() {
			if (hasPrevious() == false) {
				throw new NoSuchElementException();
			} else {
				//	N = N.prev;
				//	return N.data;

				//if it is the last element then return that element
				if(lastNode == true){
					//set firstNode to false meaning N2.next
					lastNode = false;
					return N2.data;
				} else{
					N2 = N2.prev;
					return N2.data;
				}
			}
		}

		//Returns true if this list iterator has more elements when traversing the list in the reverse direction. (In other words, returns true if previous() would return an element rather than throwing an exception.)

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return (N2.prev != null);
		}

		//The following methods are not implemented
		//Rather they throw the UnsupportedOperationException
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}		

		@Override
		public int nextIndex() throws UnsupportedOperationException{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}


	/**Removes and returns the first element from the list.
	 * 
	 * @return firstElement.data
	 */
	public T retrieveFirstElement(){
		if(isEmpty() == true){
			return null;
		}

		//assign head to current Node
		Node firstElement = head;
		//assign head.next to head
		head = head.next;
		//assign null to head.prev
		head.prev = null;
		//decrease the size of the list
		listSize--;

		//return first element
		return firstElement.data;

	}
	/**Removes and returns the last element from the list.
	 * 
	 * @return lastElement.data
	 */
	public T retrieveLastElement(){
		if(isEmpty() == true){
			return null;
		}
		//assign tail to current Node
		Node lastElement = tail;
		//assign tail.next to tail
		tail = tail.prev;
		//assign null to tail.prev
		tail.next = null;
		//decrease the size of the list
		listSize--;

		//return last element
		return lastElement.data;

	}
	/**Returns an arraylist of the items in the list from head of list to tail of list.
	 * 
	 * @return listItems
	 */
	public java.util.ArrayList<T> toArrayList(){

		//create a new Generic ArrayList
		ArrayList<T> listItems = new ArrayList<T>();

		//assign head to temp Node
		Node temp = head;

		//while the next Node element is not null
		//add the next node to the ArrayList
		while(temp.next != null){
			listItems.add(temp.data);
			temp = temp.next;
		}

		//add the last node to the ArrayList
		listItems.add(temp.data);
		temp = temp.next;

		//		System.out.println("***");
		//		System.out.println(listItems);
		return listItems;
	}

	/**removes the node from the list
	 * 
	 * @param node
	 * @param c
	 * @return
	 */
	public T remove(T node, Comparator<T> c) {
		// TODO Auto-generated method stub
		return null;

	}


}