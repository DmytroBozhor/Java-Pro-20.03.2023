package ua.ItHilell.homework20.factory;

public class SofaFactory extends Factory {
    @Override
    protected Furniture createFurniture() {
        return new Sofa();
    }
}
