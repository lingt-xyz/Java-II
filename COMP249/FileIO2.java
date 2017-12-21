// *******************************************************************
// FileIO2.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates exception handling with 
// File I/O operations. 
//
// Key Points:
// 1) File I/O Exception Handling. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;



public class FileIO2{

	public static void main(String[] args) // Notice that the main() function is not declaring the exception
	{
		
		// Create an output stream object to write to a file
		// The "real" output file name will be called "Info.text"; 
		// notice that this can be any other name
		PrintWriter pw = null;		// Declare the object outside of the "try" block; 
									// otherwise, it is only visible there
									// We also need to set to null; otherwise compiler will
									// complain about its utilization after the try-catch block
									// as being not initialized  
		String s;
		Scanner kb = new Scanner(System.in);

		try
		{
			pw = new PrintWriter(new FileOutputStream("Info.txt"));	 
		}
		catch(FileNotFoundException e) 			// Since we are attempting to write to the file
		{							   			// exception is automatically thrown if file cannot be created. 
			System.out.println("Could not create a file to write to. "
					+ " Please check for problems such as directory permission"
					+ " or no available memory.");	
			System.out.print("Program will terminate.");
			System.exit(0);			   		   
		}
		System.out.print("We need to store your information; Please enter your First and Last Name:");
		s = kb.nextLine();		
		pw.println("Name: " + s);	// Write this info to the file
	
		System.out.print("\nPlease enter your Address: ");
		s = kb.nextLine();		
		pw.println("Address: " + s);	// Write this info to the file
	
		System.out.print("\nPlease enter your School Name: ");
		s = kb.nextLine();		
		pw.println("School Name: " + s);	// Write this info to the file
	
		pw.close();		// Close the file
	
		System.out.println("Thank you for filling your information."); 
		System.out.println("Your information has been stored in a file called \"Info.txt\".");	
	}
}

/* The Output 
We need to store your information; Please enter your First and Last Name: Linda Jackson

Please enter your Address: 198 Rue St. Lambert, Sherbrook, Quebec

Please enter your School Name: UQAM 
Thank you for filling your information.
Your information has been stored in a file called "Info.txt".
*/


/* Contents of Info.txt file after program termination 
Name:  Linda Jackson
Address: 198 Rue St. Lambert, Sherbrook, Quebec
School Name: UQAM 


*/