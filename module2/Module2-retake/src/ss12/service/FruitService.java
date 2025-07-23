package ss12.service;

import ss12.entity.Fruits;
import ss13.repository.SpendRepo;

import java.util.Map;

public class FruitService implements IFruits {
SpendRepo repo = new SpendRepo();

    @Override
    public Fruits add(int id) {
           return repo.add();
    }

    @Override
    public void delete(int id) {
            repo.delete(id);
    }

    @Override
    public Fruits update(int id, Fruits fruits) {
        return repo.update(id, fruits);
    }

    @Override
    public Map<Integer, Fruits> getAllFruits() {
        return repo.getAllFruits();
    }

}
