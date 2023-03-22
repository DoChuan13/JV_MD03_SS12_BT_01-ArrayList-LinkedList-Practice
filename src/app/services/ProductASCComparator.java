package app.services;

import app.model.Product;

import java.util.Comparator;

public class ProductASCComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        float result = product1.getPrice() - product2.getPrice();
        if (result > 0) return 1;
        else if (result < 0) return -1;
        return 0;
    }
}
