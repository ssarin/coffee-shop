import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * This lab is on JUnit	Testing.
 * It creates the JUnit Test class Gradebook.java and Test Class GradebookTester
 * 
 * @author Surtej Sarin    Date: 04/01/15	Professor: Ida Justh	Course/section: CMSC203/30963
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test Class GradebookTester:
 * Utilizes the setUp and tearDown method, all of the methods of Gradebook
 * Create test for the methods of Gradebook of addScore, assertTrue, assertEquals, sum, minimum, and finalScore
 * 
 * @author Surtej Sarin
 *
 */

public class GradeBookTester {

	private GradeBook g1, g2;
	@Before
	public void setUp() throws Exception {
		g1 = new GradeBook(5);
        g1.addScore(50);
        g1.addScore(75);
        g1.addScore(0);
        g1.addScore(0);
        g1.addScore(0);
        
        g2 = new GradeBook(5);
        g2.addScore(100);
        g2.addScore(90);
        g2.addScore(0);
        g2.addScore(0);
        g2.addScore(0);
	}

	@After
	public void tearDown() throws Exception {
        g1 = g2 = null;
	}

	@Test
	public void addScore() {
	
		//System.out.println(g1.toString());
		//System.out.println(g2.toString());
		
		assertTrue(g1.toString().equals("50.0 75.0 0.0 0.0 0.0 "));
		assertTrue(g2.toString().equals("100.0 90.0 0.0 0.0 0.0 "));
		
		//assertEquals(5, g1.getScoreSize());
		//assertEquals(5, g2.getScoreSize());
		
		assertEquals(50, 50, g1.getScoreSize());
		assertEquals(75, 75, g1.getScoreSize());
		assertEquals(0, 0, g1.getScoreSize());
		assertEquals(0, 0, g1.getScoreSize());
		assertEquals(0, 0, g1.getScoreSize());
		
		assertEquals(100, 100, g2.getScoreSize());
		assertEquals(90, 90, g2.getScoreSize());
		assertEquals(0, 0, g2.getScoreSize());
		assertEquals(0, 0, g2.getScoreSize());
		assertEquals(0, 0, g2.getScoreSize());
		
		}


		//fail("Not yet implemented");
	@Test
	public void testSum() {
		assertEquals(125, g1.sum(), 0.0001);
        assertEquals(190, g2.sum(), 0.0001);
		//fail("Not yet implemented");
	}

	@Test
	public void testMinimum() {
		assertEquals(0, g1.minimum(), 0.0001);
        assertEquals(0, g2.minimum(), 0.0001);
		//fail("Not yet implemented");
	}

	@Test
	public void testFinalScore() {
		assertEquals(125, 100, g1.finalScore());
        assertEquals(190, 100, g2.finalScore());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(5, g1.getScoreSize());
		assertEquals(5, g2.getScoreSize());

		//fail("Not yet implemented");
	}
/*
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}
*/
}
