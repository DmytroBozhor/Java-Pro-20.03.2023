package ua.ItHilell.homework11v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private static final float appleWeight = 1.0F;
    private static final float orangeWeight = 1.5F;
    private List<T> fruitList = new ArrayList<>();

    public void addFruit(T fruit) {
        fruitList.add(fruit);
    }

    public void addFruit(T[] fruit) {
        fruitList.addAll(Arrays.asList(fruit));
    }

    public float getWeight() {
        float weight = fruitList.get(0) instanceof Apple ? appleWeight : orangeWeight;
        return fruitList.size() * weight;
    }

    public boolean compare(Box<T> box) {
        return this.getWeight() == box.getWeight();
    }

    public void merge(Box<T> box) {
        this.getFruitList().addAll(box.getFruitList());
    }

    public List<T> getFruitList() {
        return fruitList;
    }

}
