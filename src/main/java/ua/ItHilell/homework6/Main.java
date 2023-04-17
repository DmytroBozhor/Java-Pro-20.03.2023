package ua.ItHilell.homework6;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(findSymbolOccurrence("This is some text", 'i'));
        System.out.println(findWordPosition("Main source", "ur"));
        System.out.println(stringReverse("SomeText"));
        System.out.println(isPalindrome("alla"));
        guessTheWord();

    }

    public static int findSymbolOccurrence(String str, char c) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                n++;
            }
        }
        return n;
    }

    public static int findWordPosition(String source, String target) {
        if (source.contains(target)) {
            return source.indexOf(target.charAt(0));
        } else {
            return -1;
        }
    }

    public static String stringReverse(String str) {
        char[] charArrayFromString = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = charArrayFromString.length - 1; i >= 0; i--) {
            stringBuilder.append(charArrayFromString[i]);
        }
        return stringBuilder.toString();
    }

    public static boolean isPalindrome(String str) {
        char[] charArrayFromString = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = charArrayFromString.length - 1; i >= 0; i--) {
            stringBuilder.append(charArrayFromString[i]);
        }
        return str.equals(stringBuilder.toString());
    }

    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        boolean i = true;
        Random random = new Random();
        String randomFruit = words[random.nextInt(words.length)];
        StringBuilder starterLine = new StringBuilder("###############");
        while (i) {
            System.out.println(starterLine);
            String answer = scanner.next();
            for (int j = 0; j < randomFruit.length(); j++) {
                for (int k = 0; k < answer.length(); k++) {
                    if (randomFruit.charAt(j) == answer.charAt(k)) {
                        starterLine.setCharAt(j, randomFruit.charAt(j));
                        if (starterLine.toString().substring(0, randomFruit.length()).equals(randomFruit)) {
                            System.out.println("Congratulations, you won! It was " + randomFruit);
                            i = false;
                        }
                    }
                }
            }
        }
    }
}
