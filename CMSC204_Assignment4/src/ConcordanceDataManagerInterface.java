/**Assignment 4
 * 
 * Write a program that creates a concordance.
 * There will be two ways to create a concordance.
 * The first requires a document to be read from an input file, and the concordance data is written to an output file.
 * The second reads the input from a string and returns an ArrayList of strings that represent the concordance of the string.
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 03/16/2016
 * 
 * @author	Surtej
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This program makes a concordance for a file or a String.  
 * A concordance lists all the words that occur in the file or String,
 * along with all the line numbers on which each word occurs.
 * (Words of length less than 3 are omitted, "and" and "the" are omitted.)
 * Strip out all punctuation, except apostrophes that occur in the 
 * middle of a word, i.e. let’s, we’d, etc.
 * 
 * Uses an object that implements ConcordanceDataStructureInterface
 * 
 * @author JWISNIEW
 *
 */
   public interface ConcordanceDataManagerInterface {
	   
	   /**
	    * 
	    * Display the words in Alphabetical Order followed by a :, 
	    * followed by the line numbers in numerical order, followed by a newline
	    * here's an example:
	    * after: 129, 175
	    * agree: 185
	    * agreed: 37
	    * all: 24, 93, 112, 175, 203
	    * always: 90, 128
	    * 
	    * @param input a String (usually consist of several lines) to 
	    * make a concordance of
	    * 
	    * @return an ArrayList of Strings.  Each string has one word,
	    * followed by a :, followed by the line numbers in numerical order,
	    * followed by a newline.
	    */
	   public ArrayList<String> createConcordanceArray(String input);
	  
	   /**
	    * Creates a file that holds the concordance  
	    * 
	    * @param input the File to read from
	    * @param output the File to write to
	    *  
	    * Following is an example:
	    * 
		* about: 24, 210
		* abuse: 96
		* account: 79
		* acknowledged: 10
		* 
	    * @return true if the concordance file was created successfully.
	    * @throws FileNotFoundException if file not found
	    */
	   public boolean createConcordanceFile(File input, File output) throws FileNotFoundException;
      
   } // end class Concordance
