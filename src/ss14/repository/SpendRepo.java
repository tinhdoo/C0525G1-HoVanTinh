package ss14.repository;

import ss14.entity.Spend;

import java.time.LocalDate;
import java.util.*;

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

    public void update(int code, Spend spend) {
        listSpend.replace(code, spend);
    }

    public Spend searchByCode(int code) {
        Spend spend = listSpend.get(code);
        return spend;
    }

    public Map<Integer, Spend> searchByName(String name) {
        Map<Integer, Spend> result = new HashMap<>();
        for (Map.Entry<Integer, Spend> entry : listSpend.entrySet()) {
            if (entry.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
    public List<Spend> sortByNameAsc() {
        List<Spend> sortedList = new ArrayList<>(listSpend.values());

        sortedList.sort(Comparator.comparing(Spend::getName));

        return sortedList;
    }

    public List<Spend> sortByAmountDescThenNameAsc() {
        List<Spend> sortedList = new ArrayList<>(listSpend.values());
        sortedList.sort(Comparator.comparing(Spend::getAmount).reversed().thenComparing(Spend::getName));
        return sortedList;
    }


    public boolean isCodeExist(int code) {
        for (Spend spend : listSpend.values()) {
            if (spend.getCode() == code) {
                return true;
            }
        }
        return false;
    }
}
