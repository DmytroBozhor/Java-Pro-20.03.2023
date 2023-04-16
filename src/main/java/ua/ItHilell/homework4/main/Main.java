package ua.ItHilell.homework4.main;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Barsik");
        Dog dog = new Dog("Bobik");

        System.out.println();

        cat.run(50);
        cat.run(500);
        cat.swim(200);

        System.out.println();

        dog.run(60);
        dog.run(600);
        dog.swim(8);
        dog.swim(80);

        System.out.println();

        System.out.println("Animals, cats and dogs sum: " + Animal.counter);

    }
}