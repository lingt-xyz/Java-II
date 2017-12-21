// *******************************************************************
// Inherit7.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates more of default constructors. The program is similar
// to inherit6.java with the exception that the base class has some defined 
// constructors. Would that program compile/run? Why?
// Since the base class has defined some constructors, the language will NOT
// create any default constructors for that class. This is not the case as when 
// the class has no defined constructors at all (see Inherit6.java).
// 
// Key Points: 
// 	1) Default constructors 
// *******************************************************************

// Vehicle Class
class Vehicle {

	// Attributes
	private int numOfDoors;
	private double price;
	
	// Constructors
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
		
		passengerCapacity = 10;
	}
	
	public Bus(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus(Bus b)	
	{
		System.out.println("Creating a bus object using copy constructor ....\n");
		
		passengerCapacity = b.passengerCapacity;
	}
	
	public int getPassangerCapacity()
	{
		return passengerCapacity;
	}
	
	public void setPassengerCapacity(int pc)
	{
		passengerCapacity = pc;;
	}
	
	public String toString()
	{
		return "This Bus has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The passenger capacity of this bus is " + passengerCapacity + "."; 
	}
	

}   // end of Bus class
	


public class Inherit7 {

	
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle v1 = new Vehicle(4, 12000), v2 = new Vehicle(v1);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus b1 = new Bus(), b2 = new Bus(55), b3 = new Bus(b1);
		
		System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
		System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
		System.out.println("Here is the information of the third bus:\n" + b3 + "\n");

	}

}

/* Compilation results 
Errors (3 items)

x- Description	Resource	Path	Location	Type
Implicit super constructor Vehicle() is undefined. Must explicitly invoke another constructor	Inherit7.java	/Inherit7/src	line 75	Java Problem

x- Description	Resource	Path	Location	Type
Implicit super constructor Vehicle() is undefined. Must explicitly invoke another constructor	Inherit7.java	/Inherit7/src	line 82	Java Problem

x- Description	Resource	Path	Location	Type
Implicit super constructor Vehicle() is undefined. Must explicitly invoke another constructor	Inherit7.java	/Inherit7/src	line 89	Java Problem
*/
	