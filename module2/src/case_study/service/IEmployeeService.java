package case_study.service;

import case_study.model.Employee;
import java.util.List;

public interface IEmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAll();
    List<Employee> searchByName(String keyword);
    boolean removeById(int id);
    Employee findById(int id);
    boolean updateEmployee(Employee employee);
}
