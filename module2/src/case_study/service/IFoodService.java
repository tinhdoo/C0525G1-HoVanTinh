package case_study.service;

import case_study.model.Food;
import java.util.List;

public interface IFoodService {
    void addFood(Food food);
    List<Food> getAll();
    List<Food> searchByName(String keyword);
    boolean removeById(int id);
    Food findById(int id);
    boolean updateFood(Food food); // Thêm method update
}
