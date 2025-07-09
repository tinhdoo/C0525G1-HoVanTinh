package ss16_binary_file_serialization.ThucHanh.ReadAndWriteStudentListToBinaryFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeDataToFile(String path, List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Minh Quân", "Đà Nẵng"));
        students.add(new Student(2, "Huy Hoà", "Hà Nội"));
        students.add(new Student(3, "Khánh Tùng", "Đà Nẵng"));
        students.add(new Student(4, "Khắc Nhật", "Hà Nội"));
        writeDataToFile("D:\\Codegym\\module2\\src\\ss16_binary_file_serialization\\ThucHanh\\ReadAndWriteStudentListToBinaryFile\\student.dat", students);
        List<Student> studentDataFromFile = readDataFromFile("D:\\Codegym\\module2\\src\\ss16_binary_file_serialization\\ThucHanh\\ReadAndWriteStudentListToBinaryFile\\student.dat");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
