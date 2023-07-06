package ua.ItHilell.homework20.factory;

public class TableFactory extends Factory {
    @Override
    protected Furniture createFurniture() {
        return new Table();
    }
}
