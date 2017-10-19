// -------------------------------------------------------
// Assignment 2
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.pkg2;

import part1.pkg1.PaperPublication;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class Book extends PaperPublication {

	protected long ISBN;
	protected int issueYear;
	protected String title;
	protected String authorName;

	/**
	 * default constructor
	 */
	public Book() {
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
	 */
	public Book(double price, int pages, long ISBN, int issueYear, String title, String authorName) {
		super(price, pages);
		this.ISBN = ISBN;
		this.issueYear = issueYear;
		this.title = title;
		this.authorName = authorName;
	}

	/**
	 * Copy constructor
	 * 
	 * @param b
	 *            the Book to be copied
	 */
	public Book(Book b) {
		super(b);
		this.ISBN = b.ISBN;
		this.issueYear = b.issueYear;
		this.title = b.title;
		this.authorName = b.authorName;
	}

	// ----------------------------------
	// begin of accessor and mutators
	// ----------------------------------
	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public int getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	// ----------------------------------
	// end of accessor and mutators
	// ----------------------------------

	public String toString() {
		return "This Book has " + this.pages + " pages, and costs " + this.price + "$. Its ISBN is " + this.ISBN + ", issue year is " + this.issueYear + ", title is " + this.title
				+ ", and its author name is " + this.authorName + ".";
	}

	public boolean equals(Object o) {
		// The null verification would avoid NullPointException in case that the parameter o is null and "o.getClass()" get invoked.
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Book b = (Book) o;
		if (this.price != b.price || this.pages != b.pages || this.ISBN != b.ISBN || this.issueYear != b.issueYear || this.title != b.title || this.authorName != b.authorName) {
			return false;
		}
		return true;
	}
}
