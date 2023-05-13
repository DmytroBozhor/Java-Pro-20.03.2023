package ua.ItHilell.homework11;

import java.util.List;

public class Box {

    private static float appleWeight = 1.0f;
    private static float orangeWeight = 1.5f;

    public static <T> void addFruit(List<T> list, T fruit) {
        list.add(fruit);
    }

    public static <T> void addFruits(List<T> list, T fruit, int number) {
        for (int i = 0; i < number; i++) {
            list.add(fruit);
        }
    }

    public static <T> float getWeight(List<T> list) {
        return list.get(0) instanceof Apple ? list.size() * appleWeight : list.size() * orangeWeight;
    }

    public static <T1, T2> boolean compare(List<T1> list, List<T2> list2) {
        return getWeight(list) == getWeight(list2);
    }

    public static <T> void merge(List<T> list, List<T> list2) {
        list.addAll(list2);
    }

    public static float getAppleWeight() {
        return appleWeight;
    }

    public static void setAppleWeight(float appleWeight) {
        Box.appleWeight = appleWeight;
    }

    public static float getOrangeWeight() {
        return orangeWeight;
    }

    public static void setOrangeWeight(float orangeWeight) {
        Box.orangeWeight = orangeWeight;
    }
}
