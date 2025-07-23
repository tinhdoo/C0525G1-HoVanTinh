package ss13.repository;

import ss13.entity.Spend;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpendRepo {
    public Map<Integer, Spend> listSpend = new HashMap<>();

    public SpendRepo() {
        listSpend.put(1, new Spend(1, "Mua sắm", LocalDate.now(), 1000000, "tiền đi chợ"));
        listSpend.put(2, new Spend(2, "Du lịch", LocalDate.now(), 2000000, "tiền đi chơi"));
        listSpend.put(3, new Spend(3, "Học hành", LocalDate.now(), 1300000, "tiền đi học"));
    }

    public void add(Spend spend) {
        listSpend.put(spend.getCode(), spend);
    }

    public Collection<Spend> getAll() {
        return listSpend.values();
    }


    public void delete(int code) {
        listSpend.remove(code);
    }

    public void update(int code) {
        Spend spend = listSpend.get(code);
        if (spend != null) {
            spend.setName(spend.getName() + " (đã cập nhật)");
            listSpend.put(code, spend);
        }
    }

    public void searchByCode(int code) {
        Spend spend = listSpend.get(code);
        if (spend != null) {
            System.out.println(spend);
        } else {
            System.out.println("Không tìm thấy mã " + code);
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Spend spend : listSpend.values()) {
            if (spend.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(spend);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chi tiêu có tên chứa: " + name);
        }
    }

    public boolean isCodeExist(int code) {
        return listSpend.containsKey(code);
    }
}
