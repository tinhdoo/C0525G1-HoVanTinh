package ss12.repository;

import ss12.entity.Fruits;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class FruitsRepo {
    public final Map<Integer, Fruits> fruits = new HashMap<>();

    public FruitsRepo() {
        fruits.put(1, new Fruits(1, "Táo", "Ngọt", LocalDate.now(), LocalDate.now().plusDays(11), "Việt Nam", 15000));
        fruits.put(2, new Fruits(2, "Cam", "Chua", LocalDate.now(), LocalDate.now().plusDays(10), "Mỹ", 20000));
    }

    public boolean isIdExist(int id) {
        for (Map.Entry<Integer, Fruits> entry : fruits.entrySet()) {
            if (entry.getKey() == id) {
                return true;
            }
        }
        return false;
    }

    public Fruits add(Fruits fruit) {
        return fruits.put(fruit.getId(),fruit);
    }
    public Fruits update(int id, Fruits fruit){
        return fruits.replace(id, fruit);
    }

    public void delete(int id) {
        fruits.remove(id);
    }

    public Collection<Fruits> getAllFruits() {
        return fruits.values();
    }
}