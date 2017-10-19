// -------------------------------------------------------
// Assignment 3
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.packages;

/**
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public abstract class Crate extends Package {
	protected static final WEIGHT_UNIT CRATE_WEIGHT_UNIT = WEIGHT_UNIT.Pound;

	protected Crate(String trackingNumber, double weight) {
		super(trackingNumber, weight);
	}

	@Override
	protected final WEIGHT_UNIT getWeightUnit() {
		return CRATE_WEIGHT_UNIT;
	}
}
