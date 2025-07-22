package ss13.view;

import ss13.controller.SpendController;
import ss13.entity.Spend;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class SpendView {
    static Scanner scanner = new Scanner(System.in);
    static SpendController controller = new SpendController();


    public static Spend input(int code) {
        System.out.println("Mã: " + code);
        System.out.print("Nhập tên chi tiêu: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày chi tiêu (yyyy/mm/dd): ");
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.print("Nhập số tiền: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String describe = scanner.nextLine();
        return new Spend(code, name, date, amount, describe);
    }

    public static void displaySpend(Collection<Spend> spends) {
        System.out.printf("%-10s %-20s %-12s %-10s %-30s\n", "Mã", "Tên", "Ngày", "Số tiền", "Mô tả");
        System.out.println("---------------------------------------------------------------------------------------");

        for (Spend spend : spends) {
            System.out.printf(
                    "%-10s %-20s %-12s %-10d %-30s\n",
                    spend.getCode(),
                    spend.getName(),
                    spend.getDate(),
                    spend.getAmount(),
                    spend.getDescribe()
            );
        }
        System.out.println("---------------------------------------------------------------------------------------");

    }

    public static void display(Spend spend) {
        System.out.printf("%-10s %-20s %-12s %-10s %-30s\n", "Mã", "Tên", "Ngày", "Số tiền", "Mô tả");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf(
                "%-10s %-20s %-12s %-10d %-30s\n",
                spend.getCode(),
                spend.getName(),
                spend.getDate(),
                spend.getAmount(),
                spend.getDescribe()
        );
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
