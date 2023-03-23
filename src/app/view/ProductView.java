package app.view;

import app.config.InputConfig;
import app.controller.ProductController;
import app.model.Product;
import app.services.ProductASCComparator;
import app.services.ProductDSCComparator;

import java.util.Collections;
import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();

    private static int generateId(List<Product> productList) {
        int id = 0;
        if (productList.size() != 0) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() > id) {
                    id = productList.get(i).getId();
                }
            }
        }
        id++;
        return id;
    }

    public void showProductList() {
        List<Product> productList = productController.findAll();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    public void addNewProduct() {
        List<Product> productList = productController.findAll();
        int id = generateId(productList);
        System.out.print("Nhập tên sản phẩm: ");
        String productName = InputConfig.getString();
        System.out.print("Nhập giá sản phẩm: ");
        float price = InputConfig.getFloat();
        Product product = new Product(id, productName, price);
        productController.addNewProduct(product);
        System.out.println("Thêm sản phẩm thành công");
    }

    public void updateProductInfo() {
        System.out.print("Nhập Id sản phẩm: ");
        int id = InputConfig.getInteger();
        Product currentProduct = findProductById(id);
        if (currentProduct == null) return;
        int currentId = currentProduct.getId();
        System.out.printf("Nhập tên sản phẩm (tên hiện tại: %s): ", currentProduct.getProductName());
        String newName = InputConfig.getString();
        System.out.printf("Nhập giá sản phẩm (giá hiện tại: %.1f): ", currentProduct.getPrice());
        float newPrice = InputConfig.getFloat();
        Product product = new Product(currentId, newName, newPrice);
        productController.addNewProduct(product);
        System.out.println("Cập nhật sản phẩm thành công");
    }

    public void deleteProduct() {
        System.out.print("Nhập Id sản phẩm: ");
        int id = InputConfig.getInteger();
        Product currentProduct = findProductById(id);
        if (currentProduct == null) return;
        productController.deleteProduct(id);
        System.out.println("Xóa sản phẩm thành công");
    }

    public void sortAscendingByPrice() {
        ProductASCComparator productASCComparator = new ProductASCComparator();
        Collections.sort(productController.findAll(), productASCComparator);
        this.showProductList();
    }

    public void sortDescendingByPrice() {
        ProductDSCComparator productDSCComparator = new ProductDSCComparator();
        Collections.sort(productController.findAll(), productDSCComparator);
        this.showProductList();
    }

    public void findProductByName() {
        System.out.println("Nhập tên sản phẩm");
        String productName = InputConfig.getString();
        System.out.println("...Các kết quả hợp lệ....");
        productController.findByName(productName);
    }

    private Product findProductById(int id) {
        Product currentProduct = productController.findById(id);
        if (currentProduct == null) {
            System.err.println("Không tìm thấy sản phẩm hợp lệ");
            return null;
        }
        return currentProduct;
    }
}
