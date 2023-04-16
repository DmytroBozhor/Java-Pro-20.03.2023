package ua.ItHilell.homework4.main;

public class Dog extends Animal {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void run(int length) {
        if (length <= 500) {
            System.out.println(name + " has run " + length + "m.");
        } else {
            System.out.println(name + " cannot run that much");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 10) {
            System.out.println(name + " has swum " + length + "m.");
        } else {
            System.out.println(name + " cannot swim that much");
        }
    }
}
