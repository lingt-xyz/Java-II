// *******************************************************************
// Polymorphism5.java By: Aiman Hanna (C) 1993 - 2017
// This program introduces the "clone" function. The program fixes the 
// problems that Polymorphism4.java has as a result of the limitations 
// of the copy constructors. 
//
// Although the clone() methods (see below) are in fact using the copy 
// constructors, this will work because the clone() method has the same 
// name in all classes, and polymorphism works with method names. In 
// contrast, the names of the copy constructors are (naturally) different
// and polymorphism does not work with methods of different names.
//
// Key Points:
// 1) The "clone" method.
// *******************************************************************

// Vehicle Class
class Vehicle {

	// Attributes
	protected int numOfDoors;
	protected double price;
	private long serialNum;
	private static long serialNumCtr = 1000;
	
	
	// Constructors
	public Vehicle()	// default constructor 
	{
		System.out.println("\nCreating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
		serialNum = serialNumCtr++;
	}
	
	public Vehicle(int nd, double pr)	
	{
		System.out.println("\nCreating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
		serialNum = serialNumCtr++;
	}
	
	
	public Vehicle(Vehicle vec)	// copy constructor 
	{
		System.out.println("\nCreating a vehicle object using copy constructor ....");
		
		numOfDoors = vec.numOfDoors;
		price = vec.price;
		serialNum = serialNumCtr++;		// Never duplicate a serial number
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
		" doors and its price is " + price + "$.";
	}
	
	// Find out if that vehicle has a cheaper price than the passed vehicle 
	public boolean isCheaper(Vehicle v)
	{
		// Obtain the class names just for display purposes
		String s1 = this.getClass().toString(), s2 = v.getClass().toString();
		s1 = s1.substring(6); // Remove the word "class" to get only the class name
		s2 = s2.substring(6);

		
		if(getPrice() < v.getPrice())
		{
			
			System.out.println("The price of this " + s1 + 
								" object is cheaper than the price of the passed " +
								s2 + " object.");
			return true;
		}
		else
		{
			System.out.println("The price of this " + s1 + 
					" object is NOT cheaper than the price of the passed " +
					s2 + " object.");
			return false;
		}
	}
	
	public long getSerNumber()
	{
		return serialNum;
	}
	
	
	public Vehicle clone()
	{
		return new Vehicle(this);	// Create and return a new Vehicle using the copy constructor
	}
} // end of Vehicle class




// Bus Class - This is a derived class from the Vehicle Class; that is it 
// inherits the Vehicle class 
class Bus extends Vehicle{

	// Attributes
	private int passengerCapacity;
	private long serialNum;
	private static long serialNumCtr = 2000;
	
	// Constructors
	public Bus()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....");
		
		passengerCapacity = 10; 
		serialNum = serialNumCtr++;
	}
	
	public Bus(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....");
		
		passengerCapacity = pc;
		serialNum = serialNumCtr++;
	}
	
	public Bus(Bus b)	
	{
		System.out.println("Creating a bus object using copy constructor ....");
		
		setNumOfDoors(b.getNumOfDoors());
		setPrice(b.getPrice());
		passengerCapacity = b.passengerCapacity;
		serialNum = serialNumCtr++;
	}
	
	
	// A constructor that would allow the setting of the price and the number of doors
	// and the passenger capacity
	public Bus(int nd, double pr, int pc)	
	{
		
		this(pc); 	// Call the constructor that sets the passenger capacity 
	
		System.out.println("Creating a bus object using parameterized constructor for full settings....\n");
		
		// Notice that we now cannot call super to set the other two attributes 
		// (i.e. super(nd, pr);) since either "this" or 'super" must be the first 
		// statement, and it is not possible to have both of them as such!
		setPrice(pr);		
		setNumOfDoors(nd); 
		// serialNum is assigned in the call to the "this" constructor
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
	
	// Override the setPrice() method
	public void setPrice(double pr)
	{
		if(pr < getPrice())
			System.out.println("The price of this bus will be reduced from " + getPrice() + "$ to " + pr + "$.");
		else if (pr > getPrice())
			System.out.println("The price of this bus will be increased from " + getPrice() + "$ to " + pr + "$.");
		else
			System.out.println("No change will be applied to this price of the bus.");
		
		super.setPrice(pr);		
		// Notice that you cannot access "price" directly  since it is private to the base class
		// i.e. price = pr; would be illegal
		
	}
	
	public double getPrice()
	{
		return price;
	}

	public long getSerNumber()
	{
		return serialNum;
	}
	
	public Bus clone()
	{
		return new Bus(this);	// Create and return a new Bus using the copy constructor
	}
}   // end of Bus class
	


//Car Class - This is a derived class from the Vehicle Class.
//For a Car object, we are interested in its number of seats
class Car extends Vehicle{

	// Attributes
	private int numOfSeats;
	private long serialNum;
	private static long serialNumCtr = 3000;
	
	// Constructors
	public Car()	// default constructor 
	{
		System.out.println("Creating a car object using default constructor ....");
		
		numOfSeats = 5;
		serialNum = serialNumCtr++;
	}
	
	public Car(int nd, double pr, int ns)	
	{
		super(nd, pr);
		System.out.println("Creating a car object using parameterized constructor ....");
		
		numOfSeats = ns;
		serialNum = serialNumCtr++;
	}
	
	public Car(Car c)	
	{
		System.out.println("Creating a car object using copy constructor ....");
		setNumOfDoors(c.getNumOfDoors());
		setPrice(c.getPrice());
		numOfSeats = c.numOfSeats;
		serialNum = serialNumCtr++;
	}
	
	
	public int getNumOfSeats()
	{
		return numOfSeats;
	}
	
	public void setNumOfSeats(int ns)
	{
		numOfSeats = ns;;
	}
	
	public String toString()
	{
		return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this car is " + numOfSeats + "."; 
	}
			
	public double getPrice()
	{
		return price;
	}

	public long getSerNumber()
	{
		return serialNum;
	}
	
	public Car clone()
	{
		return new Car(this);	// Create and return a new Car using the copy constructor
	}
}   // end of Car class



//SportCar Class - This is a derived class from the Car Class
//For a SportCar object, we are interested in its gas consumption 
// as gallon per 100 miles
class SportCar extends Car{

	// Attributes
	private double gasConsumption;
	private long serialNum;
	private static long serialNumCtr = 4000;
	
	// Constructors
	public SportCar()	// default constructor 
	{
		System.out.println("Creating a sport car object using default constructor ....");
		
		gasConsumption = 4;
		serialNum = serialNumCtr++;
	}
	
	public SportCar(int nd, double pr, int ns, double gc)	
	{
		super(nd, pr, ns);
		System.out.println("Creating a sport car object using parameterized constructor ....");
		gasConsumption = gc;
		serialNum = serialNumCtr++;
	}
	
	public SportCar(SportCar sc)	
	{
		System.out.println("Creating a sport car object using copy constructor ....");
		
		setNumOfDoors(sc.getNumOfDoors());
		setPrice(sc.getPrice());
		setNumOfSeats(sc.getNumOfSeats());
		
		gasConsumption = sc.gasConsumption;
		serialNum = serialNumCtr++;
	}
	
	
	public double getGasConsumption()
	{
		return gasConsumption;
	}
	
	public void setGasConsumption(double gc)
	{
		gasConsumption = gc;;
	}
	
	public String toString()
	{
		return "This Sport Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this Sport Car is " + getNumOfSeats() + 
		"\nand its gas consumption is " + gasConsumption + " gallons/100-mile."; 
	}
		
	public double getPrice()
	{
		return price;
	}
	
	public long getSerNumber()
	{
		return serialNum;
	}
	
	public SportCar clone()
	{
		return new SportCar(this);	// Create and return a new SportCar using the copy constructor
	}
}   // end of Sport Car class



//RaceCar Class - This is a derived class from the SportCar Class
//For a RaceCar object, we are interested in its horse power
class RaceCar extends SportCar{

	// Attributes
	private int horsePower;
	private long serialNum;
	private static long serialNumCtr = 5000;
	
	// Constructors
	public RaceCar()	// default constructor 
	{
		System.out.println("Creating a race car object using default constructor ....");
		
		horsePower = 400;
		serialNum = serialNumCtr++;
	}
	
	public RaceCar(int nd, double pr, int ns, double gc, int hp)	
	{
		super(nd, pr, ns, gc);
		System.out.println("Creating a race car object using parameterized constructor ....");
		horsePower = hp;
		serialNum = serialNumCtr++;
	}
	
	public RaceCar(RaceCar rc)	
	{
		System.out.println("Creating a race car object using copy constructor ....");
		
		setNumOfDoors(rc.getNumOfDoors());
		setPrice(rc.getPrice());
		setNumOfSeats(rc.getNumOfSeats());
		setGasConsumption(rc.getGasConsumption());
		
		horsePower = rc.horsePower;
		serialNum = serialNumCtr++;
	}
	
	
	public int getHorsePower()
	{
		return horsePower;
	}
	
	public void setHorsePower(int hp)
	{
		horsePower = hp;
	}
	
	public String toString()
	{
		return "This Race Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this Race Car is " + getNumOfSeats() + 
		"\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
		"The horse power of this Race Car is: " + horsePower + "."; 
	}
		
	public double getPrice()
	{
		return price;
	}
	
	public long getSerNumber()
	{
		return serialNum;
	}
	
	public RaceCar clone()
	{
		return new RaceCar(this);	// Create and return a new RaceCar using the copy constructor
	}

}   // end of Race Car class

public class Polymorphism5{

	// A method that would accept any vehicle object and displays its information 
	public static void showVehicleInfo(Vehicle v)
	{
		System.out.println("Here is the information of this vehicle");
		System.out.println(v);
		System.out.println();
	}
	
	// A method that takes an array of Vehicles inventory and return a copy of that array
	public static Vehicle[] copyInventory_1(Vehicle[] va)
	{
		// This is rather a terrible method to copy the array; actually there is no copying at all
		Vehicle[] vecarr = va;
		return vecarr;
	}
	
	
	// A method that takes an array of Vehicles inventory and return a copy of that array
	public static Vehicle[] copyInventory_2(Vehicle[] va)
	{
		// This is better than copyInventory_1() above; yet it is also bad
		Vehicle[] vecarr = new Vehicle[va.length];	// create a new array with the same length
													// as the passed array;
		for (int i = 0; i < vecarr.length; i++)	// then copy it
		{
			vecarr[i] = new Vehicle(va[i]);		// Is that Okay? Why? Why NOT?
		} 
		return vecarr;
	}
	
	
	// A method that takes an array of Vehicles inventory and return a copy of that array
	public static Vehicle[] copyInventory_3(Vehicle[] va)
	{
		// This is the correct version of this method, which uses the clone() method instead of 
		// the copy constructors
		Vehicle[] vecarr = new Vehicle[va.length];	// create a new array with the same length
													// as the passed array;
		for (int i = 0; i < vecarr.length; i++)	// then copy it
		{
			vecarr[i] = va[i].clone();		
		} 
		return vecarr;
	}
	
	// A method that displays the contents of an inventory
	public static void displayInventoryInfo(Vehicle[] va)
	{
		String s;
		System.out.println("\nHere is the information of vehicles in that inventory");
		for (int i = 0; i < va.length; i++)
		{
			// Obtain the class name just for display purposes
			s = va[i].getClass().toString();
			s = s.substring(6); // Remove the word "class" to get only the class name
			System.out.print((i+1) + ". " + s + " with serial number " + va[i].getSerNumber() + ". ");
			System.out.println(va[i]);

		}
	}
	public static void main(String[] args) {
		System.out.println("Will create three Vehicle objects");

		Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000), v3 = new Vehicle(v2);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus b1 = new Bus(2, 55000, 37), b2 = new Bus(3, 62000, 55), b3 = new Bus(b1);
		
		
		System.out.println();
		System.out.println("Will create two Car objects");

		Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 26000, 2);
		
		System.out.println();
		System.out.println("Will create three Sport Car objects");

		SportCar sc1 = new SportCar(4, 12000, 5, 3), sc2 = new SportCar(3, 18500, 4, 4),
		         sc3 = new SportCar(2, 15000, 5, 4);
	
		
		System.out.println();
		System.out.println("Will create two Race Car objects");

		RaceCar rc1 = new RaceCar(4, 67000, 2, 4, 400), rc2 = new RaceCar(3, 85000, 4, 4, 450);
	
		
		
		System.out.println("\nWill create some inventories");
		System.out.println("============================\n");
		
		Vehicle[] vecInv1 = new Vehicle[6];
		vecInv1[0] = v1;
		vecInv1[1] = b1;
		vecInv1[2] = b2;
		vecInv1[3] = sc1;
		vecInv1[4] = sc2;
		vecInv1[5] = rc1;
				
		System.out.print("\nInventory vecInv1: ");
		displayInventoryInfo(vecInv1);
		
		Vehicle[] vecInv2 = new Vehicle[4];
		vecInv2[0] = v2;
		vecInv2[1] = sc3;
		vecInv2[2] = rc2;
		vecInv2[3] = b3;
		
		System.out.print("\nInventory vecInv2: ");
		displayInventoryInfo(vecInv2);
		
		// Now copy these inventories using the correct copyInventory method
		Vehicle[] vecInv3 = copyInventory_3(vecInv1);
		Vehicle[] vecInv4 = copyInventory_3(vecInv2);
		
		System.out.print("\nInventory vecInv3 (should be a COPY of vecInv1): ");
		displayInventoryInfo(vecInv3);
		
		System.out.print("\nInventory vecInv4 (should be a COPY of vecInv2): ");
		displayInventoryInfo(vecInv4);
	}

}

