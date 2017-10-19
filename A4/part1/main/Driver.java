// -------------------------------------------------------
// Assignment 4
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import part1.exception.NotWordException;
import part1.word.Word;
import part1.word.WordUtil;

/**
 * @author Ling Tan
 * @author Marzie Shafiee
 *
 */
public class Driver {

	//private static final String FILE_NAME = "./Assignment4/resource/jokes.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "";
		Scanner scanner = null;
		try {
			System.out.print("Please input the file name: ");
			scanner = new Scanner(System.in);
			fileName = scanner.next();
			//fileName = FILE_NAME;
			scanner.close();
			File file = new File(fileName);
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String value = scanner.next();
				try {
					WordUtil.addWord(value);
				} catch (NotWordException e) {
					//System.out.println("----->\"" + value + "\" is not a word, would be abandoned.");
				}
			}
			printWordInfo();
		} catch (FileNotFoundException e) {
			System.out.println("----->Error: could not open file " + fileName + ".");
			System.out.println("----->Program would be terminated.");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void printWordInfo() {
		ArrayList<Word> array = WordUtil.getWordList();
		System.out.println("------------------------------------------------------");
		System.out.println("RANK\tFREQ\tWORD");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < array.size(); i++) {
			Word word = array.get(i);
			System.out.println((i + 1) + "\t" + word.getCount() + "\t" + word.getValue());

		}
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("Number of word tokens: " + WordUtil.getTotal());
		System.out.println("Number of word types:" + array.size());
		System.out.println();
		ArrayList<Word> stopWordList = WordUtil.getStopWordList();
		System.out.println("Number of stop words: " + stopWordList.size());
		System.out.println("% of stop words: " + smartCaculator(stopWordList.size(), array.size()));
		System.out.println("Stop words account for: " + smartCaculator(WordUtil.getStopWordSize(), WordUtil.getTotal()) + " of the text");
		System.out.println();
		ArrayList<Word> happaxList = WordUtil.getHappaxList();
		System.out.println("Number of Happax: " + happaxList.size());
		System.out.println("% of Happax: " + smartCaculator(happaxList.size(), array.size()));
		System.out.println("Happax account for: " + smartCaculator(WordUtil.getHappaxSize(), WordUtil.getTotal()) + " of the text");
	}

	private static String smartCaculator(int x, int y) {
		return NumberFormat.getPercentInstance().format(x / (double) y);
	}
}
