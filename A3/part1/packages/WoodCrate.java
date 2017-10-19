// -------------------------------------------------------
// Assignment 3
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.packages;

/**
 * Letter Class, the subclass of Package
 * 
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class WoodCrate extends Crate {

	/**
	 * The start letter of the trackingNumber of a WoodCrate object.
	 */
	static final char PACKAGE_TYPE_WOOD_CRATE = '2';
	private static final double COST_PER_OUNCE = 2.5;// per pound
	private static final int MAX_WEIGHT = 80;// pounds

	protected WoodCrate(String trackingNumber, double weight) {
		super(trackingNumber, weight);
	}

	@Override
	protected double getCostPerUnit() {
		return COST_PER_OUNCE;
	}

	@Override
	protected int getMaxWeight() {
		return MAX_WEIGHT;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
