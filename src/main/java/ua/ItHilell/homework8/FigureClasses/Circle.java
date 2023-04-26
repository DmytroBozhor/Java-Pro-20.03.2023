package ua.ItHilell.homework8.FigureClasses;

public class Circle implements Figure {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int countSquare() {
        return (int) 3.14 * radius * radius;
    }
}
