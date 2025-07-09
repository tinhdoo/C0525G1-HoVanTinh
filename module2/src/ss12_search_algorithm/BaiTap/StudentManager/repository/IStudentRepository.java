package ss12_search_algorithm.BaiTap.StudentManager.repository;

import ss12_search_algorithm.BaiTap.StudentManager.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void add(Student student);
}
