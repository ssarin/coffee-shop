import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyLinkedList extends LinkedList<String>{

	LinkedList<String> stringList = new LinkedList<String>();

	//ListIterator<String> iterator = stringList.listIterator();

	//ListIterator<String> iterator;
	Iterator i;

	String max;
	//int counter = 0;
	//String nextPerson = "";
	
	
	public String findLargest() {	

		i = stringList.iterator();
		
		max = findLargest(i);
		
		return max;


		//findLargest();

//		if(i.hasNext()){
//			if(i.next().toString().compareTo(max) > 0){
//				findLargest();
//			}
//			else{
//				return max;
//			}
//		}
//		return max;
	}

	private String findLargest(Iterator i2) {

		if(i2.hasNext()){
			String next = (String) i2.next();
			String maxOfRest = findLargest(i2);
			if(next.compareTo(maxOfRest) < 0){
				return maxOfRest;
			} else{
				return next;
			}
			
		} else{
			return "";
		}
	}

	public boolean add(String string) {

		Boolean s = stringList.add(string);
		//Collections.sort(stringList);
		//		System.out.println(stringList);
		//		System.out.print("******");
		return s;
	}

}
