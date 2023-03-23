package app.services;

import app.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductIPLM implements IService<Product> {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Apple", 1900));
        productList.add(new Product(2, "Dell", 1500));
        productList.add(new Product(3, "Samsung", 2000));
        productList.add(new Product(4, "HP", 1100));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product save(Product product) {
        Product currentProduct = findById(product.getId());
        if (currentProduct == null) {
            productList.add(product);
            return product;
        }
        int index = productList.indexOf(product);
        productList.set(index, product);
        return product;
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void findByName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(product);
            }
        }
    }


    @Override
    public Product delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId() == id) {
                return productList.remove(i);
            }
        }
        return null;
    }
}
