package case_study.service;

import case_study.model.Food;
import case_study.repository.FoodRepository;

import java.util.List;

public class IFoodServiceImpl implements IFoodService {
    private FoodRepository foodRepo = new FoodRepository();

    @Override
    public void addFood(Food food) {
        foodRepo.addFood(food);
    }

    @Override
    public List<Food> getAll() {
        return foodRepo.getAll();
    }

    @Override
    public List<Food> searchByName(String keyword) {
        return foodRepo.searchByName(keyword);
    }

    @Override
    public boolean removeById(int id) {
        return foodRepo.removeById(id);
    }

    @Override
    public Food findById(int id) {
        return foodRepo.findById(id);
    }

    @Override
    public boolean updateFood(Food food) {
        return foodRepo.updateFood(food);
    }
}
