package ua.ItHilell.homework4.main;

public class Cat extends Animal {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.println(name + " has run " + length + "m.");
        } else {
            System.out.println(name + " cannot run that much");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " cannot swim");
    }
}
