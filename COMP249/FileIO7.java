// *******************************************************************
// FileIO7.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates input and output files further.
// The program shows how a file can be copied through the 
// use of input and output classes. Does this program really work? Why?
//
// Key Points:
// 1) Input and Output File. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;



public class FileIO7{
	
	// A method that the names of an input and output files (as streams)
	// then copies the input file to the output file
	public static void fileCopy(Scanner inFileStreamName, PrintWriter outFileStreamName)
	{
		// Read line by line from input file and copy it to output file
		String s;
		
		while(inFileStreamName.hasNextLine())
		{
			s = inFileStreamName.nextLine();		
			outFileStreamName.println(s);
			
		}

	}

	public static void main(String[] args) 
	{
			
		String s1, s2;
		PrintWriter pw = null;		
		Scanner kb = new Scanner(System.in);
		Scanner sc = null;		

		System.out.println("Please enter the name of the file you need to copy" +
							" as well as the name of the file to be created: ");
		s1 = kb.next();
		s2 = kb.next();
		
		// See if we can establish the two streams
		try
		{
			sc = new Scanner(new FileInputStream(s1));		
			pw = new PrintWriter(new FileOutputStream(s2));	  
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);			   
		}
		
		// At this moment, both streams exist, so call the method to copy the file
		fileCopy(sc, pw);
		
		
		System.out.println("File has been copied ");

	}
}

/* The Output 
Please enter the name of the file you need to copy as well as the name of the file to be created: 
StudentInfo2.txt StudentInfo2_backup.txt
File has been copied 

*/




/* Contents of StudentInfo2.txt file 
This file includes the current registration of Comp 201
=======================================================
Name		ID#
----		---
Mike Simon	9049923
David Hudson 	4561909
Linda Jacksom	3208879
Jack Peterson  	7609904
Jack Peterson  	7609904		
Anna Jordan	6509987

*/


/* Contents of StudentInfo2_backup.txt file after executing the program (That is right; there is NOTHING there

*/
