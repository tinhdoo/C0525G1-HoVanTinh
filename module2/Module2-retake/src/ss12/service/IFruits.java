package ss12.service;
import ss12.entity.Fruits;
import java.util.Map;

public interface IFruits {
    void add(int id);
    void delete(int id);
    void update(int id);
    Map<Integer, Fruits> getAllFruits();
}
