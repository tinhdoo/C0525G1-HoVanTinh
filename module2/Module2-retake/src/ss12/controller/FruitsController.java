package ss12.controller;

import ss12.model.Fruits;
import ss12.repository.FruitsRepo;
import ss12.service.IFruits;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class FruitsController implements IFruits {
    private static FruitsRepo repo = new FruitsRepo();
    private static Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Xoá");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            int s = scanner.nextInt();
            switch (s) {
                case 1 -> {
                    showAllFruits(repo.getAll());
                }
                case 2 -> add();
                case 3 -> delete();
                case 4 -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }

    public static void add() {
        System.out.println("-----Thêm trái cây-----");
        System.out.print("Nhập id: ");
        int id = scanner.nextInt();
        if (repo.isIdExist(id)) {
            System.out.println("Id đã tồn tại!");
            System.out.println("-----------------------");
            return;
        }
        scanner.nextLine();

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

        Fruits newFruit = new Fruits(id, name, type, productionDate, expiry, country, price);
        repo.addFruit(id, newFruit);
        System.out.println("Thêm thành công!");
    }

    public static void displayFruit(Fruits fruit) {
        System.out.print(fruit.getId() + " - ");
        System.out.print(fruit.getName() + " - ");
        System.out.print(fruit.getType() + " - ");
        System.out.print("NSX: " + fruit.getProductionDate() + " - ");
        System.out.print("HSD: " + fruit.getExpiry() + " - ");
        System.out.print(fruit.getCountry() + " - ");
        System.out.print(fruit.getPrice());
        System.out.println();
    }

    public static void showAllFruits(Map<Integer, Fruits> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("Danh sách trái cây trống.");
            return;
        }
        System.out.println("----------------------------DANH SÁCH TRÁI CÂY----------------------------");

        for (Map.Entry<Integer, Fruits> entry : fruits.entrySet()) {
            Fruits fruit = entry.getValue();
            displayFruit(fruit);
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    @Override
    public void delete() {
        repo.deleteFruit();
    }

    @Override
    public void update() {

    }
}


