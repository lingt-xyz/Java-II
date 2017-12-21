// *******************************************************************
// FileIO3.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates how you can append information to 
// an output file. 
//
// Key Points:
// 1) Appending to an Output File. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;



public class FileIO3{

	public static void main(String[] args) 
	{
		
		PrintWriter pw = null;		
		String s;
		Scanner kb = new Scanner(System.in);

		try
		{
			pw = new PrintWriter(new FileOutputStream("Info.txt", true));	// Notice that second parameter   
		}
		catch(FileNotFoundException e) 			// Since we are attempting to write to the file
		{							   			// exception is automatically thrown if file cannot be created. 
			System.out.println("Could not open/create the file to write to. "
					+ " Please check for problems such as directory permission"
					+ " or no available memory.");
			System.out.print("Program will terminate.");
			System.exit(0);			   		   
		}

		System.out.print("We need to store your information; Please enter your First and Last Name: ");
		s = kb.nextLine();		
		pw.println("Name: " + s);	// Write this info to the file
	
		System.out.print("\nPlease enter your Address: ");
		s = kb.nextLine();		
		pw.println("Address: " + s);	// Write this info to the file
	
		System.out.print("\nPlease enter your School Name: ");
		s = kb.nextLine();		
		pw.println("School Name: " + s);	// Write this info to the file
		pw.println("================= End of Record =================\n");
		pw.close();		// Close the file
	
		System.out.println("Thank you for filling your information."); 
		System.out.println("Your information has been stored in a file called \"Info.txt\".");	
	}
}

/* The Output 
We need to store your information; Please enter your First and Last Name: Mike Simon

Please enter your Address: 2030 Main Street, Montreal, Quebec, Canada

Please enter your School Name: Concordia University
Thank you for filling your information.
Your information has been stored in a file called "Info.txt".
*/


/* Contents of Info.txt file after first execution 
Name: Mike Simon
Address: 2030 Main Street, Montreal, Quebec, Canada
School Name: Concordia University
================= End of Record =================
*/


/* Run Again
We need to store your information; Please enter your First and Last Name: David Hudson

Please enter your Address: 921 5th Ave., NY, NY

Please enter your School Name: Columbia University 
Thank you for filling your information.
Your information has been stored in a file called "Info.txt".
*/

/* Contents of Info.txt file after second execution 
Name: Mike Simon
Address: 2030 Main Street, Montreal, Quebec, Canada
School Name: Concordia University
================= End of Record =================

Name: David Hudson
Address: 921 5th Ave., NY, NY
School Name: Columbia University
================= End of Record =================

*/