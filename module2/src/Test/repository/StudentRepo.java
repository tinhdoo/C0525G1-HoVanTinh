package Test.repository;
import Test.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
        private final String FILE_PATH = "src/Test/data/Student.csv";
        private List<Student> students;

        public StudentRepo() {
            students = readFromCSV();
            if (students == null) students = new ArrayList<>();
        }

    private void writeToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                bw.write(s.getId() + "," + s.getName() + "," + s.getAge());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Student> readFromCSV() {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    list.add(new Student(id, name, age));
                }
            }
        } catch (IOException e) {
            return null;
        }
        return list;
    }


    public void add(Student s) {
        students.add(s);
        writeToCSV();
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public boolean delete(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}

