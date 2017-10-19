// -------------------------------------------------------
// Assignment 2
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.pkg3;

import part1.pkg1.PaperPublication;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class Journal extends PaperPublication {

	private int issueNumber;
	private String specialityField;

	/**
	 * default constructor
	 */
	public Journal() {
		super();
	}

	/**
	 * full-parameterized constructor
	 * 
	 * @param price
	 * @param pages
	 * @param issueNumber
	 * @param specialityField
	 */
	public Journal(double price, int pages, int issueNumber, String specialityField) {
		super(price, pages);
		this.issueNumber = issueNumber;
		this.specialityField = specialityField;
	}

	/**
	 * Copy constructor
	 * 
	 * @param j
	 *            the Journal to be copied
	 */
	public Journal(Journal j) {
		super(j);
		this.issueNumber = j.issueNumber;
		this.specialityField = j.specialityField;
	}

	// ----------------------------------
	// begin of accessor and mutators
	// ----------------------------------
	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
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
		return "This Journal has " + this.pages + " pages, and costs " + this.price + "$. Its issue number is " + this.issueNumber + ", and its speciality field is " + this.specialityField + ".";
	}

	public boolean equals(Object o) {
		// The null verification would avoid NullPointException in case that the parameter o is null and "o.getClass()" get invoked.
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Journal j = (Journal) o;
		if (this.price != j.price || this.pages != j.pages || this.issueNumber != j.issueNumber || this.specialityField != j.specialityField) {
			return false;
		}
		return true;
	}
}
