package ua.ItHilell.homework15.thirdTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static Product getBookLowestPrice(List<Product> productList) {
        List<Product> bookMinPrice = new ArrayList<>(productList);

        Optional<Product> book = bookMinPrice.stream()
                .filter(product -> product.getType().equals("Book"))
                .min((o1, o2) -> {
                    Integer price1 = o1.getPrice();
                    Integer price2 = o2.getPrice();
                    return price1.compareTo(price2);
                });
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new RuntimeException("Product [category: Book] was not found");
        }
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
