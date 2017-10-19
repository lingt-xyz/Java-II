// -------------------------------------------------------
// Assignment 3
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.packages;

/**
 * The abstract base class for a 'packages' hierarchy. Each package has a tracking number, weight and shipping cost, based on its weight.
 * 
 * @authors Ling Tan, Marzie Shafiee
 */
public abstract class Package {

	protected static enum WEIGHT_UNIT {
		Ounce, Pound
	};

	protected String trackingNumber;
	protected double weight;
	protected double shippingCost;

	/**
	 * Subclasses have to initialize trackingNumber and weight
	 * 
	 * @param trackingNumber
	 * @param weight
	 */
	protected Package(String trackingNumber, double weight) {
		this.trackingNumber = trackingNumber;
		this.weight = weight;
	}

	/**
	 * The weight unit of a package
	 * 
	 * @return
	 */
	protected abstract WEIGHT_UNIT getWeightUnit();

	/**
	 * The shipping cost per unit for a package
	 * 
	 * @return
	 */
	protected abstract double getCostPerUnit();

	/**
	 * The max weight a package can have.
	 * 
	 * @return
	 */
	protected abstract int getMaxWeight();

	/**
	 * Instantiate a Package
	 * 
	 * @param trackingNumber
	 * @param weight
	 * @return the object of a subclass of the Package
	 * @throws PackageException
	 *             If trackingNumber is invalid
	 */
	public static final Package newPackage(String trackingNumber, double weight) throws PackageException {
		char identity = trackingNumber.charAt(0);
		switch (identity) {
		case Letter.PACKAGE_TYPE_LETTER:
			return new Letter(trackingNumber, weight);
		case Box.PACKAGE_TYPE_BOX:
			return new Box(trackingNumber, weight);
		case WoodCrate.PACKAGE_TYPE_WOOD_CRATE:
			return new WoodCrate(trackingNumber, weight);
		case MetalCrate.PACKAGE_TYPE_METAL_CRATE:
			return new MetalCrate(trackingNumber, weight);
		default:
			throw new PackageException("Invalid package.");
		}
	}

	/**
	 * Convert the weight to ounce.
	 * 
	 * @return
	 */
	public final double toOunces() {
		if (this.getWeightUnit() == WEIGHT_UNIT.Ounce) {
			return this.weight;
		} else {
			return this.weight * 16;
		}
	}

	/**
	 * Convert the weight to pound.
	 * 
	 * @return
	 */
	public final double toPounds() {
		if (this.getWeightUnit() == WEIGHT_UNIT.Ounce) {
			return this.weight / 16;
		} else {
			return this.weight;
		}
	}

	/**
	 * Check whether a package is over-weighted.
	 * 
	 * @return
	 */
	public final boolean isOverWeight() {
		return this.weight > this.getMaxWeight();
	}

	/**
	 * @return the trackingNumber
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 * @param trackingNumber
	 *            the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	/**
	 * @return the weight in pound
	 */
	public double getWeight() {
		return this.toPounds();
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the shipping cost
	 */
	public final double getShippingCost() {
		return this.getCostPerUnit() * this.weight;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Package other = (Package) obj;
		return (this.trackingNumber.equals(other.trackingNumber));
	}

	@Override
	public String toString() {
		return this.getPackageInfo();
	}

	/**
	 * Format the information of a package
	 * 
	 * @return
	 */
	private String getPackageInfo() {
		return "Package type: " + this.getClass().getSimpleName() + "; tracking number: " + this.trackingNumber + "; weight : " + this.weight + " " + this.getWeightUnit() + ".";
	}

}
