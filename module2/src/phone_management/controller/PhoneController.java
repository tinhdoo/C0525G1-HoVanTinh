package phone_management.controller;

import phone_management.model.Phone;
import phone_management.service.IPhoneService;
import phone_management.service.IPhoneServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PhoneController {
    private IPhoneService phoneService = new IPhoneServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void phoneManager() {
        while (true) {
            try {
                System.out.println("\n--- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI ---");
                System.out.println("1. Thêm mới");
                System.out.println("2. Xoá");
                System.out.println("3. Xem danh sách điện thoại");
                System.out.println("4. Tìm kiếm");
                System.out.println("0. Thoát");
                System.out.print(">> Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        addPhone();
                        break;
                    case 2:
                        deletePhone();
                        break;
                    case 3:
                        showAllPhone();
                        break;
                    case 4:
                        searchPhone();
                        break;
                    case 0:
                        System.out.println("Tạm biệt!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }

    public void addPhone() {
        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (phoneService.findById(id) != null) {
                System.out.println("ID " + id + " đã tồn tại! Vui lòng chọn ID khác.");
                return;
            }

            System.out.print("Nhập tên: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên không được để trống!");
                return;
            }

            System.out.print("Nhập giá: ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            if (price < 0) {
                System.out.println("Giá không được âm!");
                return;
            }

            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine().trim());
            if (quantity < 0) {
                System.out.println("Số lượng không được âm!");
                return;
            }

            System.out.print("Nhập nhà sản xuất: ");
            String manufacturer = scanner.nextLine().trim();
            if (manufacturer.isEmpty()) {
                System.out.println("Nhà sản xuất không được để trống!");
                return;
            }

            Phone phone = new Phone(id, name, price, quantity, manufacturer);
            phoneService.addPhone(phone);

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ cho ID, giá và số lượng!");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm: " + e.getMessage());
        }
    }

    private void deletePhone() {
        try {
            System.out.print("Nhập ID điện thoại cần xoá: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Phone phone = phoneService.findById(id);
            if (phone == null) {
                System.out.println("Không tìm thấy điện thoại với ID: " + id);
                return;
            }

            System.out.println("Thông tin điện thoại sẽ bị xóa:");
            System.out.println(phone);

            System.out.print("Bạn có chắc chắn muốn xóa? (y/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("y") || confirm.equals("yes")) {
                boolean removed = phoneService.removeById(id);
                if (removed) {
                    System.out.println("Xoá thành công!");
                } else {
                    System.out.println("Xoá thất bại!");
                }
            } else {
                System.out.println("Đã hủy thao tác xóa.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập ID hợp lệ!");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa: " + e.getMessage());
        }
    }

    private void showAllPhone() {
        try {
            List<Phone> phoneList = phoneService.getAll();
            if (phoneList.isEmpty()) {
                System.out.println("Chưa có điện thoại nào.");
            } else {
                phoneList.sort(Comparator.comparingInt(Phone::getId));
                for (Phone phone : phoneList) {
                    System.out.println(phone);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách: " + e.getMessage());
        }
    }

    private void searchPhone() {
        try {
            System.out.print("Nhập tên điện thoại cần tìm: ");
            String keyword = scanner.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println("Vui lòng nhập từ khóa tìm kiếm!");
                return;
            }

            List<Phone> result = phoneService.searchByName(keyword);
            if (result.isEmpty()) {
                System.out.println("Không tìm thấy điện thoại nào phù hợp với từ khóa: " + keyword);
            } else {
                System.out.println("Tìm thấy " + result.size() + " kết quả:");
                for (Phone phone : result) {
                    System.out.println(phone);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi tìm kiếm: " + e.getMessage());
        }
    }
}
