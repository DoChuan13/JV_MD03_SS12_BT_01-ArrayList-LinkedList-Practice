package app.view;

import app.config.InputConfig;

public class Main {
    public Main() {
        while (true) {
            System.out.println("---------------------Product Management---------------------");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp theo giá tăng");
            System.out.println("7. Sắp xếp theo giá giảm");
            System.out.println("0. Thoát ứng dụng");
            System.out.println("\t Chọn một lựa chọn bất kỳ.....");
            byte option = InputConfig.getByte();
            switch (option) {
                case 1:
                    new ProductView().showProductList();
                    break;
                case 2:
                    new ProductView().addNewProduct();
                    break;
                case 3:
                    new ProductView().updateProductInfo();
                    break;
                case 4:
                    new ProductView().deleteProduct();
                    break;
                case 5:
                    new ProductView().findProductByName();
                    break;
                case 6:
                    new ProductView().sortAscendingByPrice();
                    break;
                case 7:
                    new ProductView().sortDescendingByPrice();
                    break;
                case 0:
                    System.out.println("Thoát ứng dụng!!!!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ, vui lòng chọn lại...");
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}