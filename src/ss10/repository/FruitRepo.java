package ss10.repository;

import ss10.model.Fruit;
import java.time.LocalDate;
import java.util.ArrayList;

public class FruitRepo {
    public static ArrayList<Fruit> fruits = new ArrayList<>();
    public FruitRepo() {
        fruits.add(new Fruit("Ổi", "Ngon", LocalDate.now(), LocalDate.now().plusDays(15), "Nhật Bản", 150000));
        fruits.add(new Fruit("Xoài", "Ngon", LocalDate.now(), LocalDate.now().plusDays(12), "Trung Quốc", 120000));
        fruits.add(new Fruit("Dưa hấu", "Ngon", LocalDate.now(), LocalDate.now().plusDays(10), "Campuchia", 340000));
        fruits.add(new Fruit("Nho", "Ngon", LocalDate.now(), LocalDate.now().plusDays(17), "Mỹ", 200000));
    }
}
