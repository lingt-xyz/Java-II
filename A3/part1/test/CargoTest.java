// -------------------------------------------------------
// Assignment 3
// Part: I
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part1.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import part1.packages.Package;
import part1.packages.PackageException;
import part1.transportation.Truck;

/**
 * Main class
 * 
 * @authors Ling Tan, Marzie Shafiee
 *
 */
public class CargoTest {

	private Scanner keyboard = null;
	private Truck truck = null;

	public static void main(String[] args) {
		CargoTest cargo = new CargoTest();
		cargo.startCargo();

		// Test case for overload truck
		try {
			cargo.testLoadOverMaxPackage();
		} catch (PackageException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Process a new cargo
	 */
	private void startCargo() {
		// ------------------------------------------------------------------
		// What would you like to do?
		// 1. Start a cargo
		// a. Driver name
		// b. Unload weight(kg; lb)
		// c. Originating city d. Destination city
		// 2. Load the truck with packages
		// a. Package tracking number
		// b. Package weight(oz; lb)
		// c. Package shipping cost
		// 3. Unload a package
		// 4. The number of packages loaded
		// 5. The gross income earned by shipping of the cargo
		// 6. Weight the truck(after it has been completely loaded)
		// 7. Drive the truck to destination
		// 0. To quit
		// ------------------------------------------------------------------
		keyboard = new Scanner(System.in);
		boolean loop = true;
		int nextStep;
		do {
			this.showMainMenu();
			try {
				nextStep = keyboard.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("------>Invalid input.<------");
				continue;
			} finally {
				keyboard.nextLine();
			}
			switch (nextStep) {
			case 1:
				this.configTruck();
				break;
			case 2:
				this.loadPackage();
				break;
			case 3:
				this.unloadPackage();
				break;
			case 4:
				this.showNumberofPackageLoaded();
				break;
			case 5:
				this.showGrossIncome();
				break;
			case 6:
				this.showWeightOfTruck();
				break;
			case 7:
				this.driverTruck();
				break;
			case 0:
				loop = false;
				System.out.println("--------------------------The program has terminated.--------------------------");
				break;
			default:
				System.out.println("----->Invalid input. Please re-enter your choice:<-----\n");
				break;
			}
		} while (loop);

		keyboard.close();
	}

	private void showMainMenu() {
		System.out.println("\n--------------------------Welcome to Post Canada--------------------------");
		System.out.println("What would you like to do? ");
		System.out.printf("%2s", " ");
		System.out.println("1. Start a cargo ");
		System.out.printf("%6s", " ");
		System.out.println("a. Driver name: " + (this.truck == null ? "" : this.truck.getDriverName()));
		System.out.printf("%6s", " ");
		System.out.println("b. Unload weight(lb): " + (this.truck == null ? "" : (this.truck.getUnloadedWeight() + " lb")));
		System.out.printf("%6s", " ");
		System.out.println("c. Originating city: " + (this.truck == null ? "" : this.truck.getOriginatingCity()));
		System.out.printf("%6s", " ");
		System.out.println("d. Destination city: " + (this.truck == null ? "" : this.truck.getDestinationCity()));
		System.out.printf("%2s", " ");
		System.out.println("2. Load the truck with packages ");
		System.out.printf("%6s", " ");
		System.out.println("a. Package tracking number ");
		System.out.printf("%6s", " ");
		System.out.println("b. Package weight(oz; lb) ");
		System.out.printf("%6s", " ");
		System.out.println("c. Package shipping cost");
		System.out.printf("%2s", " ");
		System.out.println("3. Unload a package ");
		System.out.printf("%2s", " ");
		System.out.println("4. The number of packages loaded ");
		System.out.printf("%2s", " ");
		System.out.println("5. The gross income earned by shipping of the cargo ");
		System.out.printf("%2s", " ");
		System.out.println("6. Weight the truck(after it has been completely loaded) ");
		System.out.printf("%2s", " ");
		System.out.println("7. Drive the truck to destination");
		System.out.printf("%2s", " ");
		System.out.println("0. To quit");
		System.out.println("Please enter your choice (0-7) and press <Enter>:");
	}

	/**
	 * set up the truck
	 */
	private void configTruck() {
		System.out.println("Please input the driver name:");
		String driverName = keyboard.nextLine();
		double weight = validDoubleInput("Please input unload weight of the truck (in lb):", 1);
		System.out.println("Please input the originating city:");
		String originatingCity = keyboard.nextLine();
		System.out.println("Please input the destination city:");
		String destinationCity = keyboard.nextLine();
		truck = new Truck(driverName, weight, originatingCity, destinationCity);
		System.out.println("------>The truck has been set up, and is ready to load packages.<------\n");
	}

	/**
	 * load a package to the truck
	 */
	private void loadPackage() {
		if (this.truck == null) {
			System.out.println("------>Please set up the truck first.<------");
			return;
		}
		System.out.println("Please input the tracking number:");
		String trackingNumber = keyboard.nextLine();
		double weight = validDoubleInput("Please input the package weight:", 1);
		Package p = null;
		try {
			p = Package.newPackage(trackingNumber, weight);
		} catch (PackageException e) {
			System.out.println("------>Unknown package (tracking number:" + trackingNumber + ", weight:" + weight + ") would not be loaded because: " + e.getMessage() + ".<------\n");
		}
		if (p != null) {
			try {
				this.truck.load(p);
				System.out.println("------>Package " + trackingNumber + " has been loaded.<------\n");
			} catch (PackageException e) {
				System.out.println("------>The package (" + p + ") would not be loaded because: " + e.getMessage() + ".<------\n");
			}
		}
	}

	/**
	 * unload a package according the trackingNumber user has input.
	 */
	private void unloadPackage() {
		if (this.truck != null && this.truck.getNumberOfPackageLoaded() == 0) {
			System.out.println("------>No package has been loaded. The truck is empty.<------");
			return;
		}
		System.out.println("Please input the tracking number of the package to be unloaded:");
		String trackingNumber = keyboard.nextLine();
		try {
			this.truck.unloadBeforeTransportation(trackingNumber);
			System.out.println("------>Package " + trackingNumber + " has been unloaded.<------\n");
		} catch (PackageException e) {
			System.out.println("------>The package would not be unloaded because: " + e.getMessage() + ".<------\n");
		}
	}

	/**
	 * show how many packages have been loaded
	 */
	private void showNumberofPackageLoaded() {
		if (this.truck == null || this.truck.getNumberOfPackageLoaded() == 0) {
			System.out.println("------>No package has been loaded. The truck is empty.<------");
			return;
		}
		System.out.println("------>The number of packages have been loaded is " + this.truck.getNumberOfPackageLoaded() + ".<------\n");
	}

	/**
	 * show gross income
	 */
	private void showGrossIncome() {
		if (this.truck == null || this.truck.getNumberOfPackageLoaded() == 0) {
			System.out.println("------>No package has been loaded. The truck is empty.<------");
			return;
		}
		System.out.println("------>The gross income earned by shipping of the cargo is " + this.formartCurrency(this.truck.getGrossIncome()) + ".<------\n");
	}

	/**
	 * show the current weight of the truck
	 */
	private void showWeightOfTruck() {
		if (this.truck == null) {
			System.out.println("------>The truck has not yet been set up.<------");
			return;
		}
		System.out.println("------>The current weight of the truck is " + formartDecimal(this.truck.toPounds()) + "(lb), " + formartDecimal(this.truck.toKilograms()) + "(kg).<------\n");
	}

	/**
	 * depart the truck
	 */
	private void driverTruck() {
		if (this.truck != null && this.truck.getNumberOfPackageLoaded() == 0) {
			System.out.println("------>No package loaded. The truck is empty and would not been sent.<------\n");
		} else {
			System.out.println("------>The truck is departing from " + this.truck.getOriginatingCity() + " with " + this.truck.getNumberOfPackageLoaded() + " package(s).");
			try {
				for (int i = 0; i < 7; i++) {
					Thread.sleep(500);
					System.out.print("------>in transit------>");
				}
			} catch (InterruptedException e) {
				// ignore the error
			}
			System.out.println();
			System.out.println("------>The truck has arrived at " + this.truck.getDestinationCity() + ".");
			System.out.println("------>Unload the truck:");
			for (Package p : this.truck.getPs()) {
				if (p != null) {
					this.truck.unloadAfterTransportation(p);
					System.out.println("------------>Unload the package: " + p + this.truck.getNumberOfPackageLoaded() + " package(s) reamin in the truck.");
				}
			}
		}
	}

	/**
	 * Check whether the input is a double. The program would terminate after 10 times failure input.
	 * 
	 * @param info
	 * @param counter
	 * @return
	 */
	private double validDoubleInput(String info, int counter) {
		if (counter < 0) {
			counter = 1;
		}
		if (counter >= 10) {
			System.out.println("------>Too many times invalid input. The program would terminate.<------");
			System.exit(1);
		}
		try {
			System.out.println(info);
			double result = this.keyboard.nextDouble();
			keyboard.nextLine();
			return result;
		} catch (InputMismatchException e) {
			keyboard.nextLine();
			counter++;
			System.out.println("------>Invalid input.<------");
			return this.validDoubleInput(info, counter);
		}
	}

	private String formartCurrency(double d) {
		return NumberFormat.getCurrencyInstance(Locale.CANADA).format(d);
	}

	private String formartDecimal(double d) {
		return new DecimalFormat("#0.00").format(d);
	}

	/**
	 * Test case for overload truck
	 * 
	 * @throws PackageException
	 */
	private void testLoadOverMaxPackage() throws PackageException {
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("-----------------This is the test case for that try to load more than the allowed 200 packages.-----------------");
		Random r = new Random();
		Truck truck = new Truck("Tim", 40000, "Montreal", "Ottawa");
		for (int i = 0; i <= Truck.MAX_PACKAGES; i++) {
			int t = r.nextInt(4);
			int l = r.nextInt(1000000);
			int w = r.nextInt(32);
			Package p = Package.newPackage(t + "" + l, w);
			truck.load(p);
			System.out.println("----->Load package " + (i + 1) + ": " + p);
		}
		System.out.println("------------------------------------------End of the test case.-------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
	}
}
