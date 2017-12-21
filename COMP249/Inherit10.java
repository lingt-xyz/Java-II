// *******************************************************************
// Inherit10.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates the subject of inheritance and 
// access rights. Notice that this program does NOT work. Why?
// There are 10 errors in this program. Can you locate them? 
// Key Points: 
// 	1) Access rights
// *******************************************************************

// Vehicle Class
class Vehicle {

	// Attributes
	private int numOfDoors;
	private double price;
	 
	// Constructors
	public Vehicle()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle(Vehicle vec)	// copy constructor 
	{
		System.out.println("Creating a vehicle object using copy constructor ....");
		
		numOfDoors = vec.numOfDoors;
		price = vec.price;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public void setNumOfDoors(int nd)
	{
		numOfDoors = nd;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double pr)
	{
		price = pr;
	}
	
	public String toString()
	{
		return "This Vehicle has " + numOfDoors + 
		"doors and it price is " + price + "$.";
	}
} // end of Vehicle class




// Bus Class - This is a derived class from the Vehicle Class; that is it 
// inherits the Vehicle class 
class Bus extends Vehicle{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		numOfDoors = 2;
		super.price = 32000;
		passengerCapacity = 10;
	}
	
	public Bus(int pc, int nd, double pr)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		numOfDoors = nd;
		super.price = pr;
		passengerCapacity = pc;
	}
	
	public Bus(Bus b)	
	{
		System.out.println("Creating a bus object using copy constructor ....\n");
		numOfDoors = b.numOfDoors;
		super.price = b.price;
		passengerCapacity = b.passengerCapacity;
	}
	
	public int getPassangerCapacity()
	{
		return passengerCapacity;
	}
	
	public void setPassengerCapacity(int pc)
	{
		passengerCapacity = pc;
	}
	
	public String toString()
	{
		return "This Bus has " + numOfDoors + " doors and its price is: " + price +
		"$. The passenger capacity of this bus is " + passengerCapacity + "."; 
	}
	
}   // end of Bus class
	


public class Inherit10 {

	
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus b1 = new Bus(), b2 = new Bus(55, 3, 65000), b3 = new Bus(b1);
		
		System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
		System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
		System.out.println("Here is the information of the third bus:\n" + b3 + "\n");

	}

}

/* Compilation results 
Description	Resource	Path	Location	Type
The field Vehicle.numOfDoors is not visible	Inherit10.java	/Inherit10/src	line 84	Java Problem
The field Vehicle.numOfDoors is not visible	Inherit10.java	/Inherit10/src	line 92	Java Problem
The field Vehicle.numOfDoors is not visible	Inherit10.java	/Inherit10/src	line 100	Java Problem
The field Vehicle.numOfDoors is not visible	Inherit10.java	/Inherit10/src	line 100	Java Problem
The field Vehicle.numOfDoors is not visible	Inherit10.java	/Inherit10/src	line 117	Java Problem
The field Vehicle.price is not visible	Inherit10.java	/Inherit10/src	line 85	Java Problem
The field Vehicle.price is not visible	Inherit10.java	/Inherit10/src	line 93	Java Problem
The field Vehicle.price is not visible	Inherit10.java	/Inherit10/src	line 101	Java Problem
The field Vehicle.price is not visible	Inherit10.java	/Inherit10/src	line 101	Java Problem
The field Vehicle.price is not visible	Inherit10.java	/Inherit10/src	line 117	Java Problem

*/
	