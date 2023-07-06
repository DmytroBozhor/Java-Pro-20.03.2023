package ua.ItHilell.homework20.strategy;

public class Rectangle implements Figure {

    private float a;
    private float b;

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void calculateSquare() {
        System.out.println(a * b);
    }
}
