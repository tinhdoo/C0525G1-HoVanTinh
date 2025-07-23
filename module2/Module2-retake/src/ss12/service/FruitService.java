package ss12.service;

import ss12.entity.Fruits;
import ss12.view.FruitsView;
import java.util.Map;
import static ss12.controller.FruitsController.repo;

public class FruitService implements IFruits {

    @Override
    public void add(int id) {

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
    public void delete(int id) {

        if (repo.isIdExist(id)) {
            repo.fruits.remove(id);
            System.out.println("Xoá thành công!");
        } else {
            System.out.println("Id không tồn tại!");
            System.out.println("-----------------");

        }
    }

    @Override
    public void update(int id) {
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
    public Map<Integer, Fruits> getAllFruits() {
        return repo.fruits;
    }

}
