package ss10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static ss10.Fruits.add;

public class Main {
    static ArrayList<Fruits> fruits = new ArrayList<>();

    public static void main(String[] args) {
        add(new Fruits("Táo", "Ngon", LocalDate.of(2025, 7, 5), LocalDate.of(2025, 8, 29), "Việt Nam", 200000));
        add(new Fruits("Ổi", "Ngon", LocalDate.of(2025, 7, 3), LocalDate.of(2025, 8, 29), "Nhật Bản", 150000));
        add(new Fruits("Xoài", "Ngon", LocalDate.of(2025, 6, 12), LocalDate.of(2025, 8, 29), "Trung Quốc", 120000));
        add(new Fruits("Dưa hấu", "Ngon", LocalDate.of(2025, 1, 25), LocalDate.of(2025, 8, 29), "Campuchia", 340000));
        add(new Fruits("Nho", "Ngon", LocalDate.of(2025, 7, 5), LocalDate.of(2025, 8, 29), "Mỹ", 200000));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int s = scanner.nextInt();
            switch (s) {
                case 1:
                    for (Fruits fruit : fruits) {
                        System.out.print(fruit.getName() + " - ");
                        System.out.print(fruit.getType() + " - ");
                        System.out.print(fruit.getProductionDate() + " - ");
                        System.out.print(fruit.getCountry() + " - ");
                        System.out.print(fruit.getPrice());
                        System.out.println();
                    }
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại!");
            }
        }
    }
}