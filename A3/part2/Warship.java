// -------------------------------------------------------
// Assignment 3
// Part: II
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2;

/**
 * Warship Class
 * 
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class Warship {
	/**
	 * a serial number can either appears once in the file, which is the correct case, or appears multiple times, in which case the second, and following, appearances are in error. You must notice
	 * that the file Initial_Warship_Info.txt changes
	 */
	private long serialNumber;
	private String name;
	private int creationyear;
	private String ownercountry;
	private double price;
	private int speed;

	/**
	 * Full parameterized constructor
	 * 
	 * @param serialNumber
	 * @param name
	 * @param creationyear
	 * @param ownercountry
	 * @param price
	 * @param speed
	 */
	public Warship(long serialNumber, String name, int creationyear, String ownercountry, double price, int speed) {
		super();
		this.serialNumber = serialNumber;
		this.name = name;
		this.creationyear = creationyear;
		this.ownercountry = ownercountry;
		this.price = price;
		this.speed = speed;
	}

	/**
	 * @return the serialNumber
	 */
	public long getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the creationyear
	 */
	public int getCreationyear() {
		return creationyear;
	}

	/**
	 * @param creationyear
	 *            the creationyear to set
	 */
	public void setCreationyear(int creationyear) {
		this.creationyear = creationyear;
	}

	/**
	 * @return the ownercountry
	 */
	public String getOwnercountry() {
		return ownercountry;
	}

	/**
	 * @param ownercountry
	 *            the ownercountry to set
	 */
	public void setOwnercountry(String ownercountry) {
		this.ownercountry = ownercountry;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warship other = (Warship) obj;
		if (creationyear != other.creationyear)
			return false;
		return (this.name.equals(other.name) && this.ownercountry.equals(other.ownercountry) && this.price == other.price && this.serialNumber == other.serialNumber && this.speed == other.speed);
	}

	@Override
	public String toString() {
		// 900876512 Destroyer 2007 United_States_of_America 826928.35 620
		return this.serialNumber + " " + this.name + " " + this.creationyear + " " + this.ownercountry + " " + this.price + " " + this.speed;
	}
}
