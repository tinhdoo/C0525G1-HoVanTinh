package ss12.service;

import ss12.entity.Fruits;
import ss12.repository.FruitsRepo;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class ImplFruits implements IFruits{
    Scanner scanner = new Scanner(System.in);
    FruitsRepo repo = new FruitsRepo();

    @Override
    public void add() {
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
        repo.fruits.put(newFruit.getId(), newFruit);
        System.out.println("Thêm thành công!");
    }

    @Override
    public void delete() {
        System.out.println("Nhập id cần xoá: ");
        int id = scanner.nextInt();
        if (repo.isIdExist(id)) {
            repo.fruits.remove(id);
            System.out.println("Xoá thành công!");
        }else {
            System.out.println("Id không tồn tại!");
            System.out.println("-----------------");

        }
    }

    @Override
    public void update() {
        System.out.print("Nhập id cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (repo.isIdExist(id)) {
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
            repo.fruits.replace(newFruit.getId(), newFruit);
            System.out.println("Sửa thành công!");
        }else {
            System.out.println("Id không tồn tại!");
            System.out.println("-----------------");
        }
    }

    @Override
    public void showAllFruits(Map<Integer, Fruits> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("Danh sách trái cây trống.");
            return;
        }
        System.out.println("----------------------------DANH SÁCH TRÁI CÂY----------------------------");

        for (Map.Entry<Integer, Fruits> entry : fruits.entrySet()) {
            Fruits fruit = entry.getValue();
            System.out.print(fruit.getId() + " - ");
            System.out.print(fruit.getName() + " - ");
            System.out.print(fruit.getType() + " - ");
            System.out.print("NSX: " + fruit.getProductionDate() + " - ");
            System.out.print("HSD: " + fruit.getExpiry() + " - ");
            System.out.print(fruit.getCountry() + " - ");
            System.out.print(fruit.getPrice());
            System.out.println();
            System.out.println("--------------------------------------------------------------------------");
        }
    }
}
