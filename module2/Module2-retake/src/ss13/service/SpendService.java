package ss13.service;

import ss13.entity.Spend;
import ss13.repository.SpendRepo;
import ss13.view.SpendView;
import java.util.Scanner;

public class SpendService implements ISpend {
    Scanner scanner = new Scanner(System.in);
    public static final SpendRepo repo = new SpendRepo();

    @Override
    public void add(int code) {
        if (isCodeExist(code)) {
            System.out.println("Mã đã tồn tại!");
            return;
        }
        Spend spend = SpendView.input(code);
        repo.listSpend.put(code, spend);
        System.out.println("Thêm thành công");
    }

    @Override
    public void delete(int code) {

        if (!isCodeExist(code)) {
            System.out.println("Mã không tồn tại!");
            return;
        }
        repo.listSpend.remove(code);
        System.out.println("Xoá thành công!");
    }

    @Override
    public void update(int code) {

        if (!isCodeExist(code)) {
            System.out.println("Mã không tồn tại!");
            return;
        }
        Spend spend = SpendView.input(code);
        repo.listSpend.replace(code, spend);
        System.out.println("Sửa thành công");

    }

    @Override
    public void searchById(int code) {

        Spend spend = repo.listSpend.get(code);
        if (isCodeExist(code)) {
        SpendView.display(spend);
        } else {
            System.out.println("Mã không tồn tại!");
        }
    }

    @Override
    public void searchByname(String name) {
        boolean found = false;
        for (Spend spend : repo.listSpend.values()) {
            if (spend.getName().toLowerCase().contains(name.toLowerCase())) {
                SpendView.display(spend);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy!");
        }
    }


    @Override
    public Boolean isCodeExist(int code) {
        for (Integer codeSpend : repo.listSpend.keySet()) {
            if (codeSpend == code) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void getAll() {
        if (repo.listSpend.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else {
            SpendView.displaySpend(repo.listSpend.values());
        }
    }
}
