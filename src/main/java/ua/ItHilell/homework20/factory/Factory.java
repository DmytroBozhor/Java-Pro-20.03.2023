package ua.ItHilell.homework20.factory;

public abstract class Factory {

    public Furniture create() {
        Furniture furniture = createFurniture();
        furniture.stand();
        return furniture;
    }

    protected abstract Furniture createFurniture();
}
