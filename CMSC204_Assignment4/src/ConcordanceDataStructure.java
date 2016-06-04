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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

/**ConcordanceDataStructure
 * 
 * This is the Concordance Data Structure Class.  It is the data structure
 * class that is used with the Concordance Data Manager class.
 * This is a hash table with buckets.  Your hash table with be an array of 
 * linked lists of ConcordanceDataElements. Use the hashcode for an 
 * ConcordanceDataElement to place in the hashtable.
 * Do not enter duplicate words or duplicate line numbers for a word.
 *  
 * There are approximately 500 words in the data file given you.  Determine 
 * an appropriate size for your hash table 
 * 
 * @author Surtej
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	
	//Instantiates a Hashtable object t of String and ConcordanceDataElement
	Hashtable <String, ConcordanceDataElement> t = new Hashtable <String, ConcordanceDataElement>();
	//Instantiates a ConcordanceDataElement object c
	ConcordanceDataElement c;

	@Override
	public void add(String word, int lineNum) {
		
		//Checks if the word is not in the Hashtable
		if(!t.containsKey(word)){
			
			//create a new ConcordanceDataElement, c, and passes word
			c = new ConcordanceDataElement(word);
			//Add the line number of the word
			c.addPage(lineNum);
			//Put the word and c into the Hashtable
			t.put(word, c);
			
		}else{
			
			//Checks in the Hashtable if the word does not contain the line number
			if(!t.get(word).getList().contains(lineNum)){
				
				//Add the line number of the word in the Hashtable
				t.get(word).addPage(lineNum);
			}
		}
	}


	@Override
	public ArrayList<String> showAll() {
		
		//String ArrayList a containing the words and line numbers
		ArrayList<String> a = new ArrayList<String>();
		
		//Iterate through a for each loop
		//Add the Hashtable object to ArrayList a
		Set<String> keyList = t.keySet();
		for(String key: keyList){
			String s= t.get(key).toString();
			a.add(t.get(key).toString());
		}
		
		//Alphabetically Sort ArrayList a 
		Collections.sort(a);

		//return ArrayList a of Strings
		return a;
	}
	

}
