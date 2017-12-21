// *******************************************************************
// HashTable1.java By: Aiman Hanna (C) 1993 - 2017
// This program introduces hash tables.
// 
// Key Points:
// 1) Hash Tables. 
// 2) Hash Functions.
// 3) Collision. 
// *******************************************************************


import java.util.Scanner;


// A linked list class that keeps tracks of movies available at a video store
class MovieList
{
	
	// Inner Node class. Each node has an movie name and link to the next node (or null). 
	class MovieNode
	{
		private String MovieName;
		private MovieNode next;

		
		// Default constructors 
		public MovieNode()
		{
			MovieName = "";
		}
		
		
		// Parameterized constructor 
		public MovieNode(String mn, MovieNode xt)
		{
			MovieName = mn;
			next = xt;

		}
		
		public void setMovieName(String mn)
		{
			MovieName = mn;
		}
		


		public void setNext(MovieNode xt)
		{
			next = xt;
		}
		
		public String getMovieName()
		{
			return MovieName;
		}
		

		
		public MovieNode getNext()
		{
			return next;
		}
}

	private MovieNode head;
	private int size = 0;
	
	// Constructor
	public MovieList()
	{
		head = null;
	}
	
	// A method that adds a node to the start of the list 	
	public void addToStart(String nm)
	{
		head = new MovieNode(nm, head);	
		size++;
	}

	// A method that removes a node form the start of the list 
	public boolean deleteFromStart()
	{
		if (head != null)
		{
			head = head.next;
			size--;
			return true;
		}
		else
			return false;
	}
	
	// A method to return the size of the list
	public int getSize()
	{
		return size;
	}
	
	// A method that searches the list for a given movie name and returns the first node that 
	// has this name of null if the name is not in the list
	public MovieNode find(String nm)
	{
		MovieNode temp = head;
		while( temp != null )
		{
			if (temp.MovieName.equalsIgnoreCase(nm))
			{
				return temp;
			}
			temp = temp.next;		// Move temp to the next node
		}
		// If this point is reached then the movie was not found in the list
		return null;
	}

	// A method that indicates whether or not a movie is in the list
	public boolean contains(String nm)
	{
		if(find(nm) != null)
			return true;
		else 
			return false;
	}

	

	
	public void showListContents()
	{
		MovieNode temp = head;
		if (temp == null)
			System.out.println("List is empty; nothing to display." );
		else
		{
			System.out.println("Here are the contents of the list." );
			while(temp != null)
			{
				System.out.print(temp.MovieName +  " ---> ");
				temp = temp.getNext();		// Move to the next node
			}
			System.out.println("X");	// Just show "X" indicating the end of the list (null)
		}
	}
	
}

class MovieHashTable
{
	// Attributes 
	// An array of MovieList
	private MovieList[] hashArr;
	private static final int SIZE = 10;
	
	// Constructor - Creates an array of 10 lists
	public MovieHashTable()
	{
		hashArr = new MovieList[SIZE];	
		for (int i = 0; i < hashArr.length; i++)
			hashArr[i] = new MovieList();
	}
	
	
	// A method that accept a string and computes a hash value for that string
	private int computeHash(String mn)
	{
		// The hash value here is computed as a value between 0 & 9 depending on the 
		// ASCII value of first character on the passed string. 
		// We do not want to have case sensitivity here, so always convert to upper case
		int hashValue = mn.toUpperCase().charAt(0);
		hashValue = hashValue % SIZE;
		return hashValue;
	}
	
	public boolean containsMovie(String nm)
	{
		// First, compute the hash value from the given movie name
		int hashValue = computeHash(nm.toUpperCase());
		
		// Then, get the list at the proper hash location
		MovieList mlst = hashArr[hashValue];
		
		// Finally, find out whether or not the movie is in that list
		if(mlst.contains(nm))
			return true;
		return false;
	}
	
	
	// A method that adds a given movie name into the proper location in the hash table
	// If the movie already in the list, it will not be added
	public void addToHash(String nm)
	{
		int hashValue = computeHash(nm);
		MovieList mlst = hashArr[hashValue];
		// add the movie name only if it is not in the list
		if(!mlst.contains(nm))
		{
			hashArr[hashValue].addToStart(nm);
		}
	}
	
