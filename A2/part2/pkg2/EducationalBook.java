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
public class EducationalBook extends Book {

	// ------------------------------------------------------------------------------------------------------------
	// These attributes should be private, because they would only be used by this class.
	// ------------------------------------------------------------------------------------------------------------
	private int editionNumber;
	private String specialityField;

	/**
	 * default constructor
	 */
	public EducationalBook() {
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
	 * @param editionNumber
	 * @param specialityField
	 */
	public EducationalBook(double price, int pages, long ISBN, int issueYear, String title, String authorName, int editionNumber, String specialityField) {
		super(price, pages, ISBN, issueYear, title, authorName);
		this.editionNumber = editionNumber;
		this.specialityField = specialityField;
	}

	/**
	 * Copy constructor
	 * 
	 * @param b
	 *            the EducationalBook to be copied
	 */
	public EducationalBook(EducationalBook b) {
		super(b);
		this.editionNumber = b.editionNumber;
		this.specialityField = b.specialityField;
	}

	// ----------------------------------
	// begin of accessor and mutators
	// ----------------------------------
	public int getEditionNumber() {
		return editionNumber;
	}

	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}

	public String getSpecialityField() {
		return specialityField;
	}

	public void setSpecialityField(String specialityField) {
		this.specialityField = specialityField;
	}
	// ----------------------------------
	// end of accessor and mutators
	// ----------------------------------

	public String toString() {
		return "This Educational Book has " + this.pages + " pages, and costs " + this.price + "$. Its ISBN is " + this.ISBN + ", issue year is " + this.issueYear + ", title is " + this.title
				+ ", author name is " + this.authorName + ", edition number is " + this.editionNumber + ", and its speciality field is " + this.specialityField + ".";
	}

	public boolean equals(Object o) {
		// The null verification would avoid NullPointException in case that the parameter o is null and "o.getClass()" get invoked.
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		EducationalBook b = (EducationalBook) o;
		if (this.price != b.price || this.pages != b.pages || this.ISBN != b.ISBN || this.issueYear != b.issueYear || this.title != b.title || this.authorName != b.authorName
				|| this.editionNumber != b.editionNumber || this.specialityField != b.specialityField) {
			return false;
		}
		return true;
	}
}
