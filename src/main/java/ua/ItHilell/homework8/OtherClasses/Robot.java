package ua.ItHilell.homework8.OtherClasses;

public class Robot implements Participant {
    @Override
    public void run() {
        System.out.println("The robot is running");
    }

    @Override
    public void jump() {
        System.out.println("The robot is jumping");
    }
}
