package ss12.service;
import ss12.entity.Fruits;
import java.util.Map;

public interface IFruits {
    Fruits add(int id);
    void delete(int id);
    Fruits update(int id, Fruits fruits);
    Map<Integer, Fruits> getAllFruits();
}
