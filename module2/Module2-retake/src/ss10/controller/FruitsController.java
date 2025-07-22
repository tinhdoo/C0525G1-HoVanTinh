package ss10.controller;

import ss10.service.FruitService;

import java.util.Scanner;

public class FruitsController {
    Scanner scanner = new Scanner(System.in);
    FruitService service = new FruitService();

    public void fruitsController() {
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1 -> service.showAll();
                case 2 -> {
                    service.add();
                    System.out.println("Thêm trái cây thành công!");
                }

                case 3 -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }
}
