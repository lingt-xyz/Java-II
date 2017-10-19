// -------------------------------------------------------
// Assignment 4
// Part: II
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Ling Tan
 * @author Marzie Shafiee
 */
public class CellListUtilization {

    private static final String FILE_NAME = "./Assignment4/resource/Cell_Info.txt";
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        CellList list1 = new CellList();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream(FILE_NAME));
            while (sc.hasNextLine()) {
                String[] infos = sc.nextLine().split("\\s+");
                CellPhone value = new CellPhone(Long.parseLong(infos[0]), infos[1], Integer.parseInt(infos[3]), Double.parseDouble(infos[2]));
                if (list1.find(value.getSerialNumber()) == null) {
                    list1.addToStart(value);
                } else {
                    System.out.println("----->Duplicate record was found: " + value);
                }
            }
            list1.showContents();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        if (list1.getSize() != 0) {
            CellList.CellNode node = list1.find(getSerialNumber());
            System.out.println(node);
        }
        CellListUtilization test = new CellListUtilization();
        test.testCases(list1);
    }

    private static long getSerialNumber() {
        long serialNumber;
        while (true) {
            System.out.print("Please input the serial number of the cellphone you are looking for:");
            try {
                serialNumber = keyboard.nextLong();
                keyboard.nextLine();
                break;
            } catch (InputMismatchException e) {
                keyboard.nextLine();
                System.out.println("----->Invalid input!<-----");
            }
        }
        return serialNumber;
    }

    private void testCases(CellList list1) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 1: Copy Constructor                                                  |");
        System.out.println("-----------------------------------------------------------------------------------");
        CellList list2 = new CellList(list1);//Test copy constructor
        list2.showContents();
        System.out.println("Whether the new list equals to the original list: " + list2.equals(list1));
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 2: insertAtIndex(CellPhone value, int index)                         |");
        System.out.println("|  -->insert a new CellPhone at index 0                                           |");
        System.out.println("-----------------------------------------------------------------------------------");
        list2.insertAtIndex(new CellPhone(SerialNumberUtil.getNewSerialNumber(), "test_brand1", 2016, 1024), 0);
        list2.showContents();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 3: insertAtIndex(CellPhone value, int index)                         |");
        System.out.println("|  -->insert a new CellPhone at index 1                                           |");
        System.out.println("-----------------------------------------------------------------------------------");
        list2.insertAtIndex(new CellPhone(SerialNumberUtil.getNewSerialNumber(), "test_brand2", 2017, 2048), 1);
        list2.showContents();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 4: deleteFromIndex(int index)                                        |");
        System.out.println("|  -->delete the element at index 0                                               |");
        System.out.println("-----------------------------------------------------------------------------------");
        list2.deleteFromIndex(0);
        list2.showContents();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 5: deleteFromIndex(int index)                                        |");
        System.out.println("|  -->delete the element at index 1                                               |");
        System.out.println("-----------------------------------------------------------------------------------");
        list2.deleteFromIndex(1);
        list2.showContents();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 6: deleteFromStart()                                                 |");
        System.out.println("|  -->delete the element at the start                                             |");
        System.out.println("-----------------------------------------------------------------------------------");
        list2.deleteFromStart();
        list2.showContents();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 7: replaceAtIndex(CellPhone value, int index)                        |");
        System.out.println("|  -->replace the element at index 0                                              |");
        System.out.println("-----------------------------------------------------------------------------------");
        list2.replaceAtIndex(new CellPhone(SerialNumberUtil.getNewSerialNumber(), "test_brand3", 2018, 4096), 0);
        list2.showContents();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 8: replaceAtIndex(CellPhone value, int index)                        |");
        System.out.println("|  -->replace the element at index 1                                              |");
        System.out.println("-----------------------------------------------------------------------------------");
        list2.replaceAtIndex(new CellPhone(SerialNumberUtil.getNewSerialNumber(), "test_brand4", 2019, 8192), 1);
        list2.showContents();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 6: find(long serialNumber)                                           |");
        System.out.println("|  -->find an element by its serialNumber 1989000                                 |");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(list2.find(1989000));
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|  Test case 7: contains(long serialNumber)                                       |");
        System.out.println("|  -->check whether the list contains one particular element by its serial number |");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("The list did " + (list2.contains(9873346) ? "" : "not ") + "contain the element whose serial number is " + "9873346");
    }
}
