package learn.utils;

import java.util.List;

public class PrintUtils {

    private PrintUtils() {
    }

    public static void printIntArray(final int[] array) {
        for (int i :
                array) {
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }

    public static void printIntList(final List<Integer> integerList) {
        for (int i :
                integerList) {
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }

}

