package ss10.service;

import ss10.model.Fruit;
import ss10.repository.FruitRepo;
import ss10.view.FruitsView;
import static ss10.repository.FruitRepo.fruits;

public class FruitService implements IFruits {
    FruitRepo repo = new FruitRepo();
    @Override
    public void add() {
        Fruit fruit = FruitsView.input();
        fruits.add(fruit);
    }

    @Override
    public void showAll() {
        if (fruits.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
         FruitsView.displayFruits(fruits);
        }
    }

