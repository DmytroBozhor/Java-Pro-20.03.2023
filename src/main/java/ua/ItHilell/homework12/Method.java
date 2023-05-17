package ua.ItHilell.homework12;

import java.util.ArrayList;
import java.util.List;

public class Method {

    public int countOccurance(List<String> list, String occurance) {
        int counter = 0;
        for (String str : list
        ) {
            if (str.equals(occurance)) {
                counter++;
            }
        }
        return counter;
    }

    public <T> List<T> toList(T[] array) {
        List<T> arrayToList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayToList.add(array[i]);
        }
        return arrayToList;
    }

    public List<Integer> findUnique(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer i : list
        ) {
            if (!uniqueList.contains(i)) {
                uniqueList.add(i);
            }
        }
        return uniqueList;
    }

}
