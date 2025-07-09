package case_study.repository;

import case_study.model.Employee;
import case_study.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final String FILE_PATH = "src/case_study/data/employee.csv";
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepository() {
        loadFromFile();
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("Đã thêm nhân viên thành công!");
    }

    public boolean updateEmployee(Employee emp) {
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            if (employeeList.get(i).getId() == emp.getId()) {
                employeeList.set(i, emp);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public List<Employee> getAll() {
        return employeeList;
    }

    public boolean removeById(int id) {
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(i);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public Employee findById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) return emp;
        }
        return null;
    }

    public List<Employee> searchByName(String keyword) {
        List<Employee> result = new ArrayList<>();
        String searchTerm = keyword.toLowerCase().trim();

        for (Employee emp : employeeList) {
            String empName = emp.getName().toLowerCase();

            if (empName.contains(searchTerm)) {
                result.add(emp);
            } else if (fuzzyMatch(empName, searchTerm)) {
                result.add(emp);
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
            return calculateSimilariry(text, pattern) > 0.6;
        }
        return false;
    }

    private double calculateSimilariry(String s1, String s2) {
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
                if (parts.length == 7) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        String role = parts[2].trim();
                        boolean gender = parts[3].trim().equalsIgnoreCase("Nam");
                        int age = Integer.parseInt(parts[4].trim());
                        String phone = parts[5].trim();
                        double salary = Double.parseDouble(parts[6].trim());
                        employeeList.add(new Employee(id, name, role, gender, age, phone, salary));
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
            for (Employee emp : employeeList) {
                lines.add(emp.getId() + "," + emp.getName() + "," +
                        emp.getRole() + "," + emp.getGender() + "," +
                        emp.getAge() + "," + emp.getPhone() + "," +
                        emp.getSalary());
            }
            FileUtil.writeFile(FILE_PATH, lines);
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }

}

