// *******************************************************************
// FileIO13.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates "binary" files further. In specific,
// the program shows how binary files can be read.
// 
// Key Points:
// 1) Reading from Binary Files Using the ObjectInputStream Class. 
// *******************************************************************

import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;


public class FileIO13{
	
	public static void main(String[] args) 
	{
		
		// This program reads a course student registration stored in a binary file,
		// of a known format, then displays this information. 
		
		long id;
		String fileName, courseName, firstName, lastName, jk, s;
		char ch1, ch2, ch3;
		Scanner kb = new Scanner(System.in);
		
		
		System.out.print("Please enter the \"binary\" registration file name you wish to read: "); 
		fileName = kb.next();
		
		ObjectInputStream ois = null;
		
		
		try
		{
			// Create an ObjectInputStream to read from the binary file 
			ois = new ObjectInputStream(new FileInputStream(fileName));
			
			// If this point is reached, then the stream was created successfully. 
			// So, start reading the file from its start until no more data can be read.
			// When an attempt to read beyond the end of the file is reached, and exception 
			// is thrown. We will use this as an indication of the end of the file. 
			
			System.out.println("Here is the information stored in this file: ");
			System.out.println("============================================\n ");
			
			
			try
			{
				s = ois.readUTF();		// Reads the first line of the file and display it
				System.out.println(s);
				while(true)			
				{
					// read the id, the two tabs, the first name, the space, then the last name
				
					id = ois.readLong();
					ch1 = ois.readChar();				// Read the two tabs 
					ch2 = ois.readChar();
					firstName = ois.readUTF();		
					ch3 = ois.readChar();				// Read the space between the names
					lastName = ois.readUTF();
				
					System.out.println("" + id + ch1 + ch2 + firstName + ch3 + lastName);
				}
			}
			catch(EOFException e)
			{
				System.out.println("Reading " + fileName + " has been completed.");
			}
			ois.close();		// Close the file
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File: " + fileName + " could not been found.");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		catch(IOException e)
		{
			System.out.println("Error: Problem Reading from file: " + fileName + ".");
			System.out.println("Program will terminate.");
			System.exit(0);			
		}
	}
}

/* The Output 
Please enter the "binary" registration file name you wish to read: Comp249_registeration.dat
Here is the information stored in this file: 
============================================
 
This file includes the registration of Comp249.
9082320		Mike Simon
7822340		Linda Jackson
4532098		Mark Rogers
8830916		David Peterson
Reading Comp249_registeration.dat has been completed.
*/
