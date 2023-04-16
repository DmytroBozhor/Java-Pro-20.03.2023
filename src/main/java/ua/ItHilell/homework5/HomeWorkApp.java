package ua.ItHilell.homework5;

public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkFromTenToTwenty(5, 7));
        checkIfPositiveOrNegative(10);
        System.out.println(checkIfNegative(-5));
        printSeveralTimes("Some text ", 5);
        System.out.println(checkIfLeapYear(2024));

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = 6;
        if (a + b >= 0) {
            System.out.println("The sum is positive");
        } else {
            System.out.println("The sum is negative");
        }
    }

    public static void printColor() {
        int value = 10;
        if (value <= 0) {
            System.out.println("Red");
        } else if (value > 0 && value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    public static void compareNumbers() {
        int a = 3;
        int b = 4;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkFromTenToTwenty(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void checkIfPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is negative");
        }
    }

    public static boolean checkIfNegative(int a) {
        return a < 0;
    }

    public static void printSeveralTimes(String str, int n) {
        System.out.println(str.repeat(n));
    }

    public static boolean checkIfLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }
}
