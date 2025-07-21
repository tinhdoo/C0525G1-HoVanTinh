package ss12.view;

import ss12.entity.Fruits;

import java.security.Key;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class FruitsView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayFruits(Map<Integer, Fruits> fruits) {
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
    public static void displayFruitsII(Map<Integer, Fruits> fruits) {
        System.out.println("----------------------------DANH SÁCH TRÁI CÂY----------------------------");

        for (Integer id : fruits.keySet()){
            Fruits fruit = fruits.get(id);
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
    public static Fruits input(int id){

        System.out.println("Id: " + id);
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
        scanner.nextLine();
        return new Fruits(id, name, type, productionDate, expiry, country, price);

    }
}
