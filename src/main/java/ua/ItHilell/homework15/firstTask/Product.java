package ua.ItHilell.homework15.firstTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {

    private String type;
    private int price;

    public Product(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public Product() {
    }


    public static List<Product> getBooks(List<Product> productList) {
        List<Product> bookList = new ArrayList<>(productList);
        bookList = bookList.stream().filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getPrice() > 250)
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
}
