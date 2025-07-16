package ss12.service;
import ss12.entity.Fruits;
import java.util.Map;

public interface IFruits {
    void add();
    void delete();
    void update();
    void showAllFruits(Map<Integer, Fruits> fruits);
}
