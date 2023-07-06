package ua.ItHilell.homework20.strategy;

public class Triangle implements Figure {

    private float a;
    private float height;

    public Triangle(float a, float height) {
        this.a = a;
        this.height = height;
    }

    @Override
    public void calculateSquare() {
        System.out.println(a * height / 2);
    }
}
