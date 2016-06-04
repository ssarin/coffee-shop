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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**ConcordanceDataManager class
 * 
 * This program makes a concordance for a file or a String.  
 * A concordance lists all the words that occur in the file or String,
 * along with all the line numbers on which each word occurs.
 * (Words of length less than 3 are omitted, "and" and "the" are omitted.)
 * Strip out all punctuation, except apostrophes that occur in the 
 * middle of a word, i.e. let’s, we’d, etc.
 * 
 * @author Surtej
 *
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface{

	//Uses an object that implements ConcordanceDataStructureInterface
	ConcordanceDataStructure cds = new ConcordanceDataStructure();

	@Override
	public ArrayList<String> createConcordanceArray(String input) {

		//String ArrayList list contains a line of text 
		//ArrayList<String> list = new ArrayList<String>();
		//String Array line contains lines of text separated by \n
		String [] line = input.split("\n");
		//String ArrayList list contains the words
		//ArrayList<String> words = new ArrayList<String>();
		String [] lineWords;
		//Iterates through each line of text
		for(int i = 0; i < line.length; i ++){

			//String Array lineWords contains words separated by space
			lineWords = line[i].split(" ");

			
			//Iterates through each word
			for(int k = 0; k < lineWords.length; k ++){

				//Checks if the word is greater than 3 characters, does not equal words: and & the 
				if(lineWords[k].length() >= 3 && !lineWords[k].toLowerCase().equals("and") && !lineWords[k].toLowerCase().equals("the"))
				{
					//Checks if the word ends with a comma or period
					if(lineWords[k].endsWith(",") || lineWords[k].endsWith(".")){
						//Delete the comma or period from the word
						lineWords[k] = lineWords[k].substring(0, lineWords[k].length()-1);
					}
					//Checks if after the word is less than 3 characters
					//For example: a word like: (is.) initially has three characters
					//Then after the previous check it has two characters
					if(!(lineWords[k].length() < 3)){
						//Make the word lowercase
						//Add the word and line number to the ConcordanceDataStructure object
						cds.add(lineWords[k].toLowerCase(), (i+1));
					}
				}
			}
		}
		//Return the ArrayList of Strings or words and line numbers
		return cds.showAll();
	}

	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		
		//BufferedReader br used to read input file
		BufferedReader br;
		//String line of text read in by the BufferedReader
		String line;
		//String paragraph assigned line of text
		String paragraph = "";
	
		//Checks if the input is readable
		//If not throw a FileNotFoundException
		if(!input.canRead()){
			throw new FileNotFoundException();
		}
		
		//Checks if the input is not empty
		if(input != null){

			//Reads through the input file
			try{
				//Reads in the input through the BufferedReader object br
				br = new BufferedReader(new FileReader(input));

				//Continues while there is a next line in the input file
				while((line = br.readLine()) != null){
					//Adds the line followed by \n to the paragraph
					paragraph += (line + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			//paragraph is passed to createConcordanceArray
			//String ArrayList out is assigned the return from the call
			ArrayList<String> out = createConcordanceArray(paragraph);

			//PrintWriter writer is used to write to the output file
			PrintWriter writer = new PrintWriter(output);
			
			//Uses a for each loop to iterate through String ArrayList out
			//Writes the String s to the writer 
			for(String s: out){
				writer.write(s);
			}
			
			//Close the PrintWriter object
			writer.close();

			//The following is a check to test if the output file was created correctly
			
			//String ArrayList words contains the words and line numbers from the output file
			ArrayList<String> words = new ArrayList<String>();
			//Scanner object is created from the output file
			Scanner scan = new Scanner(output);
			//Continues while there is another token in the scanner's input
			while (scan.hasNext())
			{
				//Add line to words
				words.add(scan.nextLine());
			}
			
			//Prints out the words and line numbers in the output file
			System.out.print(words);

			//Returns true that the method created an accurate output file
			return true;
		}
		//Returns false if the input file is empty
		return false;
	}

}
