package ua.ItHilell.homework15.fourthTask;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    private static List<Product> getLastFourProducts(List<Product> productList) {
        List<Product> lastFourElementsList = new ArrayList<>(productList);
        lastFourElementsList = lastFourElementsList.stream()
                .sorted((o1, o2) -> {
                    LocalDate date1 = o1.getDate();
                    LocalDate date2 = o2.getDate();
                    return date1.compareTo(date2);
                })
                .skip(productList.size() - 4)
                .collect(Collectors.toList());
        return lastFourElementsList;
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

    public void setAddData(LocalDate date) {
        this.date = date;
    }
}
