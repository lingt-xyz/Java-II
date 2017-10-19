// -------------------------------------------------------
// Assignment 2
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------

package part2;

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

	/**
	 * The method take an array of PaperPublication as input and returns an array of PaperPublication
	 * 
	 * @param pps
	 * @return
	 */
	private static PaperPublication[] copyBooks(PaperPublication[] pps) {
		PaperPublication[] copyOfPps = new PaperPublication[pps.length];
		for (int i = 0; i < pps.length; i++) {
			PaperPublication pp = pps[i];
			if (pp.getClass() == Magazine.class) {
				copyOfPps[i] = new Magazine((Magazine) pp);
			} else if (pp.getClass() == Journal.class) {
				copyOfPps[i] = new Journal((Journal) pp);
			} else if (pp.getClass() == ChildrenBook.class) {
				copyOfPps[i] = new ChildrenBook((ChildrenBook) pp);
			} else if (pp.getClass() == EducationalBook.class) {
				copyOfPps[i] = new EducationalBook((EducationalBook) pp);
			} else if (pp.getClass() == Book.class) {
				copyOfPps[i] = new Book((Book) pp);
			} else {
				copyOfPps[i] = new PaperPublication(pp);
			}
		}
		return copyOfPps;
	}

	public static void main(String[] args) {
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("|                  1.Create an array of 12 Objects.                                                      |");
		System.out.println("|                  2.Call the copyBooks() method to create a copy of the that array.                     |");
		System.out.println("|                  3.Display the contents of both arrays.                                                |");
		System.out.println("----------------------------------------------------------------------------------------------------------");

		PaperPublication pp1 = new PaperPublication(20, 49);
		Book book1 = new Book(109, 513, 1129536123L, 1983, "New Life", "Jay");
		Book book2 = new Book(320, 899, 7427539123L, 2013, "Who am I", "Larry");
		ChildrenBook cb1 = new ChildrenBook(9, 10, 1111539123L, 2016, "I'm a big sister", "Lily", 3);
		ChildrenBook cb2 = new ChildrenBook(5, 8, 1111329123L, 2011, "My Teddy Bear", "Tom", 1);
		EducationalBook eb1 = new EducationalBook(399, 1021, 7236329123L, 2003, "New Java", "Lee", 2, "Computer Science");
		Journal journal1 = new Journal(12, 60, 1, "Computer Languages");
		Journal journal2 = new Journal(19, 52, 3, "Computer Languages");
		Journal journal3 = new Journal(66, 200, 6, "Java 2");
		Magazine magazine1 = new Magazine(2, 8, Magazine.PaperQuality.High, Magazine.IssuingFrequency.Weekly);
		Magazine magazine2 = new Magazine(19, 30, Magazine.PaperQuality.Normal, Magazine.IssuingFrequency.Monthly);
		Magazine magazine3 = new Magazine(20, 90, Magazine.PaperQuality.Low, Magazine.IssuingFrequency.Yearly);
		PaperPublication[] pps = new PaperPublication[] { pp1, book1, book2, cb1, cb2, eb1, journal1, journal2, journal3, magazine1, magazine2, magazine3 };

		PaperPublication[] newPps = Driver.copyBooks(pps);
		System.out.println("--------------------------------original array------------------------------------------------");
		for (PaperPublication pp : pps) {
			System.out.println();
			System.out.print(pp.toString());
		}

		System.out.println();
		System.out.println();
		System.out.println("---------------------------------result array-------------------------------------------------");
		for (PaperPublication pp : newPps) {
			System.out.println();
			System.out.print(pp.toString());
		}
		//The result would be: the array is copied correctly because the type of each object in the original array is checked and confirmed before the copying.
		
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("|--------------The Program of the Part 2 of the Assignment 2 has terminated.-----------------------------|");
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}

}
