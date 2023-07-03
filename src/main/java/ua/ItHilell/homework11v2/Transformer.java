package ua.ItHilell.homework11v2;

import java.util.List;

public class Transformer {

    public <T> List<T> toList(T[] array) {
        return List.of(array);
    }

}
