package phone_management.repository;

import phone_management.model.Phone;
import phone_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {
    private static final String FILE_PATH = "src/phone_management/data/Phone.csv";
    private List<Phone> phoneList = new ArrayList<>();

    public PhoneRepository() {
        loadFromFile();
    }

    public void addPhone(Phone phone) {
        phoneList.add(phone);
        saveToFile();
        System.out.println("Đã thêm món ăn thành công!");
    }
    public List<Phone> getAll() {
        return phoneList;
    }

    public boolean removeById(int id) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getId() == id) {
                phoneList.remove(i);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public Phone findById(int id) {
        for (Phone phone : phoneList) {
            if (phone.getId() == id) return phone;
        }
        return null;
    }

    public List<Phone> searchByName(String keyword) {
        List<Phone> result = new ArrayList<>();
        String searchTerm = keyword.toLowerCase().trim();

        for (Phone phone : phoneList) {
            String phoneName = phone.getName().toLowerCase();
            if (phoneName.contains(searchTerm) || fuzzyMatch(phoneName, searchTerm)) {
                result.add(phone);
            }
        }
        return result;
    }

    private boolean fuzzyMatch(String text, String pattern) {
        String[] patternWords = pattern.split("\\s+");
        for (String word : patternWords) {
            if (word.length() >= 2 && text.contains(word)) {
                return true;
            }
        }

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
                if (i == 0) {
                    costs[j] = j;
                } else if (j > 0) {
                    int newValue = costs[j - 1];
                    if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                        newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                    }
                    costs[j - 1] = lastValue;
                    lastValue = newValue;
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

    private void loadFromFile() {
        phoneList.clear();
        try {
            List<String> lines = FileUtil.readFile(FILE_PATH);
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        double price = Double.parseDouble(parts[2].trim());
                        int quantity = Integer.parseInt(parts[3].trim());
                        String manufacturer = parts[4].trim();
                        phoneList.add(new Phone(id, name, price, quantity, manufacturer));
                    } catch (NumberFormatException e) {
                        System.err.println("Dữ liệu không hợp lệ trong file: " + line);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tải dữ liệu từ file: " + e.getMessage());
            System.err.println("File không tồn tại hoặc không đọc được: " + FILE_PATH);
        }
    }

    private void saveToFile() {
        try {
            List<String> lines = new ArrayList<>();
            for (Phone phone : phoneList) {
                lines.add(phone.getId() + "," + phone.getName() + "," +
                        phone.getPrice() + "," + phone.getQuantity() + "," + phone.getManufacturer());
            }
            FileUtil.writeFile(FILE_PATH, lines);
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }
}
