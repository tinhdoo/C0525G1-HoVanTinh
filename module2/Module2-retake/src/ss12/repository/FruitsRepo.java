package ss12.repository;

import ss12.model.Fruits;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FruitsRepo {
    Scanner scanner = new Scanner(System.in);
    private final Map<Integer, Fruits> fruits = new HashMap<>();

    public FruitsRepo() {
        fruits.put(1, new Fruits(1, "Táo", "Ngọt", LocalDate.now(), LocalDate.now().plusDays(11), "Việt Nam", 15000));
        fruits.put(2, new Fruits(2, "Cam", "Chua", LocalDate.now(), LocalDate.now().plusDays(10), "Mỹ", 20000));
    }

    public Map<Integer, Fruits> getAll() {
        return fruits;
    }

    public void addFruit(int id, Fruits fruit) {
        fruits.put(fruit.getId(), fruit);
    }
    public void updateFruit(){

        System.out.println("Nhập id cần xoá: ");
        int id = scanner.nextInt();
        if (isIdExist(id)) {
            System.out.println("Nhập tên: ");
            String name = scanner.nextLine();
            fruits.getName() = name;
        }else {
            System.out.println("Id không tồn tại!");
        }
    }

    public void deleteFruit() {
        System.out.println("Nhập id cần xoá: ");
        int id = scanner.nextInt();
        if (isIdExist(id)) {
            fruits.remove(id);
            System.out.println("Xoá thành công!");
        }else {
            System.out.println("Id không tồn tại!");
        }
    }

    public boolean isIdExist (int id) {
        for (Map.Entry<Integer, Fruits> entry : fruits.entrySet()) {
            if (entry.getKey() == id) {
                return true;
            }
        }
        return false;
    }
}

