/**Assignment 4
 * 
 * Write a program that creates a concordance. There will be two ways to create a concordance.
 * The first requires a document to be read from an input file, and the concordance data is written to an output file.
 * The second reads the input from a string and returns an ArrayList of strings that represent the concordance of the string.
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 03/16/2016
 * 
 * @author	Surtej
 * 
 */

import java.util.LinkedList;

/**ConcordanceDataElement class
 * This class is the data element class for the ConcordanceDataStructure.
 * It consists of a word (String) and a list of page numbers (LinkedList)
 * 
 * @author Surtej
 */
public class ConcordanceDataElement {

	//list of line numbers
	private java.util.LinkedList<java.lang.Integer> list = new LinkedList<java.lang.Integer>();
	//String of the word
	private java.lang.String word;

	/**ConcordanceDataElement constructor
	 * Initializes word
	 * 
	 * @param word - the word for the concordance data element
	 */
	public ConcordanceDataElement(java.lang.String word){
		this.word = word;
	}
	
	/**addPage method
	 * Add a line number to the linked list if the number doesn't exist in the list
	 * @param lineNum - the line number to add to the linked list
	 */
	public void addPage(int lineNum){
		//check if line number is not in the list
		if(!list.contains(lineNum)){
			list.add(lineNum);
		}
		System.out.println(list);
	}
	
	/**getList method
	 * Returns the linked list of integers that represent the line numbers
	 * @return - the linked list of integers that represent the line numbers
	 */
	public java.util.LinkedList<java.lang.Integer> getList(){
		//System.out.println(list);
		return list;
	}
	
	/**hashCode method
	 * Returns the hashCode. You may use the String class hashCode method
	 * @return word.hashCode() - the hash code of the word
	 */
	public int hashCode(){
		return word.hashCode();
	}
	
	/**getWord method
	 * Return the word portion of the Concordance Data Element
	 * @return word - the word portion of the Concordance Data Element
	 */
	public java.lang.String getWord(){
		return word;
	}
	
	/**toString method
	 * Returns the word followed by page numbers
	 * Returns a string in the following format: word: page num, page num Example: after: 2,8,15
	 * return word + ": " + pages + "\n"
	 */
	public java.lang.String toString(){
		String pages = "";

		for(int i=0; i<list.size(); i++){
			pages += list.get(i) + ", ";
		}

		//System.out.println("line" + pages);
		pages = pages.substring(0, pages.lastIndexOf(","));

		//System.out.print(list);
		//System.out.print(word + ": " + pages + "\n");
		//System.out.print("****");
		return word + ": " + pages + "\n";
	}
}
