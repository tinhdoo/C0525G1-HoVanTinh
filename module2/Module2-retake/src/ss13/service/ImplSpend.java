package ss13.service;

import ss13.entity.Spend;
import ss13.repository.SpendRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ImplSpend implements ISpend {
    Scanner scanner = new Scanner(System.in);
    SpendRepo repo = new SpendRepo();

    @Override
    public void add() {
        System.out.println("====THÊM CHI TIÊU====");
        System.out.print("Nhập mã chi tiêu: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên chi tiêu: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày chi tiêu (yyyy/mm/dd): ");
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.print("Nhập số tiền: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String describe = scanner.nextLine();

        Spend newSpend = new Spend(code, name, date,amount,describe);
        repo.listSpend.put(code, newSpend);
        System.out.println("Thêm thành công");
    }

    @Override
    public void delete() {


    }

    @Override
    public void update() {
        System.out.println("====SỬA CHI TIÊU====");
        System.out.print("Nhập mã chi tiêu: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên chi tiêu: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày chi tiêu (yyyy/mm/dd): ");
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.print("Nhập số tiền: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String describe = scanner.nextLine();

        Spend newSpend = new Spend(code, name, date,amount,describe);
        repo.listSpend.put(code, newSpend);
        System.out.println("Thêm thành công");

    }

    @Override
    public void searchById() {

    }

    @Override
    public void searchByname() {

    }

    @Override
    public void getAll() {
        if (repo.listSpend.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        } else {
            System.out.printf("%-10s %-20s %-12s %-10s %-30s\n", "Mã", "Tên", "Ngày", "Số tiền", "Mô tả");
            System.out.println("---------------------------------------------------------------------------------------");

            for (Map.Entry<Integer, Spend> entry : repo.listSpend.entrySet()) {
                Spend spend1 = entry.getValue();
                System.out.printf(
                        "%-10s %-20s %-12s %-10d %-30s\n",
                        spend1.getCode(),
                        spend1.getName(),
                        spend1.getDate(),
                        spend1.getAmount(),
                        spend1.getDescribe()
                );
            }
            System.out.println("---------------------------------------------------------------------------------------");

        }
    }
}