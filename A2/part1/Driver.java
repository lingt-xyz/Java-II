// -------------------------------------------------------
// Assignment 2
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------

package part1;

import part1.pkg1.PaperPublication;
import part1.pkg2.Book;
import part1.pkg2.ChildrenBook;
import part1.pkg2.EducationalBook;
import part1.pkg3.Journal;
import part1.pkg4.Magazine;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class Driver {

	public static void main(String[] args) {
		// Create various objects from the 6 classes, and display all their information using the toString() method.
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("|                    Display all objects' information using the toString() method.                       |");
		System.out.println("----------------------------------------------------------------------------------------------------------");

		PaperPublication pp = new PaperPublication(20, 49);
		System.out.println(pp.toString() + "\n");

		Book book = new Book(pp.getPrice(), pp.getPages(), 1123539123L, 1983, "NoJava", "Tim");
		System.out.println(book.toString() + "\n");

		ChildrenBook cb = new ChildrenBook(book.getPrice(), book.getPages(), book.getISBN(), book.getIssueYear(), book.getTitle(), book.getAuthorName(), 3);
		System.out.println(cb.toString() + "\n");

		EducationalBook eb = new EducationalBook(book.getPrice(), book.getPages(), book.getISBN(), book.getIssueYear(), book.getTitle(), book.getAuthorName(), 2, "Computer Science");
		System.out.println(eb.toString() + "\n");

		Journal journal = new Journal(pp.getPrice(), pp.getPages(), 1, "Computer Languages");
		System.out.println(journal.toString() + "\n");

		Magazine magazine = new Magazine(pp.getPrice(), pp.getPages(), Magazine.PaperQuality.High, Magazine.IssuingFrequency.Weekly);
		System.out.println(magazine.toString() + "\n");

		// Test the equality of some of the created objects using the equals() method.
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("|              Test the equality of some of these created objects using the euqals() method.             |");
		System.out.println("----------------------------------------------------------------------------------------------------------");

		System.out.println("The PaperPublication pp equals to the Book book? : " + (pp.equals(book) ? "Yes" : "No"));
		System.out.println("The Book book equals to the ChidlrenBook cb? : " + (book.equals(cb) ? "Yes" : "No"));
		System.out.println("The ChidlrenBook cb equals to the EducationalBook eb? : " + (cb.equals(eb) ? "Yes" : "No"));

		// Create an array of 10 PaperPublication objects and fill that array with various objects from the 6 classes (each class must have at least one entry in that array).
		PaperPublication pp1 = new PaperPublication(20, 49);
		Book book1 = new Book(109, 513, 1129536123L, 1983, "New Life", "Jay");
		Book book2 = new Book(320, 899, 7427539123L, 2013, "Who am I", "Larry");
		ChildrenBook cb1 = new ChildrenBook(9, 10, 1111539123L, 2016, "I'm a big sister", "Lily", 3);
		ChildrenBook cb2 = new ChildrenBook(5, 8, 1111329123L, 2011, "My Teddy Bear", "Tom", 1);
		EducationalBook eb1 = new EducationalBook(399, 1021, 7236329123L, 2003, "New Java", "Lee", 2, "Computer Science");
		Journal journal1 = new Journal(12, 60, 1, "Computer Languages");
		Journal journal2 = new Journal(19, 52, 3, "Computer Languages");
		Magazine magazine1 = new Magazine(2, 8, Magazine.PaperQuality.High, Magazine.IssuingFrequency.Weekly);
		Magazine magazine2 = new Magazine(19, 30, Magazine.PaperQuality.Normal, Magazine.IssuingFrequency.Monthly);
		PaperPublication[] pps = new PaperPublication[] { pp1, book1, book2, cb1, cb2, eb1, journal1, journal2, magazine1, magazine2 };

		// Trace(search) that array to find the object that is least expensive (has lowest price) and the one that is most expensive. Display all information of these two objects along with their location (index) in the array.
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("|       Create an array of 10 Objects. Find the least and most expensive ones.          |");
		System.out.println("----------------------------------------------------------------------------------------------------------");

		Driver driver = new Driver();
		int indexOfLowest = driver.getIndexOfLowestPrice(pps);
		int indexOfHighest = driver.getIndexOfHighestPrice(pps);
		System.out.println("The PaperPublication with lowest price is positioned at : " + indexOfLowest + ", and " + pps[indexOfLowest].toString());
		System.out.println("The PaperPublication with highest price is positioned at : " + indexOfHighest + ", and " + pps[indexOfHighest].toString());

		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("|--------------The Program of the Part I of the Assignment 2 has terminated.-----------------------------|");
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}

	/**
	 * Find the index of the PaperPublication which has the lowest price
	 * 
	 * @param pps
	 * @return
	 */
	private int getIndexOfLowestPrice(PaperPublication[] pps) {
		double lowest = Double.MAX_VALUE;
		int indexOfLowest = -1;
		for (int i = 0; i < pps.length; i++) {
			PaperPublication p = pps[i];
			if (p.getPrice() < lowest) {
				lowest = p.getPrice();
				indexOfLowest = i;
			}
		}
		return indexOfLowest;
	}

	/**
	 * Find the index of the PaperPublication which has the lowest price
	 * 
	 * @param pps
	 * @return
	 */
	private int getIndexOfHighestPrice(PaperPublication[] pps) {
		double highest = 0.0;
		int indexOfHighest = -1;
		for (int i = 0; i < pps.length; i++) {
			PaperPublication p = pps[i];
			if (p.getPrice() > highest) {
				highest = p.getPrice();
				indexOfHighest = i;
			}
		}
		return indexOfHighest;
	}

}
