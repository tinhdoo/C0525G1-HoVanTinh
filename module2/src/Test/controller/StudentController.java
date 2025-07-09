package Test.controller;

import Test.model.Student;
import Test.service.IStudent;
import Test.service.StudentServiceImpl;

import java.util.List;

public class StudentController {

        private final IStudent service = new StudentServiceImpl();

        public void addStudent(int id, String name, int age) {
            Student student = new Student(id, name, age);
            service.addStudent(student);
        }

        public List<Student> getAllStudents() {
            return service.getAllStudents();
        }

        public boolean deleteStudent(int id) {
            return service.deleteStudent(id);
        }
    }

