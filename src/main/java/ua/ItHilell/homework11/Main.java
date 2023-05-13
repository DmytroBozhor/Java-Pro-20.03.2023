package ua.ItHilell.homework11;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        String[] myArray = {"sdff", "sdfsfd", "fsdfsdf", "sdfsdf", "sdf"};
//        Integer[] myIntArray = {1, 2, 3, 5, 9};
//
//        List<String> myList = Transformer.toList(myArray);
//        List<Integer> myIntList = Transformer.toList(myIntArray);
//
//        for (String str : myArray
//        ) {
//            System.out.println(str);
//        }
//
//        for (Integer a : myIntArray
//        ) {
//            System.out.println(a);
//        }


        List<Apple> appleList = new ArrayList<>();

        Box.addFruit(appleList, new Apple());
        Box.addFruit(appleList, new Apple());
        Box.addFruit(appleList, new Apple());
        Box.addFruit(appleList, new Apple());

        Box.addFruits(appleList, new Apple(), 10);

        System.out.println(Box.getWeight(appleList));

        List<Orange> orangeList = new ArrayList<>();

        Box.addFruit(orangeList, new Orange());
        Box.addFruit(orangeList, new Orange());
        Box.addFruit(orangeList, new Orange());
        Box.addFruit(orangeList, new Orange());
        Box.addFruit(orangeList, new Orange());

        Box.addFruits(orangeList, new Orange(), 8);

        System.out.println(Box.getWeight(orangeList));

        System.out.println(Box.compare(appleList, orangeList));

        Box.merge(appleList, appleList);

        System.out.println(Box.getWeight(appleList));

    }
}