	public void showHashTableContents()
	{
		System.out.println("Here are the contents of the hash table: ");
		System.out.println("======================================== ");
		
		for (int i = 0; i < hashArr.length; i++)
		{
			System.out.println("\nList at index " + i + " has the following information: ");
			hashArr[i].showListContents();
		}
	}
} // End of MovieHashTable class



public class HashTable1{

	
	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		String s;
		
		
		// Create an empty list
		MovieHashTable h = new MovieHashTable();
		
		System.out.print("To add movies to the video store hash table, enter the name. " +
				"\nYou must enter one name per line. Enter \"DONE!\" to terminate: ");
		
		s = kb.nextLine();
		while (!s.equalsIgnoreCase("DONE!"))
		{
			h.addToHash(s);
			//System.out.print("Please enter the following movie name to add, or  \"DONE!\" to terminate: ");
			s = kb.nextLine();
		}
		
		h.showHashTableContents();
		
		
		System.out.print("\nYou can now search for movies in the hash table; enter movie name, or \"DONE!\" to terminate: ");
		
		s = kb.nextLine();
		while (!s.equalsIgnoreCase("DONE!"))
			{
				if(h.containsMovie(s))
					System.out.println("Yes; this movie \"" + s.toUpperCase() + "\" is in the video store.");
				else
					System.out.println("Sorry; we do not have this movie \"" + s.toUpperCase() + "\" in the video store.");
				
				
				System.out.print("Please enter the next movie name to search, or  \"DONE!\" to terminate: ");
				s = kb.nextLine();
			}
		
		
		
		System.out.println("\nThanks for using our Hash Table. Goodbye.");
	}
}

/* The Output 
To add movies to the video store hash table, enter the name. 
You must enter one name per line. Enter "DONE!" to terminate: Avatar
The Blind Side
Gone with the Wind
Iron Man
Swing Vote
Bandits
The King and I
Fly Me to the Moon
The God Father
Speed 2
The King and I
done!
Here are the contents of the hash table: 
======================================== 

List at index 0 has the following information: 
Here are the contents of the list.
Fly Me to the Moon ---> X

List at index 1 has the following information: 
Here are the contents of the list.
Gone with the Wind ---> X

List at index 2 has the following information: 
List is empty; nothing to display.

List at index 3 has the following information: 
Here are the contents of the list.
Speed 2 ---> Swing Vote ---> Iron Man ---> X

List at index 4 has the following information: 
Here are the contents of the list.
The God Father ---> The King and I ---> The Blind Side ---> X

List at index 5 has the following information: 
Here are the contents of the list.
Avatar ---> X

List at index 6 has the following information: 
Here are the contents of the list.
Bandits ---> X

List at index 7 has the following information: 
List is empty; nothing to display.

List at index 8 has the following information: 
List is empty; nothing to display.

List at index 9 has the following information: 
List is empty; nothing to display.

You can now search for movies in the hash table; enter movie name, or "DONE!" to terminate: King Kong
Sorry; we do not have this movie "KING KONG" in the video store.
Please enter the next movie name to search, or  "DONE!" to terminate: Iron Man
Yes; this movie "IRON MAN" is in the video store.
Please enter the next movie name to search, or  "DONE!" to terminate: avatar
Yes; this movie "AVATAR" is in the video store.
Please enter the next movie name to search, or  "DONE!" to terminate: hulk
Sorry; we do not have this movie "HULK" in the video store.
Please enter the next movie name to search, or  "DONE!" to terminate: the blind side
Yes; this movie "THE BLIND SIDE" is in the video store.
Please enter the next movie name to search, or  "DONE!" to terminate: Bandits
Yes; this movie "BANDITS" is in the video store.
Please enter the next movie name to search, or  "DONE!" to terminate: done!

Thanks for using our Hash Table. Goodbye.
*/
