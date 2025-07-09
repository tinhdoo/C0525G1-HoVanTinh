package ss5_access_modifier.ThucHanh;

import ss5_access_modifier.ThucHanh.Student;

public class Main_1 {
    public static void main(String[] args) {
        Student.change();

        //creating objects
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        //calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}

