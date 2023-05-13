package ua.ItHilell.homework11;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[0]);
        }
        return list;
    }
}
