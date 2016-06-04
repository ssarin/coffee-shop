/**This program/class EvalFunction prompts the user for input and assigns it to the x variable.
 *It then performs a calculation using the function f(x) = 2*x^3 – 5*x^2 – 12*x + 4") and uses the math power operator.
 *It displays the calculated f(x) or y-value to the display screen.
 *
 *Name: Surtej Sarin	Date: 1/31/15	Professor: Ida Justh	Course/section: CMSC203/30963
*/

import java.util.Scanner;	//To be able to read from the keyboard


//The class EvalFunction prompts the user for input and assigns it to the x variable.
//It then performs a calculation using the function f(x) = 2*x^3 – 5*x^2 – 12*x + 4") and uses the math power operator.
//It displays the calculated f(x) or y-value to the display screen.
public class EvalFunction
{
	public static void main(String[] args)
	{
		
		Scanner keyboard = new Scanner(System.in);//included so that keyboard may read user input
		
		//Initializing local variables
		double x=0.0;		//this variable is the x-value entered by the user
		double xPow3=0.0;	//the value of x raised to the power of 3
		double xPow2=0.0;	//the value of x raised to the power of 2
		double xPow1=0.0;	//the value of x raised to the power of 1
		double y=0.0;		//the y value or F(x) which = 2*x^3 – 5*x^2 – 12*x + 4

		
		//Display prompt screen
		System.out.println("Program to evaluate a function...\n");										//Print to console
		System.out.println("Compute the value of the function f(x)=2*x^3 – 5*x^2 – 12*x + 4");			//Print function to console
		System.out.print("Enter the value of x for which f(x) will be evaluated (numeric value): ");	//Prompts user to enter x-value
		x= keyboard.nextDouble();																		//User enters x-value
		
		//Calculate F(x) using the Math.pow(a,b) function
		xPow3=Math.pow(x, 3);	//Calculate x^3 using math power function
		xPow2=Math.pow(x, 2);	//Calculate x^2 using math power function
		xPow1=Math.pow(x, 1);	//Calculate x^1 using math power function
		
		y = ((2*xPow3) - (5*xPow2) - (12*xPow1) + (4));		//Calculate F(x) from function formula
		
		System.out.println( "f(" + x + ") = " + y );		//Print out the resulting value of f(x) or y-value to the display screen
		System.out.println("\n**Goodbye – Surtej Sarin");	//Closing message and end of program		
		
	}
}