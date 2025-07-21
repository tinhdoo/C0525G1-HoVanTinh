package ss12.service;

import ss12.entity.Fruits;
import ss12.view.FruitsView;
import java.util.Map;
import java.util.Scanner;
import static ss12.controller.FruitsController.repo;

public class ImplFruits implements IFruits {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("-----THÊM TRÁI CÂY-----");
        System.out.print("Nhập id: ");
        int id = scanner.nextInt();
        if (repo.isIdExist(id)) {
            System.out.println("Id đã tồn tại!");
            System.out.println("-----------------------");
        } else {
            Fruits newFruits = FruitsView.input(id);
            repo.fruits.put(id, newFruits);
            System.out.println("Thêm thành công!");
        }
    }

    @Override
    public void delete() {
        System.out.println("-----XOÁ TRÁI CÂY-----");

        System.out.println("Nhập id cần xoá: ");
        int id = scanner.nextInt();
        if (repo.isIdExist(id)) {
            repo.fruits.remove(id);
            System.out.println("Xoá thành công!");
        } else {
            System.out.println("Id không tồn tại!");
            System.out.println("-----------------");

        }
    }

    @Override
    public void update() {
        System.out.println("-----SỬA THÔNG TIN TRÁI CÂY-----");
        System.out.print("Nhập id cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (repo.isIdExist(id)) {
            Fruits fruits = FruitsView.input(id);
            repo.fruits.replace(id, fruits);
            System.out.println("Sửa thành công!");
        } else {
            System.out.println("Id không tồn tại!");
            System.out.println("-----------------");
        }
    }

    @Override
    public void showAllFruits(Map<Integer, Fruits> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("Danh sách trái cây trống.");
            return;
        } else {
            FruitsView.displayFruitsII(fruits);
        }
    }

}
