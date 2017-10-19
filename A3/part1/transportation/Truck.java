// -------------------------------------------------------
// Assignment 3
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.transportation;

import java.util.Arrays;

import part1.packages.Package;
import part1.packages.PackageException;

/**
 * Truck class define the information about a truck, and can load and unload packages.
 * 
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class Truck {

	/**
	 * the maximum of packages a truck can carry
	 */
	public static final int MAX_PACKAGES = 200;
	private String driverName;
	private String originatingCity;
	private String destinationCity;
	private double grossIncome;
	private double unloadedWeight;
	private double loadedWeight;
	private int numberOfPackageLoaded;
	private Package[] ps;

	/**
	 * Parameterized Constructor
	 * 
	 * @param diverName
	 * @param unloadedWeight
	 * @param originatingCity
	 * @param destinationCity
	 */
	public Truck(String diverName, double unloadedWeight, String originatingCity, String destinationCity) {
		this.driverName = diverName;
		this.unloadedWeight = unloadedWeight;
		this.originatingCity = originatingCity;
		this.destinationCity = destinationCity;
		this.grossIncome = 0.0;
		this.loadedWeight = this.unloadedWeight;
		this.numberOfPackageLoaded = 0;
		this.ps = new Package[200];

	}

	/**
	 * Load a package to the truck
	 * 
	 * @param p
	 * @throws PackageException
	 */
	public void load(Package p) throws PackageException {
		// If the truck is full, throw an exception and then printout the information (package type, tracking number, weight) along with the fact that it was not loaded because the truck is full.
		if (this.numberOfPackageLoaded == MAX_PACKAGES) {
			throw new PackageException("Truck is full.");
		}
		// If the package is not one of the ones your truck is allowed to carry, throw an exception and print out the information (unknown package, tracking number, weight).
		try {
			Package.newPackage(p.getTrackingNumber(), p.getWeight());
		} catch (PackageException e) {
			throw e;
		}
		for (int i = 0; i < ps.length; i++) {
			if(p.equals(ps[i])){
				throw new PackageException("Package is already loaded.");
			}
			
		}
		// if the package is too heavy, throw an exception and print out that package's information (package type, tracking number, weight).
		if (p.isOverWeight()) {
			throw new PackageException("Package is over-weighted.");
		}

		// load package
		this.ps[this.numberOfPackageLoaded] = p;
		this.numberOfPackageLoaded++;
		this.loadedWeight += p.getWeight();
		this.grossIncome += p.getShippingCost();
	}

	/**
	 * Unload a package before the truck has departed.
	 * 
	 * @param trackingNumber
	 * @throws PackageException
	 */
	public void unloadBeforeTransportation(String trackingNumber) throws PackageException {
		Package packageToBeUnloaded = null;
		for (Package p : this.ps) {
			if (p != null && p.getTrackingNumber().equals(trackingNumber)) {
				packageToBeUnloaded = p;
			}
		}
		// When packages are unloaded the package information is printout, and deducted from the truck load.
		if (packageToBeUnloaded != null) {
			for (int i = 0; i < ps.length; i++) {
				if(packageToBeUnloaded.equals(ps[i])){
					ps[i] = null;
				}
			}
			this.numberOfPackageLoaded--;
			this.loadedWeight -= packageToBeUnloaded.getWeight();
			this.grossIncome -= packageToBeUnloaded.getShippingCost();
		} else {
			throw new PackageException("Package tracking number not found!");
		}

	}

	/**
	 * Unload a package after the truck has arrived the destination city.
	 * 
	 * @param p
	 */
	public void unloadAfterTransportation(Package p) {
		this.numberOfPackageLoaded--;
		this.loadedWeight -= p.getWeight();
	}

	/**
	 * Convert the weight to kg
	 * 
	 * @return
	 */
	public double toKilograms() {
		return this.loadedWeight / 2.2;
	}

	/**
	 * Convert the weight to pound
	 * 
	 * @return
	 */
	public double toPounds() {
		return this.loadedWeight;
	}

	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * @param driverName
	 *            the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * @return the originatingCity
	 */
	public String getOriginatingCity() {
		return originatingCity;
	}

	/**
	 * @param originatingCity
	 *            the originatingCity to set
	 */
	public void setOriginatingCity(String originatingCity) {
		this.originatingCity = originatingCity;
	}

	/**
	 * @return the desinationCity
	 */
	public String getDestinationCity() {
		return destinationCity;
	}

	/**
	 * @param destinationCity
	 *            the destinationCity to set
	 */
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	/**
	 * @return the unloadedWeight
	 */
	public double getUnloadedWeight() {
		return unloadedWeight;
	}

	/**
	 * @param unloadedWeight
	 *            the unloadedWeight to set
	 */
	public void setUnloadedWeight(double unloadedWeight) {
		this.unloadedWeight = unloadedWeight;
	}

	/**
	 * @return the grossIncome
	 */
	public double getGrossIncome() {
		return grossIncome;
	}

	/**
	 * @return the loadedWeight
	 */
	public double getLoadedWeight() {
		return loadedWeight;
	}

	/**
	 * @return the number of packages that have been loaded
	 */
	public int getNumberOfPackageLoaded() {
		return numberOfPackageLoaded;
	}

	/**
	 * @return the ps
	 */
	public Package[] getPs() {
		return ps;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		return (this.driverName == other.driverName && this.originatingCity == other.originatingCity && this.destinationCity == other.destinationCity && this.grossIncome == other.grossIncome
				&& this.loadedWeight == other.loadedWeight && this.unloadedWeight == other.unloadedWeight && this.numberOfPackageLoaded == other.numberOfPackageLoaded && Arrays.equals(ps, other.ps));
	}

	@Override
	public String toString() {
		return "Truck [driverName=" + driverName + ", originatingCity=" + originatingCity + ", desinationCity=" + destinationCity + ", grossIncome=" + grossIncome + ", unloadedWeight="
				+ unloadedWeight + ", loadedWeight=" + this.toKilograms() + "kg, " + this.toPounds() + "lb" + ", numberOfPackages=" + numberOfPackageLoaded + "]";
	}
}
