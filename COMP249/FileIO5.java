// *******************************************************************
// FileIO5.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates further reading from input files. 
// In specific, the program illustrates what happen if a 
// program attempts to read beyond the end of the file. The program 
// is identical to FileIO4.java, with the exception that it attempts 
// to read 7 IDs, which the input files does NOT actually have.
//
// Key Points:
// 1) Reading Beyond End of File. 
// *******************************************************************

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;



public class FileIO5{

	public static void main(String[] args) 
	{
			
		String s;
		Scanner kb = new Scanner(System.in);
		Scanner sc = null;		// A scanner object 
		long id1, id2, id3, id4, id5, id6, id7;

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
						 "followed by the first 7 IDs. ");
		System.out.println("\nThe first line of the file has the following text:");
		s = sc.nextLine();	// read the entire first line from the file then display it	
		System.out.println(s);	

		System.out.println("\nHere are the first 7 IDs in that course: ");

		id1 = sc.nextLong();
		s = sc.nextLine();		// just read the rest of the line so we can go to the next line
		System.out.println(id1);
		
		id2 = sc.nextLong();
		s = sc.nextLine();		
		System.out.println(id2);
		
		id3 = sc.nextLong();
		s = sc.nextLine();	
		System.out.println(id3);
		
		id4 = sc.nextLong();
		s = sc.nextLine();		
		System.out.println(id4);
		
		id5 = sc.nextLong();
		s = sc.nextLine();		
		System.out.println(id5);
		
		id6 = sc.nextLong();
		s = sc.nextLine();	
		System.out.println(id6);

		id7 = sc.nextLong();
		System.out.println(id7);
				
	}
}

/* The Output 
Will read the input file and display the first line, followed by the first 7 IDs. 

The first line of the file has the following text:
This file includes the current registration of Comp 201

Here are the first 7 IDs in that course: 
9049923
4561909
3208879
7609904
6509987
Exception in thread "main" java.util.NoSuchElementException
	at java.util.Scanner.throwFor(Unknown Source)
	at java.util.Scanner.next(Unknown Source)
	at java.util.Scanner.nextLong(Unknown Source)
	at java.util.Scanner.nextLong(Unknown Source)
	at FileIO5.main(FileIO5.java:74)
*/




/* Contents of StudentInfo.txt file 
This file includes the current registration of Comp 201
9049923		Mike Simon	
4561909		David Hudson 	
3208879		Linda Jacksom	
7609904		Jack Peterson  	
6509987		Anna Jordan

*/