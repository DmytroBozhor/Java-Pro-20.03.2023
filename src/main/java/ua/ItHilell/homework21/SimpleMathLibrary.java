package ua.ItHilell.homework21;


import java.util.Arrays;
import java.util.function.IntPredicate;

public class SimpleMathLibrary {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double minus(double a, double b) {
        return a - b;
    }

    public static int[] getLastNumbers(int[] array) {
        String numbers = Arrays.toString(array);
        if (numbers.contains("4")) {
            int lastFourIndex = numbers.lastIndexOf("4");
            String[] lastNumbers = numbers.substring(lastFourIndex + 3, numbers.length() - 1).split(", ");
            int[] result = new int[lastNumbers.length];
            for (int i = 0; i < lastNumbers.length; i++) {
                result[i] = Integer.parseInt(lastNumbers[i]);
            }
            return result;
        } else {
            throw new RuntimeException();
        }
    }

    public static boolean checkForOneAndFour(int[] array) {
        int[] filteredArray = Arrays.stream(array).filter(value -> value == 4 || value == 1).toArray();
        if (filteredArray.length != array.length) {
            return false;
        } else return Arrays.toString(filteredArray).contains("1") && Arrays.toString(filteredArray).contains("4");
    }
}
