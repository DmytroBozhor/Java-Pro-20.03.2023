package ua.ItHilell.homework21;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;


class SimpleMathLibraryTest {

    @Test
    void add() {
        Assertions.assertEquals(SimpleMathLibrary.add(2, 5), 7);
    }

    @Test
    void minus() {
        Assertions.assertEquals(SimpleMathLibrary.minus(5, 2), 3);
    }

    @Test
    void getLastNumbers() {
        Assertions.assertEquals(Arrays.toString(SimpleMathLibrary
                .getLastNumbers(new int[]{1, 2, 4, 5, 7, 2, 4, 8, 6, 9})), Arrays.toString(new int[]{8, 6, 9}));
        Assertions.assertEquals(Arrays.toString(SimpleMathLibrary
                .getLastNumbers(new int[]{1, 2, 4, 5, 7, 2, 4, 7, 6, 1})), Arrays.toString(new int[]{7, 6, 1}));
        Assertions.assertEquals(Arrays.toString(SimpleMathLibrary
                .getLastNumbers(new int[]{1, 2, 4, 5, 7, 2, 4, 2, 2, 8})), Arrays.toString(new int[]{2, 2, 8}));
    }

    @Test
    void getLastNumbersException() {
        int[] array = {1, 2, 5, 7, 2, 8, 6, 9};
        Assertions.assertThrows(RuntimeException.class, () -> SimpleMathLibrary.getLastNumbers(array));
    }

    @Test
    void checkForOneAndFourTrue() {
        Assertions.assertTrue(SimpleMathLibrary.checkForOneAndFour(new int[]{1, 4, 1, 1, 4, 1, 4, 1, 4}));
        Assertions.assertTrue(SimpleMathLibrary.checkForOneAndFour(new int[]{1, 1, 4, 1, 4, 4, 1, 1, 4}));
        Assertions.assertTrue(SimpleMathLibrary.checkForOneAndFour(new int[]{1, 1, 1, 4, 4, 1, 4, 1, 4}));
    }

    @Test
    void checkForOneAndFourFalse() {
        Assertions.assertFalse(SimpleMathLibrary.checkForOneAndFour(new int[]{1, 1, 11, 1, 4, 4, 4, 1, 4, 5}));
        Assertions.assertFalse(SimpleMathLibrary.checkForOneAndFour(new int[]{1, 1, 1, 1, 4, 4, 45, 4, 1, 4, 4}));
        Assertions.assertFalse(SimpleMathLibrary.checkForOneAndFour(new int[]{1, 1, 1, 45, 4, 4, 4, 1, 4, 1}));
    }
}