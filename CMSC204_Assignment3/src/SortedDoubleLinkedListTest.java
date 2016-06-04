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
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListTest {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator;
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;


	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);

		//STUDENT - use the SortedDoubleLinkedList<Double> for your STUDENT tests
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulStringNext() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		sortedLinkedDouble.add(3.0);
		sortedLinkedDouble.add(4.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(3.0), iterator.next());
		assertEquals(Double.valueOf(1.0), iterator.next());
		assertEquals(Double.valueOf(2.0), iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		sortedLinkedDouble.add(3.0);
		sortedLinkedDouble.add(4.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(3.0), iterator.next());
		assertEquals(Double.valueOf(1.0), iterator.next());
		assertEquals(Double.valueOf(2.0), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(Double.valueOf(4.0), iterator.previous());
		assertEquals(Double.valueOf(2.0), iterator.previous());
		assertEquals(Double.valueOf(1.0), iterator.previous());
	}

	@Test
	public void testIteratorNoSuchElementExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Zebra", iterator.next());
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
	public void testIteratorNoSuchElementExceptionDouble() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		sortedLinkedDouble.add(3.0);
		sortedLinkedDouble.add(4.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(3.0), iterator.next());
		assertEquals(Double.valueOf(1.0), iterator.next());
		assertEquals(Double.valueOf(2.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(Double.valueOf(4.0), iterator.next());
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
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
	public void testIteratorUnsupportedOperationExceptionDouble() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		sortedLinkedDouble.add(3.0);
		sortedLinkedDouble.add(4.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
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
	public void testAddString() {
		sortedLinkedString.add("Banana");
		sortedLinkedString.add("Elephant");
		sortedLinkedString.add("Apple");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		sortedLinkedString.add("Cat");
		sortedLinkedString.add("Dog");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		//deletes Elephant from linked list
		assertEquals("Elephant",sortedLinkedString.retrieveLastElement());
		assertEquals("Dog", sortedLinkedString.getLast());
	}

	@Test
	public void testAddDouble() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		sortedLinkedDouble.add(3.0);
		assertEquals(Double.valueOf(3.0), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(4.0);
		sortedLinkedDouble.add(5.0);
		assertEquals(Double.valueOf(3.0), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
		//deletes Elephant from linked list
		assertEquals(Double.valueOf(2.0),sortedLinkedDouble.retrieveLastElement());
		assertEquals(Double.valueOf(5.0), sortedLinkedDouble.getLast());

	}

	@Test
	public void testRemoveFirstString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		// remove the first
		sortedLinkedString.remove("Begin", comparator);
		assertEquals("Hello", sortedLinkedString.getFirst());
	}

	@Test
	public void testRemoveFirstDouble() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		assertEquals(Double.valueOf(1.0), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(3.0);
		assertEquals(Double.valueOf(3.0), sortedLinkedDouble.getFirst());
		// remove the first
		sortedLinkedDouble.remove(3.0, comparatorD);
		assertEquals(Double.valueOf(1.0), sortedLinkedDouble.getFirst());

	}

	@Test
	public void testRemoveEndString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Zebra");
		assertEquals("Zebra", sortedLinkedString.getLast());
		//remove from the end of the list
		sortedLinkedString.remove("Zebra", comparator);
		assertEquals("World", sortedLinkedString.getLast());
	}

	@Test
	public void testRemoveEndDouble() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		assertEquals(Double.valueOf(1.0), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(3.0);
		assertEquals(Double.valueOf(3.0), sortedLinkedDouble.getLast());
		//remove from the end of the list
		sortedLinkedDouble.remove(3.0, comparatorD);
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
	}

	@Test
	public void testRemoveMiddleString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(3,sortedLinkedString.getSize());
		//remove from middle of list
		sortedLinkedString.remove("Hello", comparator);
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(2,sortedLinkedString.getSize());
	}

	@Test
	public void testRemoveMiddleDouble() {
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(2.0);
		assertEquals(Double.valueOf(1.0), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(3.0);
		assertEquals(Double.valueOf(3.0), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
		assertEquals(3,sortedLinkedDouble.getSize());
		//remove from middle of list
		sortedLinkedDouble.remove(1.0, comparatorD);
		assertEquals(Double.valueOf(3.0), sortedLinkedDouble.getFirst());
		assertEquals(Double.valueOf(2.0), sortedLinkedDouble.getLast());
		assertEquals(2,sortedLinkedDouble.getSize());

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