// *******************************************************************
// FileIO15.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates "random access" files. 
// 
// Key Points:
// 1) Writing to & Reading from Random Access Files.
// 2) The RandomAccessFile Class.
// *******************************************************************

import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FileIO15{
  public static void main(String[] args)
  {
     try
     {
    	 // Open a random access file for reading and writing
         RandomAccessFile ra = new RandomAccessFile("RAInfo", "rw");

         System.out.println("At start, the file pointer location is: " 
                 + ra.getFilePointer( ));

         System.out.println("Writing 3 integers to the file."); // An integer is 4 bytes
         ra.writeInt(458);
         ra.writeInt(25);
         ra.writeInt(94);
         
         System.out.println("The length of the file now is: "
        		 			+ ra.length( ) + " bytes.");
         
         System.out.println("Writing 2 bytes to the file.");
         ra.writeByte(50);
         ra.writeByte(36);

         System.out.println("The length of the file now is: "
                             + ra.length( ) + " bytes.");
         
         System.out.println("Currently, the file pointer location is: " 
                             + ra.getFilePointer( ));

         System.out.println("Moving the file pointer to location 0.");
         ra.seek(0);
         
         System.out.println("The value at location # 0 is: " + ra.readInt()); // MUST remember the type at that location
         
         System.out.println("Currently, the file pointer location is: " 
                 + ra.getFilePointer( ));

         System.out.println("The value at location # 4 is: " + ra.readInt()); 
         
         // WARNING: The following will compile & run BUT misbehave 
         System.out.println("===== WARNING: The following will compile & run BUT misbehave =====");
         ra.seek(3); 	// That is in the middle of the first integer 

         System.out.println("Trying to read an integer from location # 3. " +
         		"The value at location # 3 is: " + ra.readInt());
         
         // Seek back to location # 3 (The last read did move the location
         ra.seek(3); 	// That is in the middle of the first integer 
        
         System.out.println("Trying to read a byte from location # 3. " +
          		"The value at location # 3 is: " + ra.readByte());
        
         // Now analyze the following
         ra.seek(7); 	// That is in the middle of the second integer; actually last byte of it 
         System.out.println("Trying to read an integer from location # 7. " +
          		"The value at location # 7 is: " + ra.readInt());
          
          // Seek back to location # 7 (The last read did move the location)
          ra.seek(7); 	// That is in the middle of the first integer 
         
          System.out.println("Trying to read a byte from location # 7. " +
           		"The value at location # 7 is: " + ra.readByte());        
         System.out.println("=============== End of misbehavior ===============");
    

         System.out.println("Will move to the last location of the file," +
         		" and write a double.");

         long i = ra.length();	// keep track of that location, where we will write a double
         ra.seek(ra.length( ));
         ra.writeDouble(76.34);	// A double is 8 bytes
         
 
         System.out.println("The length of the file now is: " + ra.length( ) + " bytes.");

         System.out.println("Returning to location # " + i + ", where we wrote the double.....");
         ra.seek(i);
         double d = ra.readDouble( );		// Surely you can display it directly in the println() as above
         System.out.println("The double value at location # " + i + " is: " + d);

         System.out.println("The final length of the file before closing it is: " + ra.length( ) + " bytes.");

         ra.close( );	// Finally, must close the file
     }
     catch(FileNotFoundException e)
     {
         System.out.println("Problem opening file.");
     }
     catch(IOException e)
     {
         System.out.println("Problems with file I/O.");
     }
     System.out.println("End of program.");
  }
}

/* The Output 
At start, the file pointer location is: 0
Writing 3 integers to the file.
The length of the file now is: 12 bytes.
Writing 2 bytes to the file.
The length of the file now is: 14 bytes.
Currently, the file pointer location is: 14
Moving the file pointer to location 0.
The value at location # 0 is: 458
Currently, the file pointer location is: 4
The value at location # 4 is: 25
===== WARNING: The following will compile & run BUT misbehave =====
Trying to read an integer from location # 3. The value at location # 3 is: -905969664
Trying to read a byte from location # 3. The value at location # 3 is: -54
Trying to read an integer from location # 7. The value at location # 7 is: 419430400
Trying to read a byte from location # 7. The value at location # 7 is: 25
=============== End of misbehavior ===============
Will move to the last location of the file, and write a double.
The length of the file now is: 22 bytes.
Returning to location # 14, where we wrote the double.....
The double value at location # 14 is: 76.34
The final length of the file before closing it is: 22 bytes.
End of program.
*/

/* Run Again - Notice the file size carefully
At start, the file pointer location is: 0
Writing 3 integers to the file.
The length of the file now is: 22 bytes.
Writing 2 bytes to the file.
The length of the file now is: 22 bytes.
Currently, the file pointer location is: 14
Moving the file pointer to location 0.
The value at location # 0 is: 458
Currently, the file pointer location is: 4
The value at location # 4 is: 25
===== WARNING: The following will compile & run BUT misbehave =====
Trying to read an integer from location # 3. The value at location # 3 is: -905969664
Trying to read a byte from location # 3. The value at location # 3 is: -54
Trying to read an integer from location # 7. The value at location # 7 is: 419430400
Trying to read a byte from location # 7. The value at location # 7 is: 25
=============== End of misbehavior ===============
Will move to the last location of the file, and write a double.
The length of the file now is: 30 bytes.
Returning to location # 22, where we wrote the double.....
The double value at location # 22 is: 76.34
The final length of the file before closing it is: 30 bytes.
End of program.
*/

/* Run 3rd time - Notice the file size carefully. Why? Hint: issue ra.setLength(0); at start before using the file
At start, the file pointer location is: 0
Writing 3 integers to the file.
The length of the file now is: 30 bytes.
Writing 2 bytes to the file.
The length of the file now is: 30 bytes.
Currently, the file pointer location is: 14
Moving the file pointer to location 0.
The value at location # 0 is: 458
Currently, the file pointer location is: 4
The value at location # 4 is: 25
===== WARNING: The following will compile & run BUT misbehave =====
Trying to read an integer from location # 3. The value at location # 3 is: -905969664
Trying to read a byte from location # 3. The value at location # 3 is: -54
Trying to read an integer from location # 7. The value at location # 7 is: 419430400
Trying to read a byte from location # 7. The value at location # 7 is: 25
=============== End of misbehavior ===============
Will move to the last location of the file, and write a double.
The length of the file now is: 38 bytes.
Returning to location # 30, where we wrote the double.....
The double value at location # 30 is: 76.34
The final length of the file before closing it is: 38 bytes.
End of program.

*/
