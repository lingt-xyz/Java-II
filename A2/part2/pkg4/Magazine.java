// -------------------------------------------------------
// Assignment 2
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2.pkg4;

import part1.pkg1.PaperPublication;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class Magazine extends PaperPublication {
	public static enum PaperQuality {
		High, Normal, Low
	};

	public static enum IssuingFrequency {
		Weekly, Monthly, Yearly
	};

	// ------------------------------------------------------------------------------------------------------------
	// These attributes should be private, because they would only be used by this class.
	// ------------------------------------------------------------------------------------------------------------
	private PaperQuality pq;
	private IssuingFrequency ify;

	/**
	 * default constructor
	 */
	public Magazine() {
		super();
	}

	/**
	 * full-parameterized constructor
	 * 
	 * @param price
	 * @param pages
	 * @param pq
	 * @param ify
	 */
	public Magazine(double price, int pages, PaperQuality pq, IssuingFrequency ify) {
		super(price, pages);
		this.pq = pq;
		this.ify = ify;
	}

	/**
	 * Copy constructor
	 * 
	 * @param m
	 *            the Magazine to be copied
	 */
	public Magazine(Magazine m) {
		super(m);
		this.pq = m.pq;
		this.ify = m.ify;
	}

	// ----------------------------------
	// begin of accessor and mutators
	// ----------------------------------
	public PaperQuality getPq() {
		return pq;
	}

	public void setPq(PaperQuality pq) {
		this.pq = pq;
	}

	public IssuingFrequency getIfy() {
		return ify;
	}

	public void setIfy(IssuingFrequency ify) {
		this.ify = ify;
	}
	// ----------------------------------
	// end of accessor and mutators
	// ----------------------------------

	public String toString() {
		return "This Magazine has " + this.pages + " pages, and costs " + this.price + "$. Its paper quality is " + this.pq + ", and its issuing frequency is " + this.ify + ".";
	}

	public boolean equals(Object o) {
		// The null verification would avoid NullPointException in case that the parameter o is null and "o.getClass()" get invoked.
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Magazine m = (Magazine) o;
		if (this.price != m.price || this.pages != m.pages || this.pq != m.pq || this.ify != m.ify) {
			return false;
		}
		return true;
	}
}
