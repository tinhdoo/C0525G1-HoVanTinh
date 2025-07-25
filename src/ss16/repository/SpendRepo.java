package ss16.repository;

import ss16.entity.Spend;

import java.io.*;
import java.util.*;

public class SpendRepo {
    public Map<Integer, Spend> listSpend = new HashMap<>();

    public void add(Spend spend) {
        listSpend.put(spend.getCode(), spend);
        File file = new File("src/ss16/data/writerll.csv");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = spend.getCode() + "," + spend.getName() + "," + spend.getDate() + "," + spend.getAmount() + "," + spend.getDescribe();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Lỗi đọc ghi: " + e.getMessage());
        }
    }

    public void findAll() {
        try {
            FileReader fileReader = new FileReader(new File("src/ss16/data/writerll.csv"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file!");
        }
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
