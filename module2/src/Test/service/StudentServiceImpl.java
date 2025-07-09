
package Test.service;

import Test.model.Student;
import Test.repository.StudentRepo;

import java.util.List;

public class StudentServiceImpl implements IStudent {
    private final StudentRepo repo = new StudentRepo();

    @Override
    public void addStudent(Student s) {
        repo.add(s);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public boolean deleteStudent(int id) {
        return repo.delete(id);
    }
}
