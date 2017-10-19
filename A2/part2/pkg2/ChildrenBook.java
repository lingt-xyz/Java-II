// -------------------------------------------------------
// Assignment 2
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2.pkg2;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class ChildrenBook extends Book {

	// ------------------------------------------------------------------------------------------------------------
	// This attribute should be private, because this attribute would only be used by this class.
	// ------------------------------------------------------------------------------------------------------------
	private int minimumAge;

	/**
	 * default constructor
	 */
	public ChildrenBook() {
		super();
	}

	/**
	 * full-parameterized constructor
	 * 
	 * @param price
	 * @param pages
	 * @param ISBN
	 * @param issueYear
	 * @param title
	 * @param authorName
	 * @param minimumAge
	 */
	public ChildrenBook(double price, int pages, long ISBN, int issueYear, String title, String authorName, int minimumAge) {
		super(price, pages, ISBN, issueYear, title, authorName);
		this.minimumAge = minimumAge;
	}

	/**
	 * Copy constructor
	 * 
	 * @param c
	 *            the ChildrenBook to be copied
	 */
	public ChildrenBook(ChildrenBook c) {
		super(c);
		this.minimumAge = c.minimumAge;
	}

	// ----------------------------------
	// begin of accessor and mutators
	// ----------------------------------
	public int getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}
	// ----------------------------------
	// end of accessor and mutators
	// ----------------------------------

	public String toString() {
		return "This Children Book has " + this.pages + " pages, and costs " + this.price + "$. Its ISBN is " + this.ISBN + ", issue year is " + this.issueYear + ", title is " + this.title
				+ ", author name is " + this.authorName + ", and it's suitable for age " + this.minimumAge + " and up.";
	}

	public boolean equals(Object o) {
		// The null verification would avoid NullPointException in case that the parameter o is null and "o.getClass()" get invoked.
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		ChildrenBook c = (ChildrenBook) o;
		if (this.price != c.price || this.pages != c.pages || this.ISBN != c.ISBN || this.issueYear != c.issueYear || this.title != c.title || this.authorName != c.authorName
				|| this.minimumAge != c.minimumAge) {
			return false;
		}
		return true;
	}
}
