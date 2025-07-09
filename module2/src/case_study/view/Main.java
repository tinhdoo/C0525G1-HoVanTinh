package case_study.view;

import case_study.controller.EmployeeController;
import case_study.controller.FoodController;
import case_study.controller.TableController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FoodController foodController = new FoodController();
        TableController tableController = new TableController();
        EmployeeController employeeController = new EmployeeController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("/===============================================\\");
            System.out.println("|              RESTAURANT MANAGEMENT            |");
            System.out.println("|-----------------------------------------------|");
            System.out.println("| 1. Quản lý thực đơn                           |");
            System.out.println("| 2. Quản lý bàn                                |");
            System.out.println("| 3. Quản lý nhân viên                          |");
            System.out.println("| 0. Thoát                                      |");
            System.out.println("\\===============================================/");
            System.out.print("⮞ Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    foodController.foodManager();
                    break;
                case 2:
                    tableController.displayTableMenu();
                    break;
                case 3:
                    employeeController.displayEmployee();
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
