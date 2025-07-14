package ss12.controller;

import ss12.model.Fruits;
import ss12.service.IFruits;
import java.util.Map;
import java.util.Scanner;

import static ss12.repository.FruitsRepo.fruits;

public class FruitsController implements IFruits {
    Scanner scanner = new Scanner(System.in);
    public void fruitsManager(){
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int s = scanner.nextInt();
            switch (s) {
                case 1 -> {
                    for (Map.Entry<Integer, Fruits> entry : fruits.entrySet()) {
                        Fruits fruit = entry.getValue();
                        System.out.println(fruit.getId() + " - ");
                        System.out.print(fruit.getName() + " - ");
                        System.out.print(fruit.getType() + " - ");
                        System.out.print("NSX: " + fruit.getProductionDate() + " - ");
                        System.out.print("HSD: " + fruit.getExpiry() + " - ");
                        System.out.print(fruit.getCountry() + " - ");
                        System.out.print(fruit.getPrice());
                        System.out.println();
                    }
                }
                case 2 -> add();
                case 3 -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

}
