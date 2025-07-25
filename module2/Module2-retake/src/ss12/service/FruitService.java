package ss12.service;

import ss12.entity.Fruits;
import ss12.repository.FruitsRepo;

import java.util.Collection;
import java.util.Map;

public class FruitService implements IFruits {
    FruitsRepo repo = new FruitsRepo();

    @Override
    public Fruits add(Fruits fruit) {
           return repo.add(fruit);
    }

    @Override
    public void delete(int id) {
            repo.delete(id);
    }

    @Override
    public Fruits update(int id, Fruits fruit) {
        return repo.update(id, fruit);
    }

    @Override
    public Collection<Fruits> getAllFruits() {
        return repo.getAllFruits();
    }

}
