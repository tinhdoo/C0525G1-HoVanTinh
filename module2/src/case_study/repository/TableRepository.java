package case_study.repository;

import case_study.model.Table;
import case_study.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TableRepository {
    private static final String FILE_PATH = "src/case_study/data/table.csv";
    private List<Table> tableList = new ArrayList<>();

    public TableRepository() {
        loadFromFile();
    }

    public void addTable(Table table) {
        tableList.add(table);
        System.out.println("Đã thêm bàn thành công!");
        saveToFile();
    }

    public List<Table> getAll() {
        return new ArrayList<>(tableList);
    }

    @Deprecated
    public void displayTable() {
        for (Table table : tableList) {
            System.out.println(table);
        }
    }

    public Table findById(int id) {
        for (Table table : tableList) {
            if (table.getId() == id) {
                return table;
            }
        }
        return null;
    }

    private void loadFromFile() {
        tableList = new ArrayList<>();
        try {
            List<String> lines = FileUtil.readFile(FILE_PATH);
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        int numberOfGuest = Integer.parseInt(parts[1].trim());
                        String status = parts[2].trim();
                        tableList.add(new Table(id, numberOfGuest, status));
                    } catch (NumberFormatException e) {
                        System.err.println("Dữ liệu không hợp lệ trong file (sai định dạng số): " + line);
                    }
                } else {
                    System.err.println("Dữ liệu không hợp lệ trong file (sai số cột): " + line);
                }
            }
        } catch (Exception e) {
            // Không nên để trống, ít nhất phải thông báo lỗi
            System.err.println("Lỗi khi tải dữ liệu từ file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try {
            List<String> lines = new ArrayList<>();
            for (Table table : tableList) {
                lines.add(table.getId() + "," + table.getNumberOfGuests() + "," + table.getStatus());
            }
            FileUtil.writeFile(FILE_PATH, lines);
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }

    public boolean removeById(int id) {
        Iterator<Table> iterator = tableList.iterator();
        while (iterator.hasNext()) {
            Table table = iterator.next();
            if (table.getId() == id) {
                iterator.remove();
                saveToFile();
                System.out.println("Đã xóa bàn có ID: " + id);
                return true;
            }
        }
        System.out.println("Không tìm thấy bàn có ID: " + id);
        return false;
    }
}
