package ss12.controller;

import ss12.repository.FruitsRepo;
import ss12.service.ImplFruits;
import java.util.Scanner;

public class FruitsController{
    private static FruitsRepo repo = new FruitsRepo();
    private static final Scanner scanner = new Scanner(System.in);
    ImplFruits implFruits = new ImplFruits();

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
                    implFruits.showAllFruits(repo.fruits);
                }
                case 2 -> implFruits.add();
                case 3 -> implFruits.delete();
                case 4 -> implFruits.update();
                case 5 -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }
}




