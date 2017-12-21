// *******************************************************************
// FileIO6.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates how the program can detect the end
// of file through the use of some of the methods of the Scanner 
// class. The program fixes the problem that FileIO5.java suffers
//
// Key Points:
// 1) Detecting End of File. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;



public class FileIO6{

	public static void main(String[] args) 
	{
			
		String s;
		Scanner kb = new Scanner(System.in);
		Scanner sc = null;		// A scanner object 
		long id;
		int i = 0;

		try
		{
			sc = new Scanner(new FileInputStream("StudentInfo.txt"));				     
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Could not open input file for reading."
					+ " Please check if file exists.");	
			System.out.print("Program will terminate.");
			System.exit(0);			   
		}
		// The format of the file is assumed to be known. 
		// The file starts with a line indicating the course name, followed by 
		// the list of students in the course (as ID# then First and Last Name)
		
		System.out.println("Will read the input file and display the first line, " +
						 "followed by the first 7 IDs, if any. ");
		System.out.println("\nThe first line of the file has the following text:");
		s = sc.nextLine();	// read the entire first line from the file then display it	
		System.out.println(s);	

		System.out.println("\nHere are the first 7 IDs in that course." +
							"\nIf less than 7 registration exist, all of them are displayed: ");

		
		while(sc.hasNextLine() && i < 7)
		{
			id = sc.nextLong();
			s = sc.nextLine();		// just read the rest of the line so we can go to the next line
			System.out.println(id);
			i++;
		}
				
		if (i < 7)
			System.out.println("\nPlease note that the course has only " + i + " registrations.");
	}
}

/* The Output 
Will read the input file and display the first line, followed by the first 7 IDs, if any. 

The first line of the file has the following text:
This file includes the current registration of Comp 201

Here are the first 7 IDs in that course.
If less than 7 registration exist, all of them are displayed: 
9049923
4561909
3208879
7609904
6509987

Please note that the course has only 5 registrations.
*/




/* Contents of StudentInfo.txt file 
This file includes the current registration of Comp 201
9049923		Mike Simon	
4561909		David Hudson 	
3208879		Linda Jacksom	
7609904		Jack Peterson  	
6509987		Anna Jordan

*/