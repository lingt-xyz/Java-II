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
public class Letter extends Package {

	/**
	 * The start letter of the trackingNumber of a Letter object.
	 */
	static final char PACKAGE_TYPE_LETTER = '0';
	private static final WEIGHT_UNIT LETTER_WEIGHT_UNIT = WEIGHT_UNIT.Ounce;
	private static final double COST_PER_OUNCE = 0.05;// per ounce
	private static final int MAX_WEIGHT = 32;// ounces

	protected Letter(String trackingNumber, double weight) {
		super(trackingNumber, weight);
	}

	@Override
	protected WEIGHT_UNIT getWeightUnit() {
		return LETTER_WEIGHT_UNIT;
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
