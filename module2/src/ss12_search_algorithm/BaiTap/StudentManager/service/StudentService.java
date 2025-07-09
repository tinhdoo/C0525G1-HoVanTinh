package ss12_search_algorithm.BaiTap.StudentManager.service;


import ss12_search_algorithm.BaiTap.StudentManager.entity.Student;
import ss12_search_algorithm.BaiTap.StudentManager.repository.IStudentRepository;
import ss12_search_algorithm.BaiTap.StudentManager.repository.StudentRepository;

import java.util.List;

import static ss12_search_algorithm.BaiTap.StudentManager.repository.StudentRepository.studentList;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public List<Student> sortByNameThenId() {
        studentList.sort((s1, s2) -> {
            int nameCompare = s1.getName().compareToIgnoreCase(s2.getName());
            if (nameCompare != 0) {
                return nameCompare;
            } else {
                return Long.compare(s1.getCode(), s2.getCode());
            }
        });
        return studentList;
    }


    @Override
    public void add(Student student) {

        studentRepository.add(student);
    }
}
