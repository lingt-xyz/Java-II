// *******************************************************************
// FileIO1.java By: Aiman Hanna (C) 1993 - 2017
// This program provides an introduction to Files I/O operations. 
//
// Key Points:
// 1) File I/O. 
// 2) The PrintWriter Class.
// 3) The FileOutputStream class.
// 4) The close() Method. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;



public class FileIO1{

	public static void main(String[] args) throws FileNotFoundException 
	{				// Notice that the main() function is declaring the exception!!!
					// You should consider never doing that! 
		
		// Create an output stream object to write to a file
		// The "real" output file name will be called "Info.text"; 
		// notice that this can be any other name

		PrintWriter pw;
		pw = new PrintWriter(new FileOutputStream("Info.txt"));
		
		// From this point on, all references to the file will
		// be made through that stream object name; that is, the
		// stream object name is considered as the file name through 
		// the program from this point on
		
		String s;

		Scanner kb = new Scanner(System.in);
		System.out.print("We need to store your information; Please enter your First and Last Name: ");
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

/* Contents of Info.txt file after second run 
/* Notice that the previous contents has been destroyed  

Name:  David Hudson
Address: 921 5th Ave., NY, NY
School Name: Columbia University 
*/