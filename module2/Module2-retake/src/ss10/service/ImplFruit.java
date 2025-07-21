package ss10.service;

import ss10.model.Fruit;
import ss10.repository.FruitRepo;
import ss10.view.Display;

import static ss10.repository.FruitRepo.fruits;

public class ImplFruit implements IFruits {
    FruitRepo repo = new FruitRepo();

    @Override
    public void add() {
        Fruit fruit = Display.input();
        fruits.add(fruit);
        System.out.println("Thêm trái cây thành công!");
    }

    @Override
    public void showAll() {
        if (fruits.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (Fruit fruit : fruits) {
         Display.displayFruits(fruit);
        }
    }

    @Override
    public void choose(int choose) {
        switch (choose) {
            case 1 -> showAll();
            case 2 -> add();
            case 3 -> {
                System.out.println("Tạm biệt!");
                System.exit(0);
            }
            default -> System.out.println("Vui lòng nhập lại!");
        }
    }
}
