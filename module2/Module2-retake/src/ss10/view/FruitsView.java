package ss10.view;

import ss10.model.Fruit;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FruitsView {
    private static Scanner scanner = new Scanner(System.in);

    public static Fruit input(){
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

        return new Fruit(name, type, productionDate, expiry, country, price);
    }
    public static void displayFruits(List<Fruit> fruits) {
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
}