/* The Output 
Will create three Vehicle objects

Creating a vehicle object using default constructor ....

Creating a vehicle object using parameterized constructor ....

Creating a vehicle object using copy constructor ....

Will create three Bus objects

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

The price of this bus will be increased from 10000.0$ to 55000.0$.

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

The price of this bus will be increased from 10000.0$ to 62000.0$.

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....
The price of this bus will be increased from 10000.0$ to 55000.0$.

Will create two Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Will create three Sport Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Will create two Race Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Will create some inventories
============================


Inventory vecInv1: 
Here is the information of vehicles in that inventory
1. Vehicle with serial number 1000. This Vehicle has 4 doors and its price is 10000.0$.
2. Bus with serial number 2000. This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.
3. Bus with serial number 2001. This Bus has 3 doors and its price is: 62000.0$. The passenger capacity of this bus is 55.
4. SportCar with serial number 4000. This Sport Car has 4 doors and its price is: 12000.0$. The number of seats of this Sport Car is 5
and its gas consumption is 3.0 gallons/100-mile.
5. SportCar with serial number 4001. This Sport Car has 3 doors and its price is: 18500.0$. The number of seats of this Sport Car is 4
and its gas consumption is 4.0 gallons/100-mile.
6. RaceCar with serial number 5000. This Race Car has 4 doors and its price is: 67000.0$. The number of seats of this Race Car is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car is: 400.

Inventory vecInv2: 
Here is the information of vehicles in that inventory
1. Vehicle with serial number 1001. This Vehicle has 4 doors and its price is 5000.0$.
2. SportCar with serial number 4002. This Sport Car has 2 doors and its price is: 15000.0$. The number of seats of this Sport Car is 5
and its gas consumption is 4.0 gallons/100-mile.
3. RaceCar with serial number 5001. This Race Car has 3 doors and its price is: 85000.0$. The number of seats of this Race Car is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car is: 450.
4. Bus with serial number 2002. This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.

Creating a vehicle object using copy constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....
The price of this bus will be increased from 10000.0$ to 55000.0$.

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....
The price of this bus will be increased from 10000.0$ to 62000.0$.

Creating a vehicle object using default constructor ....
Creating a car object using default constructor ....
Creating a sport car object using copy constructor ....

Creating a vehicle object using default constructor ....
Creating a car object using default constructor ....
Creating a sport car object using copy constructor ....

Creating a vehicle object using default constructor ....
Creating a car object using default constructor ....
Creating a sport car object using default constructor ....
Creating a race car object using copy constructor ....

Creating a vehicle object using copy constructor ....

Creating a vehicle object using default constructor ....
Creating a car object using default constructor ....
Creating a sport car object using copy constructor ....

Creating a vehicle object using default constructor ....
Creating a car object using default constructor ....
Creating a sport car object using default constructor ....
Creating a race car object using copy constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....
The price of this bus will be increased from 10000.0$ to 55000.0$.

Inventory vecInv3 (should be a COPY of vecInv1): 
Here is the information of vehicles in that inventory
1. Vehicle with serial number 1013. This Vehicle has 4 doors and its price is 10000.0$.
2. Bus with serial number 2003. This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.
3. Bus with serial number 2004. This Bus has 3 doors and its price is: 62000.0$. The passenger capacity of this bus is 55.
4. SportCar with serial number 4005. This Sport Car has 4 doors and its price is: 12000.0$. The number of seats of this Sport Car is 5
and its gas consumption is 3.0 gallons/100-mile.
5. SportCar with serial number 4006. This Sport Car has 3 doors and its price is: 18500.0$. The number of seats of this Sport Car is 4
and its gas consumption is 4.0 gallons/100-mile.
6. RaceCar with serial number 5002. This Race Car has 4 doors and its price is: 67000.0$. The number of seats of this Race Car is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car is: 400.

Inventory vecInv4 (should be a COPY of vecInv2): 
Here is the information of vehicles in that inventory
1. Vehicle with serial number 1019. This Vehicle has 4 doors and its price is 5000.0$.
2. SportCar with serial number 4008. This Sport Car has 2 doors and its price is: 15000.0$. The number of seats of this Sport Car is 5
and its gas consumption is 4.0 gallons/100-mile.
3. RaceCar with serial number 5003. This Race Car has 3 doors and its price is: 85000.0$. The number of seats of this Race Car is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car is: 450.
4. Bus with serial number 2005. This Bus has 2 doors and its price is: 55000.0$. The passenger capacity of this bus is 37.

*/
	
