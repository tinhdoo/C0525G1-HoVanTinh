package ss12.controller;

import ss12.entity.Fruits;
import ss12.repository.FruitsRepo;
import ss12.service.FruitService;
import ss12.view.FruitsView;

import java.util.Map;
import java.util.Scanner;

public class FruitsController {
    private static final Scanner scanner = new Scanner(System.in);
    FruitService service = new FruitService();

    public void run() {
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Xoá");
            System.out.println("4. Sửa");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int s = scanner.nextInt();
            switch (s) {
                case 1 -> {
                    showAll();
                }
                case 2 -> {
                    System.out.println("-----THÊM TRÁI CÂY-----");
                    System.out.print("Nhập id: ");
                    int id = scanner.nextInt();
                    service.add(id);
                }
                case 3 -> {
                    System.out.println("-----XOÁ TRÁI CÂY-----");
                    System.out.println("Nhập id cần xoá: ");
                    int id = scanner.nextInt();
                    service.delete(id);
                }
                case 4 -> {
                    System.out.println("-----SỬA THÔNG TIN TRÁI CÂY-----");
                    System.out.print("Nhập id cần sửa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    service.update(id);
                }
                case 5 -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }
    public void showAll() {
        Map<Integer, Fruits> all = service.getAllFruits();
        FruitsView.displayFruitsII(all);
    }

}




