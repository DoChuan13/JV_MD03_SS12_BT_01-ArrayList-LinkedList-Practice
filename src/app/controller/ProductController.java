package app.controller;

import app.model.Product;
import app.services.ProductIPLM;

import java.util.List;

public class ProductController {
    ProductIPLM productIPLM = new ProductIPLM();

    public List<Product> findAll() {
        return productIPLM.findAll();
    }

    public void addNewProduct(Product product) {
        productIPLM.save(product);
    }

    public Product findById(int id) {
        return productIPLM.findById(id);
    }

    public void deleteProduct(int id) {
        productIPLM.delete(id);
    }

    public void findByName(String name) {
        productIPLM.findByName(name);
    }
}
