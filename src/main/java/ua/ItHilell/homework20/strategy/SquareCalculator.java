package ua.ItHilell.homework20.strategy;

public class SquareCalculator {

    Figure figure;

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public void executeSquareCalculation() {
        figure.calculateSquare();
    }
}
