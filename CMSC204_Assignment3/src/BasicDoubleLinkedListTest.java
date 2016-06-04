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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListTest {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	StringComparator comparator;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		comparator = new StringComparator();

		//STUDENT: Use the linkedDouble for the STUDENT tests
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();

	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
	}

	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
	}

	@Test
	public void testAddToEndSTUDENT(){
		//test addToEnd for the linkedDouble
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
		linkedDouble.addToEnd(200.0);
		assertEquals(Double.valueOf(200.0), linkedDouble.getLast());
	}

	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
	}

	@Test
	public void testAddToFrontSTUDENT(){
		//test addToFront for the linkedDouble
		assertEquals(Double.valueOf(15.0), linkedDouble.getFirst());
		linkedDouble.addToFront(1.0);
		assertEquals(Double.valueOf(1.0), linkedDouble.getFirst());
	}

	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
	}

	@Test
	public void testGetFirstSTUDENT(){
		//test getFirst for the linkedDouble
		assertEquals(Double.valueOf(15.0), linkedDouble.getFirst());
		linkedDouble.addToFront(120.0);
		assertEquals(Double.valueOf(120.0), linkedDouble.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
	}

	@Test
	public void testGetLastSTUDENT(){
		//test getLast for the linkedDouble
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
		linkedDouble.addToEnd(5.0);
		assertEquals(Double.valueOf(5.0), linkedDouble.getLast());
	}

	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		list = linkedString.toArrayList();
		assertEquals("Begin", list.get(0));
		assertEquals("Hello", list.get(1));
		assertEquals("World", list.get(2));
		assertEquals("End", list.get(3));
	}

	@Test
	public void testToArraySTUDENT(){
		//test toArray for the linkedDouble
		ArrayList<Double> list;
		linkedDouble.addToFront(1.0);
		linkedDouble.addToEnd(2.0);
		list = linkedDouble.toArrayList();
		assertEquals(Double.valueOf(1.0), list.get(0));
		assertEquals(Double.valueOf(15.0), list.get(1));
		assertEquals(Double.valueOf(100.0), list.get(2));
		assertEquals(Double.valueOf(2.0), list.get(3));
	}

	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
	}

	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}


	//-------------fix@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@Test
	public void testIteratorSuccessfulSTUDENT(){
		//test the iterator for the linkedDouble
		//be throughal, use the preceeding test method as an example
		linkedDouble.addToFront(1.0);
		linkedDouble.addToEnd(2.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(1.0), iterator.next());
		assertEquals(Double.valueOf(15.0), iterator.next());
		assertEquals(Double.valueOf(100.0), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(Double.valueOf(2.0), iterator.previous());
		assertEquals(Double.valueOf(100.0), iterator.previous());
		assertEquals(Double.valueOf(15.0), iterator.previous());

	}

	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals("Begin", iterator.previous());
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorNoSuchElementExceptionSTUDENT(){
		//test the iterator for the linkedDouble.  Exception raised
		//when next is called after last element.
		//be throughal, use the preceeding test method as an example

		linkedDouble.addToFront(1.0);
		linkedDouble.addToEnd(2.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(1.0), iterator.next());
		assertEquals(Double.valueOf(15.0), iterator.next());
		assertEquals(Double.valueOf(100.0), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(Double.valueOf(2.0), iterator.previous());
		assertEquals(Double.valueOf(100.0), iterator.previous());
		assertEquals(Double.valueOf(15.0), iterator.previous());
		assertEquals(Double.valueOf(1.0), iterator.previous());
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());

		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}

	}

	@Test
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
		//test the remove method for the iterator for the linkedDouble
		//be throughal, use the preceeding test method as an example
		linkedDouble.addToFront(99.0);
		linkedDouble.addToEnd(999.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(99.0), iterator.next());
		assertEquals(Double.valueOf(15.0), iterator.next());
		assertEquals(Double.valueOf(100.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(999.0), iterator.next());

		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testRemove() {
		// remove the first
		assertEquals("Hello", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		linkedString.remove("New", comparator);
		assertEquals("Hello", linkedString.getFirst());
		//remove from the end of the list
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		linkedString.remove("End", comparator);
		assertEquals("World", linkedString.getLast());
		//remove from middle of list
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.remove("Hello", comparator);
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());

	}

	@Test
	public void testRemoveSTUDENT(){
		//test the remove method for the linkedDouble
		//be throughal, remove from the front of the list, the
		//end of the list and the middle of the list, 
		//use the preceeding test method as an example

		assertEquals(Double.valueOf(15.0), linkedDouble.getFirst());
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
		linkedDouble.addToFront(10.0);
		assertEquals(Double.valueOf(10.0), linkedDouble.getFirst());
		linkedDouble.remove(10.0, comparatorD);
		assertEquals(Double.valueOf(15.0), linkedDouble.getFirst());
		//remove from the end of the list
		linkedDouble.addToEnd(20.0);
		assertEquals(Double.valueOf(20.0), linkedDouble.getLast());
		linkedDouble.remove(20.0, comparatorD);
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
		//remove from middle of list
		linkedDouble.addToFront(5.0);
		assertEquals(Double.valueOf(5.0), linkedDouble.getFirst());
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
		linkedDouble.remove(15.0, comparatorD);
		assertEquals(Double.valueOf(5.0), linkedDouble.getFirst());
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());

	}

	@Test
	public void testRetrieveFirstElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals(Double.valueOf(15.0), linkedDouble.getFirst());
		linkedDouble.addToFront(1.0);
		assertEquals(Double.valueOf(1.0), linkedDouble.getFirst());
		assertEquals(Double.valueOf(1.0), linkedDouble.retrieveFirstElement());
		assertEquals(Double.valueOf(15.0),linkedDouble.getFirst());
		assertEquals(Double.valueOf(15.0), linkedDouble.retrieveFirstElement());
		assertEquals(Double.valueOf(100.0),linkedDouble.getFirst());
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}

	@Test
	public void testRetrieveLastElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
		linkedDouble.addToEnd(20.0);
		assertEquals(Double.valueOf(20.0), linkedDouble.getLast());
		assertEquals(Double.valueOf(20.0), linkedDouble.retrieveLastElement());
		assertEquals(Double.valueOf(100.0), linkedDouble.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}
}