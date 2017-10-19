// -------------------------------------------------------
// Assignment 3
// Part: II
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @authors Ling Tan
 * @author Marzie Shafiee
 *
 */
public class WarshipInventory1 {

	private static Warship[] wsArr;
	private static final String INPUT_FILE_NAME = "./Assignment3/resource/Initial_Warship_Info.txt";
	private Scanner sc;

	public static void main(String[] args) {
		WarshipInventory1 wsi = new WarshipInventory1();
		wsi.sc = new Scanner(System.in);
		try {
			File outputFile = wsi.createDestinationFile();
			wsi.fixInventory(new FileInputStream(INPUT_FILE_NAME), new FileOutputStream(outputFile));
			System.out.println("\n--------------File content BEFORE correction--------------");
			wsi.displayFileContents(new FileInputStream(INPUT_FILE_NAME));
			System.out.println("\n--------------File content AFTER correction--------------");
			wsi.displayFileContents(new FileInputStream(outputFile));
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files. Cannot proceed to next step.");
			System.out.println("Program will terminate.");
		} catch (IOException e) {
			System.out.println("Error: An error has occurred: " + e.getMessage());
			System.out.println("Program will terminate.");
		} catch (Exception e) {
			System.out.println("Error: An error has occurred: " + e.getMessage());
			System.out.println("Program will terminate.");
		} finally {
			wsi.sc.close();
		}
	}

	/**
	 * Correct the serial number in the original file, and write the result into the output file
	 * 
	 * @param fis
	 *            the stream related to the Initial_Warship_Info.txt
	 * @param fos
	 *            the stream related to an output file name
	 */
	private void fixInventory(FileInputStream fis, FileOutputStream fos) throws FileNotFoundException, IOException, Exception {
		int numberOfRecord = this.getNumberOfLines(INPUT_FILE_NAME);
		if (numberOfRecord == 0 || numberOfRecord == 1) {
			System.out.println("The " + INPUT_FILE_NAME + " is empty or only has one record. The program would do nothing and terminate.");
		} else {
			wsArr = new Warship[numberOfRecord];
			this.readFileToArray(fis, wsArr);
			this.correctSerialNumber();
			this.writeArrayToFile(wsArr, fos);
		}
	}

	/**
	 * Displays the contents of input file stream to the standard output (the screen)
	 * 
	 * @param fis
	 * @throws Exception
	 */
	private void displayFileContents(FileInputStream fis) throws Exception {
		Scanner scanner = null;
		try {
			scanner = new Scanner(fis);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/**
	 * Ask user to give the destination file name.
	 * 
	 * @return
	 */
	private File createDestinationFile() {
		System.out.print("Please enter the name of the output file that will be created to hold the modified/correct inventory: ");
		String fileName = sc.nextLine();
		File file = new File(fileName);
		while (file.exists()) {
			System.out.println("----->A file with the name of \"" + fileName + "\" [size = " + file.length() + " bytes; path = " + file.getAbsolutePath() + "] already exists.<-----");
			System.out.print("Please input a new file name: ");
			fileName = sc.nextLine();
			file = new File(fileName);
		}
		return file;
	}

	/**
	 * Get the number of lines in the given file
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private int getNumberOfLines(String fileName) throws FileNotFoundException, IOException {
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(new FileReader(fileName));
			while (reader.readLine() != null)
				;
			return reader.getLineNumber();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	/**
	 * Read the inputstream to an array
	 * 
	 * @param fis
	 * @param wsArr
	 * @throws Exception
	 */
	private void readFileToArray(FileInputStream fis, Warship[] wsArr) throws Exception {
		Scanner scanner = null;
		try {
			scanner = new Scanner(fis);
			int i = 0;
			while (scanner.hasNextLine()) {
				wsArr[i] = this.getWarship(scanner.nextLine());
				i++;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/**
	 * Correct the duplicate serial number
	 */
	private void correctSerialNumber() {
		for (int i = 0; i < wsArr.length; i++) {
			for (int j = i + 1; j < wsArr.length; j++) {
				if (wsArr[j].getSerialNumber() == wsArr[i].getSerialNumber()) {
					while (true) {
						System.out.println("Duplicate serial number " + wsArr[j].getSerialNumber() + " detected in record # " + (j + 1) + ".");
						long serialNumber = this.getNewSerialNumber();
						try {
							this.verifyDuplication(j, serialNumber);
							wsArr[j].setSerialNumber(serialNumber);
							break;
						} catch (DuplicateSerialNumberException e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
	}

	/**
	 * Verify whether the seial number is still duplicate after correction
	 * 
	 * @param index
	 * @param serialNumber
	 * @throws DuplicateSerialNumberException
	 */
	private void verifyDuplication(int index, long serialNumber) throws DuplicateSerialNumberException {
		for (int i = 0; i < wsArr.length; i++) {
			if (i == index) {
				continue;
			}
			if (wsArr[i].getSerialNumber() == serialNumber) {
				throw new DuplicateSerialNumberException(i + 1, serialNumber);
			}
		}
	}

	/**
	 * Ask user to give a new serial number
	 * 
	 * @return
	 */
	private long getNewSerialNumber() {
		System.out.print("Please enter the correct serial number: ");
		try {
			return sc.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("----->Invalid input. A number was expected.<-----");
			sc.nextLine();
			return this.getNewSerialNumber();
		}
	}

	/**
	 * Write array to a file
	 * 
	 * @param wsArr
	 * @param fos
	 * @throws Exception
	 */
	private void writeArrayToFile(Warship[] wsArr, FileOutputStream fos) throws Exception {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fos);
			for (Warship ws : wsArr) {
				if (ws != null) {
					pw.println(ws);
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	/**
	 * Initiate a Warship from a string
	 * 
	 * @param info
	 * @return
	 */
	private Warship getWarship(String info) {
		String[] infos = info.split(" ");
		return new Warship(Long.parseLong(infos[0]), infos[1], Integer.parseInt(infos[2]), infos[3], Double.parseDouble(infos[4]), Integer.parseInt(infos[5]));
	}
}
