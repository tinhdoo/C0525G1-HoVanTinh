package ss13.controller;

import ss13.service.ImplSpend;
import java.util.Scanner;

public class SpendController {
    ImplSpend implSpend = new ImplSpend();
    Scanner scanner = new Scanner(System.in);

    public void menuSpend() {
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Danh sách chi tiêu");
            System.out.println("2. Thêm chi tiêu");
            System.out.println("3. Xoá chi tiêu");
            System.out.println("4. Sửa chi tiêu");
            System.out.println("5. Tìm kiếm theo mã");
            System.out.println("6. Tìm kiếm gần đúng theo tên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1 -> implSpend.getAll();
                case 2 -> implSpend.add();
                case 3 -> implSpend.delete();
                case 4 -> implSpend.update();
                case 5 -> implSpend.searchById();
                case 6 -> implSpend.searchByname();
                case 0 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }
}
