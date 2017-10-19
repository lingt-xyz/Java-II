// -------------------------------------------------------
// Assignment 2
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.pkg1;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class PaperPublication {

	protected double price;
	protected int pages;

	/**
	 * default constructor
	 */
	public PaperPublication() {
	}

	/**
	 * full-parameterized constructor
	 * 
	 * @param price
	 *            the price of the PaperPublication to be set
	 * @param pages
	 *            the number of pages of the PaperPublication to be set
	 */
	public PaperPublication(double price, int pages) {
		super();
		this.price = price;
		this.pages = pages;
	}

	/**
	 * Copy constructor
	 * 
	 * @param p
	 *            the PaperPublication to be copied
	 */
	public PaperPublication(PaperPublication p) {
		this.price = p.price;
		this.pages = p.pages;
	}

	// ----------------------------------
	// begin of accessor and mutators
	// ----------------------------------
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	// ----------------------------------
	// end of accessor and mutators
	// ----------------------------------

	public String toString() {
		return "This Paper Publiction has " + this.pages + " pages, and costs " + this.price + "$.";
	}

	public boolean equals(Object o) {
		// The null verification would avoid NullPointException in case that the parameter o is null and "o.getClass()" get invoked. 
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		PaperPublication p = (PaperPublication) o;
		if (this.price != p.price || this.pages != p.pages) {
			return false;
		}
		return true;
	}
}
