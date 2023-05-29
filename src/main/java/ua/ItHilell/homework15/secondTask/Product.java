package ua.ItHilell.homework15.secondTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {

    private String type;
    private int price;
    private boolean discount;

    public Product() {
    }

    public Product(String type, int price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public static List<Product> getBooksWithDiscount(List<Product> productList) {
        List<Product> bookList = new ArrayList<>(productList);

        bookList = bookList.stream()
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.isDiscount())
                .peek(product -> product.setPrice(product.getPrice() - product.getPrice() / 10))
                .collect(Collectors.toList());

        return bookList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
}
