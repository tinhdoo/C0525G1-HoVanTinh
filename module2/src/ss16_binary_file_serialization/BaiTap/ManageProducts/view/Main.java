package ss16_binary_file_serialization.BaiTap.ManageProducts.view;

import ss16_binary_file_serialization.BaiTap.ManageProducts.model.Products;
import ss16_binary_file_serialization.BaiTap.ManageProducts.repository.ProductManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo tên");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã sản phẩm: ");
                    int code = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập hãng sản xuất: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String status = scanner.nextLine();

                    Products product = new Products(code, name, price, manufacturer, status);
                    manager.addProduct(product);
                    System.out.println("Thêm sản phẩm thành công!");
                    break;
                case 2:
                    manager.displayAll();
                    break;
                case 3:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String keyword = scanner.nextLine();
                    manager.searchByName(keyword);
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-4.");
            }
        }
    }
}
