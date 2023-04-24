package ua.ItHilell.homework7;

public class ArrayValueCalculator {

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4) {
            throw new ArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Cannot transform to number. Index: " + "Row = " + i + ", Kolumn = " + j);
                }
            }
        }
        return sum;
    }

}
