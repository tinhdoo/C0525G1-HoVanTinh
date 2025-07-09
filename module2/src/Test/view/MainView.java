package Test.view;

import Test.controller.StudentController;
import Test.model.Student;
import java.util.Scanner;

public class MainView {
        private final StudentController controller = new StudentController();
        private final Scanner scanner = new Scanner(System.in);

        public void displayMenu() {
            while (true) {
                System.out.println("--- MENU ---");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Hiển thị danh sách");
                System.out.println("3. Xóa sinh viên theo ID");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> add();
                    case 2 -> show();
                    case 3 -> delete();
                    case 0 -> {
                        System.out.println("Tạm biệt!");
                        return;
                    }
                    default -> System.out.println("Chọn sai!");
                }
            }
        }

        private void add() {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Tên: ");
            String name = scanner.nextLine();
            System.out.print("Tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());
            controller.addStudent(id, name, age);
            System.out.println("✅ Đã thêm!");
        }

        private void show() {
            for (Student s : controller.getAllStudents()) {
                System.out.println(s);
            }
        }

        private void delete() {
            System.out.print("Nhập ID để xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (controller.deleteStudent(id)) {
                System.out.println("✅ Đã xóa!");
            } else {
                System.out.println("❌ Không tìm thấy!");
            }
        }
    }

