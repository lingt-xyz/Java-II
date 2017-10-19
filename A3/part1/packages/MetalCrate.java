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
public class MetalCrate extends Crate {
	
	/**
	 * The start letter of the trackingNumber of a MetalCrate object.
	 */
	static final char PACKAGE_TYPE_METAL_CRATE = '3';
	private static final double COST_PER_OUNCE = 3;// per pound
	private static final int MAX_WEIGHT = 100;// pounds

	protected MetalCrate(String trackingNumber, double weight) {
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
