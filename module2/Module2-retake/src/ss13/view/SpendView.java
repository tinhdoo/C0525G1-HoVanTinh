package ss13.view;

import ss13.controller.SpendController;
import ss13.entity.Spend;
import ss13.repository.SpendRepo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class SpendView {
    private Scanner scanner = new Scanner(System.in);
    private SpendController controller = new SpendController();

    public void menuSpend() {
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Danh sách chi tiêu");
            System.out.println("2. Thêm chi tiêu");
            System.out.println("3. Xoá chi tiêu");
            System.out.println("4. Sửa chi tiêu");
            System.out.println("5. Tìm kiếm theo mã");
            System.out.println("6. Tìm kiếm gần đúng theo tên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1 -> getAll();
                case 2 -> {
                    add();
                }
                case 3 -> {
                    delete();
                }
                case 4 -> {
                    update();
                }
                case 5 -> {
                    searchByCode();
                }
                case 6 -> {
                    searchByname();
                }
                case 0 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }
    private void searchByname() {
        System.out.println("====TÌM CHI TIÊU THEO TÊN====");
        scanner.nextLine(); // Đọc bỏ dòng thừa
        System.out.print("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        Collection<Spend> result = controller.searchByName(name); // Trả về kết quả
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            displaySpend(result); // Gọi View để hiển thị
        }
    }

    private void searchByCode() {
        System.out.println("====TÌM CHI TIÊU THEO MÃ====");
        System.out.print("Nhập mã cần tìm: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        Spend spend = controller.searchByCode(code); // Trả về đối tượng
        if (spend == null) {
            System.out.println("Không tìm thấy mã này!");
        } else {
            display(spend);
        }
    }

    private void getAll() {
        Collection<Spend> spends = controller.getAll();
        if (spends.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            displaySpend(spends);
        }
    }

    private void add() {
        System.out.println("====THÊM CHI TIÊU====");
        System.out.print("Nhập mã chi tiêu: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        Spend spend = input(code);
        boolean added = controller.add(spend); // truyền vào từ view
        if (added) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Mã đã tồn tại!");
        }
    }

    private void delete() {
        System.out.println("====XOÁ CHI TIÊU====");
        System.out.print("Nhập mã chi tiêu cần xoá: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        boolean deleted = controller.delete(code);
        if (deleted) {
            System.out.println("Xoá thành công!");
        } else {
            System.out.println("Không tìm thấy mã!");
        }
    }

    private void update() {
        System.out.println("====SỬA CHI TIÊU====");
        System.out.print("Nhập mã cần sửa: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        Spend spend = input(code);
        boolean updated = controller.update(spend);
        if (updated) {
            System.out.println("Sửa thành công!");
        } else {
            System.out.println("Không tìm thấy mã!");
        }
    }

    public Spend input(int code) {
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

    public void displaySpend(Collection<Spend> spends) {
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

    public void display(Spend spend) {
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
