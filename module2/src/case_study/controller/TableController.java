package case_study.controller;

import case_study.model.Table;
import case_study.service.ITableService;
import case_study.service.TableService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TableController {
    private ITableService tableService = new TableService();
    private Scanner scanner = new Scanner(System.in);

    public void displayTableMenu() {
        while (true) {
            System.out.println("\n------------- QUẢN LÝ BÀN ------------");
            System.out.println("1. Xem danh sách bàn");
            System.out.println("2. Thêm bàn mới");
            System.out.println("3. Xoá bàn theo ID");
            System.out.println("4. Cập nhật bàn");
            System.out.println("0. Thoát");
            System.out.println("----------------------------------------");
            System.out.print(">> Vui lòng chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showAllTable();
                        break;
                    case 2:
                        addTable();
                        break;
                    case 3:
                        deleteTable();
                        break;
                    case 4:
                        updateTable();
                        break;
                    case 0:
                        System.out.println("Quay lại menu chính");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0-4.");

                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ!");
            }
        }
    }

    private void updateTable() {
        try {
            System.out.print("Nhập ID bàn cần cập nhật: ");
            int id = Integer.parseInt(scanner.nextLine());
            Table table = tableService.findTableById(id);
            if (table == null) {
                System.out.println("==================================");
                System.out.println("Không tìm thấy bàn với ID: " + id);
                System.out.println("==================================");
                return;
            }

            System.out.print("Số khách mới: ");
            String numberOfGuestsStr = scanner.nextLine();
            int numberOfGuests = table.getNumberOfGuests();
            if (!numberOfGuestsStr.isEmpty()) {
                numberOfGuests = Integer.parseInt(numberOfGuestsStr);
            }

            System.out.print("Ghi chú mới (hiện tại: " + table.getStatus() + "): ");
            String status = scanner.nextLine().trim();
            if (status.isEmpty()) status = table.getStatus();

            table.setNumberOfGuests(numberOfGuests);
            table.setStatus(status);

            System.out.println("Cập nhật thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập đúng định dạng số.");
        }
    }

    private void deleteTable() {
        try {
            System.out.print("Nhập ID bàn cần xoá: ");
            int id = Integer.parseInt(scanner.nextLine());

            boolean removed = tableService.removeTableById(id);
            if (removed) {
                System.out.println("Xoá bàn thành công!");
            } else {
                System.out.println("=================================");
                System.out.println("Không tìm thấy bàn với ID: " + id);
                System.out.println("=================================");
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID phải là một số.");
        }
    }

    private void addTable() {
        try {
            System.out.print("Nhập ID bàn: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập số lượng khách: ");
            int numberOfGuests = Integer.parseInt(scanner.nextLine());

            System.out.print("Ghi chú: ");
            String status = scanner.nextLine().trim();

            Table table = new Table(id, numberOfGuests, status);
            tableService.addTable(table);

            System.out.println("Đã thêm bàn thành công!");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID và số lượng khách phải là số.");
        }
    }

    private void showAllTable() {
        try {
            List<Table> tableList = tableService.getAllTables();
            if (tableList.isEmpty()) {
                System.out.println("Chưa có bàn nào được thêm.");
            } else {
                tableList.sort(Comparator.comparingInt(Table::getId)); // Sắp xếp theo ID

                System.out.println("Danh sách bàn (Tổng: " + tableList.size() + " bàn):");
                System.out.println("+------+-------------------+----------------------+");
                System.out.println("|  ID  | Số lượng khách    | Ghi chú              |");
                System.out.println("+------+-------------------+----------------------+");
                for (Table table : tableList) {
                    System.out.printf("| %-4d | %-17d | %-20s |\n",
                            table.getId(), table.getNumberOfGuests(), table.getStatus());
                }
                System.out.println("+------+-------------------+----------------------+");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách: " + e.getMessage());
        }
    }

}
