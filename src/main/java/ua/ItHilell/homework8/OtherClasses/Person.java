package ua.ItHilell.homework8.OtherClasses;

public class Person implements Participant {
    @Override
    public void run() {
        System.out.println("The person is running");
    }

    @Override
    public void jump() {
        System.out.println("The person is jumping");
    }
}
