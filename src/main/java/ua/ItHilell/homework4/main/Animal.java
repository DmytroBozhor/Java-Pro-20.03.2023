package ua.ItHilell.homework4.main;

public class Animal {

    public static int counter;

    public Animal() {
        counter++;
    }

    public void run(int length) {
        System.out.println("The animal has run " + length + "m");
    }

    public void swim(int length) {
        System.out.println("The animal has swum " + length + "m");
    }

}
