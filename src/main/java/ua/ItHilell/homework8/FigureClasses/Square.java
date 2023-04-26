package ua.ItHilell.homework8.FigureClasses;

public class Square implements Figure {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int countSquare() {
        return side * side;
    }
}
