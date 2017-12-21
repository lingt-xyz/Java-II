// *******************************************************************
// FileIO11.java By: Aiman Hanna (C) 1993 - 2017
// This program introduction to the File class, and illustrates 
// some of its uses and how it can be used. The program fixes 
// the problem that FileIO10.java suffers. 
// 
// Key Points:
// 1) The File Class. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;



public class FileIO11{
	
	// A method that the names of an input and output files (as streams)
	// then copies the input file to the output file
	public static void fileCopy(BufferedReader inFileStreamName, PrintWriter outFileStreamName)
			throws IOException		// Declare the IOException exception 
	{
		// Read line by line from input file and copy it to output file
		String s;
		
		s = inFileStreamName.readLine();
		while(s != null) // The readLine() method returns null when it is EOF
		{
			outFileStreamName.println(s);
			s = inFileStreamName.readLine();		
		}
		// Must close the files to flush the buffers
		inFileStreamName.close();
		outFileStreamName.close();
	}

	// A method that takes a stream file name and display the contents of this file 
	public static void displayFileContents(BufferedReader inFileStreamName) throws IOException
	{
		// Read line by line from input file and display it (on the monitor)
		// The method actually uses the read() method (instead of readLine(), which we 
		// could have surely used here without a problem). The read() method reads 
		// character by character, but each character is read as type int, so casting is needed
		// so that we can display character and not their integer values 

		int x;
		
		x = inFileStreamName.read();
		while(x != -1) 
		{
			System.out.print((char)x);		// MUST CAST; otherwise all what is read will be shown as integers
			x = inFileStreamName.read();		
		}
		// Must close the file 
		inFileStreamName.close();
	}
	
	
	public static void main(String[] args) 
	{
			
		String s1, s2;
		PrintWriter pw = null;		
		Scanner kb = new Scanner(System.in);
		BufferedReader br = null;	// Create a BufferedReader object to read from input files 		


		System.out.println("Please enter the name of the file you need to copy" +
							" as well as the name of the file to be created: ");
		s1 = kb.next();
		s2 = kb.next();
		
		// Make sure that the output file does not exist; otherwise the copy operation would 
		// destroy it
		File f = new File(s2);		
		while(f.exists())
		{
			System.out.println("Error: There is an existing file called: " + s1 + ".");
			System.out.println("That file already has a size of " + f.length() + " bytes.");
			System.out.print("\nPlease enter another file name to copy to: ");
			s2 = kb.next();
			f = new File(s2);
		}
		
		// Now the file names are okay, continue the program
		try
		{
			System.out.println("Attempting to open and display the contents of file: " + s1 + ".");
			br = new BufferedReader(new FileReader(s1));		
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);			   
		}
		
		
		// Now try to display the contents of the original file
		System.out.println("\nHere are the contents of file " + s1 + " BEFORE performing the coping operation:");
		System.out.println("===================================================================================");
		
		try
		{
			displayFileContents(br);
		}
		catch(IOException e)
		{
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		
		
		// See if we can establish the two streams to perform the copying operation
		try
		{
			br = new BufferedReader(new FileReader(s1));		
			pw = new PrintWriter(new FileOutputStream(s2));	  
			
			// At this moment, both streams exist, so call the method to copy the file
			// However, possible IOException may still occur while reading the input file
			fileCopy(br, pw);
			
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);			   
		}
		catch(IOException e)
		{
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}

		System.out.println("File has been copied ");
		
		// At that moment the files have been copied and we wish to display their contents
		// on the screen; however by now they have already been closed, so we must re-open them
		
		// Try to re-open the original file
		try
		{
			br = new BufferedReader(new FileReader(s1));		
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);			   
		}
		
		
		// Now try to display the contents of the original file
		System.out.println("\nHere are the contents of file " + s1 + " AFTER copying operation:");
		System.out.println("==================================================================");
		
		try
		{
			displayFileContents(br);
		}
		catch(IOException e)
		{
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		
		// Try to re-open the copied file
		try
		{
			br = new BufferedReader(new FileReader(s2));	// We can surely use the same stream since the file  	
		}													// that it was referencing is already closed by now
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);			   
		}
		
		// Now try to display the contents of the copied file
		System.out.println("\nHere are the contents of file " + s2 + ":");
		System.out.println("======================================================");
		
		try
		{
			displayFileContents(br);
		}
		catch(IOException e)
		{
			System.out.println("Error: An error has occurred while reading from the " + s2 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		

	}
}

/* The Output 
Please enter the name of the file you need to copy as well as the name of the file to be created: 
StudentInfo5.txt StudentInfo5.txt
Error: There is an existing file called: StudentInfo5.txt.
That file already has a size of 250 bytes.

Please enter another file name to copy to: StudentInfo5.txt
Error: There is an existing file called: StudentInfo5.txt.
That file already has a size of 250 bytes.

Please enter another file name to copy to: StudentInfo5_bu.txt
Attempting to open and display the contents of file: StudentInfo5.txt.

Here are the contents of file StudentInfo5.txt BEFORE performing the coping operation:
===================================================================================
This file includes the current registration of Comp 201
=======================================================
Name		ID#
----		---
Mike Simon	9049923
David Hudson 	4561909
Linda Jacksom	3208879
Jack Peterson  	7609904		
Anna Jordan	6509987
File has been copied 

Here are the contents of file StudentInfo5.txt AFTER copying operation:
==================================================================
This file includes the current registration of Comp 201
=======================================================
Name		ID#
----		---
Mike Simon	9049923
David Hudson 	4561909
Linda Jacksom	3208879
Jack Peterson  	7609904		
Anna Jordan	6509987

Here are the contents of file StudentInfo5_bu.txt:
======================================================
This file includes the current registration of Comp 201
=======================================================
Name		ID#
----		---
Mike Simon	9049923
David Hudson 	4561909
Linda Jacksom	3208879
Jack Peterson  	7609904		
Anna Jordan	6509987

*/
