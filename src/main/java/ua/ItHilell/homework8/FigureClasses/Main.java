package ua.ItHilell.homework8.FigureClasses;

public class Main {

    public static void main(String[] args) {

        Figure[] figuresArray = {new Circle(6), new Triangle(5, 7), new Square(5)};

        System.out.println(getSum(figuresArray));

    }

    private static int getSum(Figure[] figuresArray) {
        int sum = 0;
        for (int i = 0; i < figuresArray.length; i++) {
            sum += figuresArray[i].countSquare();
        }
        return sum;
    }
}
