// *******************************************************************
// FileIO4.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates how reading can be made from 
// input files. 
//
// Key Points:
// 1) Reading from Input Files. 
// 2) Using the Scanner Class for Reading from Files. 
// 3) The FileInputStream Class. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;



public class FileIO4{

	public static void main(String[] args) 
	{
			
		String s;
		Scanner kb = new Scanner(System.in);
		Scanner sc = null;		// A scanner object 
		long id1, id2, id3;

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
						 "followed by the first 3 IDs. ");
		System.out.println("\nThe first line of the file has the following text:");
		s = sc.nextLine();		// read the entire first line from the file then display it	
		System.out.println(s);	
		
		id1 = sc.nextLong();
		s = sc.nextLine();		// just read the rest of the line so we can go to the next line;
						// you can just indicate sc.nextLine(); since there is no need to 
						// store the contents

		
		id2 = sc.nextLong();
		s = sc.nextLine();		// just read the rest of the line so we can go to the next line
		
		id3 = sc.nextLong();
		
		System.out.println("\nHere are the first 3 IDs in that course: ");
		System.out.println(id1);
		System.out.println(id2);
		System.out.println(id3);
		
	}
}

/* The Output 
Will read the input file and display the first line, followed by the first 3 IDs. 

The first line of the file has the following text:
This file includes the current registration of Comp 201

Here are the first 3 IDs in that course: 
9049923
4561909
3208879
*/




/* Contents of StudentInfo.txt file 
This file includes the current registration of Comp 201
9049923		Mike Simon	
4561909		David Hudson 	
3208879		Linda Jacksom	
7609904		Jack Peterson  	
6509987		Anna Jordan

*/