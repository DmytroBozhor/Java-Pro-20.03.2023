package ua.ItHilell.homework15.fifthTask;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Product {

    private String type;
    private int price;
    private boolean discount;
    private LocalDate date;

    public Product() {
    }

    public Product(String type, int price, boolean discount, LocalDate date) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    private static int getCurrentYearBooksSum(List<Product> productList) {
        List<Product> copyList = new ArrayList<>(productList);

        copyList = copyList.stream()
                .filter(product -> product.getDate().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getPrice() <= 75)
                .collect(Collectors.toList());

        int sum = 0;
        for (Product product : copyList
        ) {
            sum = sum + product.getPrice();
        }

        return sum;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
