package Test.service;

import Test.model.Student;

import java.util.List;

public interface IStudent {
    void addStudent(Student s);
    List<Student> getAllStudents();
    boolean deleteStudent(int id);

}
