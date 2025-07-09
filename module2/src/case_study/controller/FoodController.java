package case_study.controller;

import case_study.model.Food;
import case_study.service.IFoodService;
import case_study.service.IFoodServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FoodController {
    private IFoodService foodService = new IFoodServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void foodManager() {
        while (true) {
            try {
                System.out.println("\n----------- QUẢN LÝ THỰC ĐƠN -----------");
                System.out.println("1. Xem danh sách món ăn");
                System.out.println("2. Thêm món ăn mới");
                System.out.println("3. Cập nhật thông tin món ăn");
                System.out.println("4. Xoá món ăn");
                System.out.println("5. Tìm kiếm món ăn");
                System.out.println("0. Thoát chương trình");
                System.out.println("----------------------------------------");
                System.out.print(">> Vui lòng chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        showAllFood();
                        break;
                    case 2:
                        addFood();
                        break;
                    case 3:
                        updateFood();
                        break;
                    case 4:
                        deleteFood();
                        break;
                    case 5:
                        searchFood();
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

    private void updateFood() {
        try {
            System.out.print("Nhập ID món cần cập nhật: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Food food = foodService.findById(id);
            if (food == null) {
                System.out.println("Không tìm thấy món ăn với ID: " + id);
                return;
            }

            System.out.println("Thông tin hiện tại:");
            System.out.println(food);
            System.out.println();

            System.out.print("Nhập tên mới (hiện tại: " + food.getName() + "): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) name = food.getName();

            System.out.print("Nhập loại món mới (hiện tại: " + food.getCategory() + "): ");
            String category = scanner.nextLine().trim();
            if (category.isEmpty()) category = food.getCategory();

            System.out.print("Nhập giá mới (hiện tại: " + food.getPricePerPerson() + "): ");
            String priceStr = scanner.nextLine().trim();
            double price = food.getPricePerPerson();

            if (!priceStr.isEmpty()) {
                price = Double.parseDouble(priceStr);
                if (price < 0) {
                    System.out.println("Giá không được âm!");
                    return;
                }
            }

            Food updatedFood = new Food(id, name, category, price);
            boolean success = foodService.updateFood(updatedFood);

            if (success) {
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Cập nhật thất bại!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    private void deleteFood() {
        try {
            System.out.print("Nhập ID món cần xoá: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Food food = foodService.findById(id);
            if (food == null) {
                System.out.println("Không tìm thấy món ăn với ID: " + id);
                return;
            }

            // Hiển thị thông tin món cần xóa
            System.out.println("Thông tin món sẽ bị xóa:");
            System.out.println(food);

            // Xác nhận xóa
            System.out.print("Bạn có chắc chắn muốn xóa món này? (y/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("y") || confirm.equals("yes")) {
                boolean removed = foodService.removeById(id);
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

    private void searchFood() {
        try {
            System.out.print("Nhập tên món cần tìm: ");
            String keyword = scanner.nextLine().trim();

            if (keyword.isEmpty()) {
                System.out.println("Vui lòng nhập từ khóa tìm kiếm!");
                return;
            }

            List<Food> result = foodService.searchByName(keyword);
            if (result.isEmpty()) {
                System.out.println("Không tìm thấy món nào phù hợp với từ khóa: " + keyword);
                System.out.println("Gợi ý: Hãy thử tìm kiếm với từ khóa khác hoặc ngắn hơn.");
            } else {
                System.out.println("Tìm thấy " + result.size() + " món phù hợp:");
                System.out.println("+-------+----------------------+-----------------+------------+");
                System.out.println("|  ID   | Tên món              | Loại            |    Giá     |");
                System.out.println("+-------+----------------------+-----------------+------------+");
                for (Food food : result) {
                    System.out.println(food);
                }
                System.out.println("+-------+----------------------+-----------------+------------+");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi tìm kiếm: " + e.getMessage());
        }
    }

    private void addFood() {
        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            // Kiểm tra ID đã tồn tại
            if (foodService.findById(id) != null) {
                System.out.println("ID " + id + " đã tồn tại! Vui lòng chọn ID khác.");
                return;
            }

            System.out.print("Nhập tên món: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên món không được để trống!");
                return;
            }

            System.out.print("Nhập loại món: ");
            String category = scanner.nextLine().trim();
            if (category.isEmpty()) {
                System.out.println("Loại món không được để trống!");
                return;
            }

            System.out.print("Nhập giá: ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            if (price < 0) {
                System.out.println("Giá không được âm!");
                return;
            }

            Food food = new Food(id, name, category, price);
            foodService.addFood(food);

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ cho ID và giá!");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm món: " + e.getMessage());
        }
    }

    private void showAllFood() {
        try {
            List<Food> foodList = foodService.getAll();
            if (foodList.isEmpty()) {
                System.out.println("Chưa có món ăn nào trong thực đơn.");
            } else {
                foodList.sort(Comparator.comparingInt(Food::getId)); // Sắp xếp theo ID

                System.out.println("Danh sách món ăn (Tổng: " + foodList.size() + " món):");
                System.out.println("+-------+----------------------+-----------------+------------+");
                System.out.println("|  ID   | Tên món              | Loại            |    Giá     |");
                System.out.println("+-------+----------------------+-----------------+------------+");
                for (Food food : foodList) {
                    System.out.printf("| %-5d | %-20s | %-15s | %,10.0f |\n",
                            food.getId(), food.getName(), food.getCategory(), food.getPricePerPerson());
                }
                System.out.println("+-------+----------------------+-----------------+------------+");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách: " + e.getMessage());
        }
    }

}
