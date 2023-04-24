package ua.ItHilell.homework7;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "" + (int) (Math.random() * 10);
            }
        }

        try {
            System.out.println(ArrayValueCalculator.doCalc(array));
        } catch (ArraySizeException e) {
            System.out.println("Something went wrong. Try to change the size of the array...");
        } catch (ArrayDataException e) {
            System.out.println("Something went wrong. Check if every element is a number...");
        }


    }
}
