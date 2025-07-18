package ss10.service;

import ss10.model.Fruit;
import ss10.repository.FruitRepo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static ss10.repository.FruitRepo.fruits;

public class ImplFruit implements IFruits {
    FruitRepo repo = new FruitRepo();

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên trái cây: ");
        String name = scanner.nextLine().trim();
        System.out.println("Nhập loại: ");
        String type = scanner.nextLine();

        System.out.println("Ngày sản xuất: " + LocalDate.now());
        LocalDate productionDate = LocalDate.now();

        System.out.println("Nhập hạn sử dụng (ngày): ");
        LocalDate expiry = LocalDate.now().plusDays(scanner.nextLong());


        System.out.println("Nhập xuất sứ: ");
        scanner.nextLine();
        String country = scanner.nextLine();
        System.out.println("Nhập giá: ");
        int price = scanner.nextInt();

        Fruit newFruit = new Fruit(name, type, productionDate, expiry, country, price);
        fruits.add(newFruit);
    }

    @Override
    public void showAll() {
        if (fruits.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        for (Fruit fruit : fruits) {
            System.out.print(fruit.getName() + " - ");
            System.out.print(fruit.getType() + " - ");
            System.out.print("NSX: " + fruit.getProductionDate() + " - ");
            System.out.print("HSD: " + fruit.getExpiry() + " - ");
            System.out.print(fruit.getCountry() + " - ");
            System.out.print(fruit.getPrice());
            System.out.println();
        }
    }

    @Override
    public void choose(int choose) {
        switch (choose) {
            case 1 -> showAll();
            case 2 -> add();
            case 3 -> {
                System.out.println("Tạm biệt!");
                System.exit(0);
            }
            default -> System.out.println("Vui lòng nhập lại!");
        }
    }
}
