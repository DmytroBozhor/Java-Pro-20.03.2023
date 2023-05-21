package ua.ItHilell.homework14;

public class Order {

    private int orderNumber;

    private String personName;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "" + orderNumber + " " + "|" + " " + personName;
    }
}
