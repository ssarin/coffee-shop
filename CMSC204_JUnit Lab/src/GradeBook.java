/** 
 * This program is a Driver�s License exam program for a Local Driver�s License Office.


 * It uses concepts such as Arrays, ArrayLists, 
 * Create a Data Element/Worker class Instance variables and Getters and setters
 * Create a Data Manager class, Methods to access the data	
 * Create a GUI driver class, with Frame, Panel, Event programming, Textfields, Labels, Buttons, JOptionPane. showMessageDialog
 * Read from a file
 * 
 * @author Surtej Sarin    Date: 04/01/15	Professor: Ida Justh	Course/section: CMSC203/30963
 *
 */
import java.util.ArrayList;

/**
 * JUnit Test Class for Gradebook.java:
 * 1. Add a getScoreSize() method to the Gradebook class which returns scoresSize;
 * 2. Add a toString() method to the Gradebook class that returns a string with each score in scores separated by a space.
 * 
 * 
 * @author Surtej Sarin
 *
 */


public class GradeBook
{
   private double[] scores;
   private int scoresSize;
   private String strScore;

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   
   /**
    * Add a getScoreSize() method to the Gradebook class which returns scoresSize;
    * @return scoresSize
    */
   public int getScoreSize()
   {
	   return scoresSize;
   }
   
   /**
    * Add a toString() method to the Gradebook class that returns a string with each score 
    * in scores separated by a space.
    * @return strScore
    */
   
   public String toString(){

	    String scoreList = "";

	    for(int i = 0; i < scores.length; i++){

	        scoreList += scores[i] + " ";

	    }
	    System.out.println(scoreList);
	    return scoreList;
	}
   
}