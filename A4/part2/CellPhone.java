// -------------------------------------------------------
// Assignment 4
// Part: II
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CellPhone object contains its serial number, brand, year being made, and its price
 *
 * @author Ling Tan
 * @author Marzie Shafiee
 */
public class CellPhone implements Cloneable {

    private static Scanner keyboard = new Scanner(System.in);

    private long serialNumber;
    private String brand;
    private int year;
    private double price;

    public CellPhone(long serialNumber, String brand, int year, double price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.year = year;
        this.price = price;
        SerialNumberUtil.storeSerialNumber(serialNumber);
    }

    public CellPhone(CellPhone c, long serialNumber) {
        this(serialNumber, c.getBrand(), c.getYear(), c.getPrice());
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
        SerialNumberUtil.storeSerialNumber(serialNumber);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public CellPhone clone() {
        /*long serialNumber;
        while (true) {
            System.out.print("Please input a new serial number of the cellphone you are going to clone:");
            try {
                serialNumber = keyboard.nextLong();
                if (!SerialNumberUtil.isUnique(serialNumber)) {
                    break;
                }else{
                    keyboard.nextLine();
                    System.out.println("Duplicate serial number!");
                }
            } catch (InputMismatchException e) {
                keyboard.nextLine();
                System.out.println("----->Invalid input!<-----");
            }
        }
        return new CellPhone(this, serialNumber);*/

        return new CellPhone(this, SerialNumberUtil.getNewSerialNumber());
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "serialNumber=" + serialNumber +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CellPhone cellPhone = (CellPhone) o;
        return year == cellPhone.year && Double.compare(cellPhone.price, price) == 0 && brand.equals(cellPhone.brand);
    }

}
