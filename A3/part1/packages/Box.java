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
public class Box extends Package {
	/**
	 * The start letter of the trackingNumber of a Box object.
	 */
	static final char PACKAGE_TYPE_BOX = '1';
	private static final WEIGHT_UNIT BOX_WEIGHT_UNIT = WEIGHT_UNIT.Pound;
	private static final double COST_PER_OUNCE = 2;// per pound
	private static final int MAX_WEIGHT = 40;// pounds

	protected Box(String trackingNumber, double weight) {
		super(trackingNumber, weight);
	}

	@Override
	protected WEIGHT_UNIT getWeightUnit() {
		return BOX_WEIGHT_UNIT;
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
