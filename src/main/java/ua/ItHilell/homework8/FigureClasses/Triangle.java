package ua.ItHilell.homework8.FigureClasses;

public class Triangle implements Figure {

    private int side;
    private int height;

    public Triangle(int side, int height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public int countSquare() {
        return side * height / 2;
    }
}
