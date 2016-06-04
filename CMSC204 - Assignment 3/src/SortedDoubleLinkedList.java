import java.util.Comparator;

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

/**Implements a generic sorted double list using a provided Comparator.
 * It extends BasicDoubleLinkedList class.
 * 
 * @author Surtej
 *
 * @param <T>
 */
public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T>{

	//comparator object
	Comparator<T> c;

	/**Creates an empty list that is associated with the specified comparator.
	 * 
	 * @param comparator2
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2){
		c = comparator2;
	}

	/**Inserts the specified element at the correct position in the sorted list.
	 * Notice we can insert the same element several times.
	 * Your implementation must traverse the list only once in order to perform the insertion. 
	 * 
	 * @param data
	 * @return this
	 */
	public SortedDoubleLinkedList<T> add(T data){

		//previous node initialized to null
		//Node prev = null;
		//temp node initialized to head
		Node temp = head;
		//new node contating the data
		Node n = new Node(data, null, null);

		//first case: check if the list is empty
		if(head == null){
			head = n;
			tail = n;

			//the list contains one or more nodes
		}else{

			//while the head node is not null
			while(temp != null){

				//compare to see if data is greater than temp.data
				//while temp.next is not null
				if(c.compare(data, temp.data) > 0 && temp.next != null){
					//store temp.next into temp
					temp = temp.next;
					//store temp into prev
					n.prev = temp;
					//otherwise if data is less than temp.data
				}else{

					//compare to see if data is greater than temp.data
					//if temp.next is null meaning node is at beginning
					if((c.compare(data, temp.data) > 0)  && temp.next == null){

						//assign new node n to temp.next
						temp.next = n;
						//assign temp to new node n.prev
						n.prev = temp;

						break;

						//compare to see if data is less than temp.data
						//if temp.prev is null meaning node is at the end
					} else if( (c.compare(data, temp.data) < 0 ) && temp.prev == null){

						//assign temp to n.next
						n.next = temp;
						//assign n to temp.prev
						temp.prev = n;
						//assign n to head
						head = n;

						break;

					}else{
						//assign temp to n.next
						n.next = temp;
						//assign temp.prev to n.prev
						n.prev = temp.prev;
						//assign n to temp.prev.next
						temp.prev.next = n;
						//assign n to temp.prev
						temp.prev = n;

						break;
					}
				}
			}
		}
		//			//end of list
		//			if(temp.next == null){
		//				tail.next = new Node(data, null, tail);
		//			} else{
		//				prev.next = new Node(data, null, tail);
		//			}
		//
		//			//this.iterator();
		//

		listSize++;

		return this;
	}

	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws java.lang.UnsupportedOperationException{
		//throw new java.lang.UnsupportedOperationException();
		return (BasicDoubleLinkedList<T>) this.getLast();
	}

	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws java.lang.UnsupportedOperationException{
		//throw new java.lang.UnsupportedOperationException();
		return (BasicDoubleLinkedList<T>) this.getFirst();
	}
	@Override
	public java.util.ListIterator<T> iterator(){
		return super.iterator();
	}
	//	public void remove() throws UnsupportedOperationException{
	//		throw new UnsupportedOperationException();
	//	}
}
