package ss10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static ss10.Fruits.add;

public class Main {
    static ArrayList<Fruits> fruits = new ArrayList<>();
    public static void main(String[] args) {
        add(new Fruits("Táo", "Ngon", LocalDate.now(), LocalDate.now().plusDays(10), "Việt Nam", 200000));
        add(new Fruits("Ổi", "Ngon", LocalDate.now(), LocalDate.now().plusDays(15), "Nhật Bản", 150000));
        add(new Fruits("Xoài", "Ngon", LocalDate.now(), LocalDate.now().plusDays(12), "Trung Quốc", 120000));
        add(new Fruits("Dưa hấu", "Ngon", LocalDate.now(), LocalDate.now().plusDays(10), "Campuchia", 340000));
        add(new Fruits("Nho", "Ngon", LocalDate.now(), LocalDate.now().plusDays(17), "Mỹ", 200000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int s = scanner.nextInt();
            switch (s) {
                case 1 -> {
                    for (Fruits fruit : fruits) {
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
}