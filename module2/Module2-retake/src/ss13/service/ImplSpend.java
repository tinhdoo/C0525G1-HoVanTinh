package ss13.service;

import ss13.entity.Spend;
import ss13.repository.SpendRepo;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class ImplSpend implements ISpend {
    Scanner scanner = new Scanner(System.in);
    SpendRepo repo = new SpendRepo();

    @Override
    public void add() {
        System.out.println("====Thêm chi tiêu====");
        System.out.println("Nhập mã chi tiêu: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên chi tiêu: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày chi tiêu");
        LocalDate date = LocalDate.ofEpochDay(scanner.nextInt());
        System.out.println("Nhập số tiền: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập mô tả: ");
        String describe = scanner.nextLine();

        Spend newSpend = new Spend();
        repo.listSpend.put(code, newSpend);
        System.out.println("Thêm thành công");


    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void choose() {
        int choose = scanner.nextInt();
        while (true) {
            switch (choose) {
                case 1:
                    getAll(Map.of());
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    searchById();
                    break;
                case 6:
                    searchByname();
                    break;
                case 0:
                    return;
            }
        }
    }

    @Override
    public void searchById() {

    }

    @Override
    public void searchByname() {

    }

    @Override
    public void getAll(Map<Integer, Spend> spend) {
        for (Map.Entry<Integer, Spend> entry : spend.entrySet()) {
            Spend spend1 = entry.getValue();
            System.out.println("-------------------------------------");
            System.out.println(spend1.getCode());
            System.out.println(spend1.getName());
            System.out.println(spend1.getDate());
            System.out.println(spend1.getAmount());
            System.out.println(spend1.getDescribe());
            System.out.println("-------------------------------------");
        }

    }
}
