package case_study.controller;

import case_study.model.Employee;
import case_study.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeRepository empRepo = new EmployeeRepository();
    private Scanner scanner = new Scanner(System.in);

    public void displayEmployee() {
        while (true) {
            try {
                System.out.println("\n----------- QUẢN LÝ NHÂN VIÊN -----------");
                System.out.println("1. Xem danh sách nhân viên");
                System.out.println("2. Thêm nhân viên");
                System.out.println("3. Xoá nhân viên");
                System.out.println("4. Sửa thông tin");
                System.out.println("5. Tìm kiếm nhân viên");
                System.out.println("0. Thoát");
                System.out.println("----------------------------------------");
                System.out.print(">> Vui lòng chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        showAllEmployees();
                        break;
                    case 2:
                        addEmployee();
                        break;
                    case 3:
                        deleteEmployee();
                        break;
                    case 4:
                        updateEmployee();
                        break;
                    case 5:
                        searchEmployee();
                        break;
                    case 0:
                        System.out.println("Quay lại menu chính");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }

    private void showAllEmployees() {
        try {
            List<Employee> empList = empRepo.getAll();

            if (empList.isEmpty()) {
                System.out.println("Chưa có nhân viên nào.");
            } else {
                empList.sort(Comparator.comparingInt(Employee::getId));

                System.out.println("Danh sách nhân viên (Tổng: " + empList.size() + " người):");
                System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
                System.out.println("|  ID   | Tên nhân viên        | Chức vụ         | Giới  | Tuổi | Điện thoại   |   Lương    |");
                System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
                for (Employee emp : empList) {
                    System.out.println(emp);
                }
                System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách: " + e.getMessage());
        }
    }


    private void addEmployee() {
        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (empRepo.findById(id) != null) {
                System.out.println("ID đã tồn tại!");
                return;
            }

            System.out.print("Nhập tên nhân viên: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên không được để trống!");
                return;
            }

            System.out.print("Nhập chức vụ: ");
            String role = scanner.nextLine().trim();
            if (role.isEmpty()) {
                System.out.println("Chức vụ không được để trống!");
                return;
            }

            System.out.print("Nhập giới tính (1-Nam, 0-Nữ): ");
            int genderInput = Integer.parseInt(scanner.nextLine().trim());
            if (genderInput != 0 && genderInput != 1) {
                System.out.println("Chỉ nhập 1 (Nam) hoặc 0 (Nữ).");
                return;
            }
            boolean gender = (genderInput == 1);

            System.out.print("Nhập tuổi: ");
            int age = Integer.parseInt(scanner.nextLine().trim());
            if (age <= 0) {
                System.out.println("Tuổi phải > 0.");
                return;
            }

            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine().trim();
            if (!phone.matches("\\d{9,11}")) {
                System.out.println("Số điện thoại không hợp lệ (9-11 chữ số).");
                return;
            }

            System.out.print("Nhập lương: ");
            double salary = Double.parseDouble(scanner.nextLine().trim());
            if (salary < 0) {
                System.out.println("Lương không được âm!");
                return;
            }

            Employee emp = new Employee(id, name, role, gender, age, phone, salary);
            empRepo.addEmployee(emp);

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập đúng định dạng số!");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm nhân viên: " + e.getMessage());
        }
    }


    private void deleteEmployee() {
        try {
            System.out.print("Nhập ID nhân viên cần xoá: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Employee emp = empRepo.findById(id);
            if (emp == null) {
                System.out.println("Không tìm thấy nhân viên với ID: " + id);
                return;
            }

            System.out.println("Thông tin nhân viên sẽ bị xóa:");
            System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
            System.out.println("|  ID   | Tên nhân viên        | Chức vụ         | Giới  | Tuổi | Điện thoại   |   Lương    |");
            System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
            System.out.println(emp);
            System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");

            System.out.print("Bạn có chắc chắn muốn xóa nhân viên này? (y/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("y") || confirm.equals("yes")) {
                boolean removed = empRepo.removeById(id);
                if (removed) {
                    System.out.println("Xoá nhân viên thành công!");
                } else {
                    System.out.println("Xoá nhân viên thất bại!");
                }
            } else {
                System.out.println("Đã hủy thao tác xóa.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập ID hợp lệ!");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa nhân viên: " + e.getMessage());
        }
    }

    private void updateEmployee() {
        try {
            System.out.print("Nhập ID nhân viên cần cập nhật: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Employee emp = empRepo.findById(id);
            if (emp == null) {
                System.out.println("Không tìm thấy nhân viên với ID: " + id);
                return;
            }

            System.out.println("Thông tin hiện tại:");
            System.out.println(emp);
            System.out.println();

            // Tên
            System.out.print("Nhập tên mới (hiện tại: " + emp.getName() + "): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) name = emp.getName();

            // Chức vụ
            System.out.print("Nhập chức vụ mới (hiện tại: " + emp.getRole() + "): ");
            String role = scanner.nextLine().trim();
            if (role.isEmpty()) role = emp.getRole();

            // Giới tính
            System.out.print("Nhập giới tính mới (1-Nam, 0-Nữ, hiện tại: " + emp.getGender() + "): ");
            String genderStr = scanner.nextLine().trim();
            boolean gender = emp.isGender();
            if (!genderStr.isEmpty()) {
                int genderInput = Integer.parseInt(genderStr);
                if (genderInput != 0 && genderInput != 1) {
                    System.out.println("Giới tính chỉ nhận 0 (Nữ) hoặc 1 (Nam).");
                    return;
                }
                gender = (genderInput == 1);
            }

            // Tuổi
            System.out.print("Nhập tuổi mới (hiện tại: " + emp.getAge() + "): ");
            String ageStr = scanner.nextLine().trim();
            int age = emp.getAge();
            if (!ageStr.isEmpty()) {
                age = Integer.parseInt(ageStr);
                if (age <= 0) {
                    System.out.println("Tuổi phải > 0.");
                    return;
                }
            }

            // Điện thoại
            System.out.print("Nhập số điện thoại mới (hiện tại: " + emp.getPhone() + "): ");
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) phone = emp.getPhone();
            else if (!phone.matches("\\d{9,11}")) {
                System.out.println("Số điện thoại phải từ 9–11 chữ số.");
                return;
            }

            // Lương
            System.out.print("Nhập lương mới (hiện tại: " + emp.getSalary() + "): ");
            String salaryStr = scanner.nextLine().trim();
            double salary = emp.getSalary();
            if (!salaryStr.isEmpty()) {
                salary = Double.parseDouble(salaryStr);
                if (salary < 0) {
                    System.out.println("Lương không được âm!");
                    return;
                }
            }

            Employee updatedEmp = new Employee(id, name, role, gender, age, phone, salary);
            boolean success = empRepo.updateEmployee(updatedEmp);

            System.out.println(success ? "Cập nhật thành công!" : "Cập nhật thất bại!");

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập đúng định dạng số!");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật: " + e.getMessage());
        }
    }


    private void searchEmployee() {
        try {
            System.out.print("Nhập tên nhân viên cần tìm: ");
            String keyword = scanner.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println("Vui lòng nhập từ khóa tìm kiếm!");
                return;
            }

            List<Employee> result = empRepo.searchByName(keyword);
            if (result.isEmpty()) {
                System.out.println("Không tìm thấy nhân viên nào phù hợp với từ khóa: " + keyword);
            } else {
                System.out.println("Tìm thấy " + result.size() + " nhân viên phù hợp:");
                System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
                System.out.println("|  ID   | Tên nhân viên        | Chức vụ         | Giới  | Tuổi | Điện thoại   |   Lương    |");
                System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
                for (Employee emp : result) {
                    System.out.println(emp);
                }
                System.out.println("+-------+----------------------+-----------------+-------+------+--------------+------------+");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi tìm kiếm: " + e.getMessage());
        }
    }
}
