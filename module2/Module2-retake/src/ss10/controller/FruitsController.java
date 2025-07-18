package ss10.controller;

import ss10.service.ImplFruit;
import java.util.Scanner;
public class FruitsController {
    Scanner scanner = new Scanner(System.in);
    ImplFruit implFruit = new ImplFruit();

    public void fruitsController() {
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int choose = scanner.nextInt();
            implFruit.choose(choose);
        }
    }
}
