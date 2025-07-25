package ss12.service;
import ss12.entity.Fruits;

import java.util.Collection;
import java.util.Map;

public interface IFruits {
    Fruits add(Fruits fruit);
    void delete(int id);
    Fruits update(int id, Fruits fruits);
    Collection<Fruits> getAllFruits();
}
