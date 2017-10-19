// -------------------------------------------------------
// Assignment 4
// Part: II
// Written by: Ling Tan, Marzie Shafiee
// -------------------------------------------------------
package part2;

import java.util.HashSet;

/**
 * @author Ling Tan
 * @author Marzie Shafiee
 */
public class SerialNumberUtil {
    private static long max = 0l;

    private static HashSet<Long> serialNumberSet = new HashSet<Long>() {
        @Override
        public boolean add(Long l) {
            if (l > max) {
                max = l;
            }
            return super.add(l);
        }
    };

    private SerialNumberUtil() {
    }

    public static void storeSerialNumber(long serialNumber){
        serialNumberSet.add(serialNumber);
    }

    public static long getNewSerialNumber() {
        return ++max;
    }

    public static boolean isUnique(long serialNumber) {
        return serialNumberSet.contains(serialNumber);
    }
}
