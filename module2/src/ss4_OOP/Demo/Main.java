package ss4_OOP.Demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        Student student = new Student(1, "HaiTT", "123456789", localDate, "QN", true);
//        Student student2 = new Student();
//        displayStudent(student);
        Student student3 = createStudent();
        displayStudent(student3);

    }

    public static void displayStudent(Student student) {
        System.out.printf("| %-10s | %-20s | %-15s | %-12s | %-20s | %-10s |\n",
                "Code", "Name", "Phone", "DOB", "Address", "Gender");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println(student.toString());
    }

    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student code: ");
        long code = Long.parseLong(scanner.nextLine());
//        Check các trường hợp
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter student dob: ");
        String dob = scanner.nextLine();
        LocalDate temp = LocalDate.parse(dob);
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();
        System.out.println("Enter student gender: ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Khác");
        int gender = scanner.nextLine().charAt(0) - '0';
        Boolean genderResult;
        if (gender == 1) {
            genderResult = false;
        } else if (gender == 2) {
            genderResult = true;
        } else {
            genderResult = null;
        }

        return new Student(code, name, phone, temp, address, genderResult);
    }
}
