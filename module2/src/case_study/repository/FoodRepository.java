package case_study.repository;

import case_study.model.Food;
import case_study.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    private static final String FILE_PATH = "src/case_study/data/food.csv";
    private List<Food> foodList = new ArrayList<>();

    public FoodRepository() {
        loadFromFile();
    }

    public void addFood(Food food) {
        foodList.add(food);
        saveToFile();
        System.out.println("Đã thêm món ăn thành công!");
    }

    public boolean updateFood(Food food) {
        int size = foodList.size();
        for (int i = 0; i < size; i++) {
            if (foodList.get(i).getId() == food.getId()) {
                foodList.set(i, food);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public List<Food> getAll() {
        return foodList;
    }

    public boolean removeById(int id) {
        // Tìm và xóa món ăn có ID tương ứng
        int size = foodList.size();
        for (int i = 0; i < size; i++) {
            if (foodList.get(i).getId() == id) {
                foodList.remove(i);
                saveToFile();
                return true;
            }
        }
        return false; // Trả về false nếu không tìm thấy món ăn để xóa
    }


    public Food findById(int id) {
        for (Food food : foodList) {
            if (food.getId() == id) return food;
        }
        return null;
    }

    public List<Food> searchByName(String keyword) {
        List<Food> result = new ArrayList<>();
        String searchTerm = keyword.toLowerCase().trim();

        for (Food food : foodList) {
            String foodName = food.getName().toLowerCase();

            // Tìm kiếm chính xác
            if (foodName.contains(searchTerm)) {
                result.add(food);
            }
            // Tìm kiếm gần đúng - kiểm tra từng từ
            else if (fuzzyMatch(foodName, searchTerm)) {
                result.add(food);
            }
        }
        return result;
    }

    // Thuật toán tìm kiếm gần đúng đơn giản
    private boolean fuzzyMatch(String text, String pattern) {
        String[] patternWords = pattern.split("\\s+");
        for (String word : patternWords) {
            if (word.length() >= 2 && text.contains(word)) {
                return true;
            }
        }

        // Kiểm tra độ tương đồng ký tự (Levenshtein distance đơn giản)
        if (pattern.length() >= 3) {
            return calculateSimilarity(text, pattern) > 0.6;
        }

        return false;
    }

    private double calculateSimilarity(String s1, String s2) {
        int longer = Math.max(s1.length(), s2.length());
        if (longer == 0) return 1.0;
        return (longer - editDistance(s1, s2)) / (double) longer;
    }

    private int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }

    private void loadFromFile() {
        try {
            List<String> lines = FileUtil.readFile(FILE_PATH);
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        String category = parts[2].trim();
                        double price = Double.parseDouble(parts[3].trim());
                        foodList.add(new Food(id, name, category, price));
                    } catch (NumberFormatException e) {
                        System.err.println("Dữ liệu không hợp lệ trong file: " + line);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tải dữ liệu từ file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try {
            List<String> lines = new ArrayList<>();
            for (Food food : foodList) {
                lines.add(food.getId() + "," + food.getName() + "," +
                        food.getCategory() + "," + food.getPricePerPerson());
            }
            FileUtil.writeFile(FILE_PATH, lines);
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }
}
