package ss12_search_algorithm.BaiTap.StudentManager.service;

import ss12_search_algorithm.BaiTap.StudentManager.entity.Student;

import java.util.List;

public interface IStudentService  {
    List<Student> findAll();
    List<Student> sortByNameThenId();

    void add(Student student);
}
