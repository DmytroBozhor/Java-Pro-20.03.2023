package ua.ItHilell.homework8.OtherClasses;

public class Cat implements Participant {
    @Override
    public void run() {
        System.out.println("The cat is running");
    }

    @Override
    public void jump() {
        System.out.println("The cat is jumping");
    }
}
