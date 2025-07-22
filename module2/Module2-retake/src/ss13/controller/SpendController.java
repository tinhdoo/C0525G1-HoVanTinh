package ss13.controller;

import ss13.repository.SpendRepo;
import ss13.service.SpendService;

import java.util.Scanner;

public class SpendController {
    SpendService service = new SpendService();
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
                case 1 -> service.getAll();
                case 2 -> {
                    System.out.println("====THÊM CHI TIÊU====");
                    System.out.println("Nhập mã chi tiêu: ");
                    int code = scanner.nextInt();
                    service.add(code);
                }
                case 3 -> {
                    System.out.println("====XOÁ CHI TIÊU====");
                    System.out.println("Nhập mã chi tiêu cần xoá: ");
                    int code = scanner.nextInt();
                    service.delete(code);
                }
                case 4 -> {
                    System.out.println("====SỬA CHI TIÊU====");
                    System.out.print("Nhập mã chi tiêu: ");
                    int code = scanner.nextInt();
                    service.update(code);
                }
                case 5 -> {
                    System.out.println("====TÌM CHI TIÊU THEO MÃ====");
                    System.out.println("Nhập mã cần tìm: ");
                    int code = scanner.nextInt();
                    service.searchById(code);
                }
                case 6 -> {
                    System.out.println("====TÌM CHI TIÊU THEO TÊN====");
                    System.out.println("Nhập tên cần tìm: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    service.searchByname(name);
                }
                case 0 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }
}
