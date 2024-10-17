package service.custom;

import model.Employee;

import java.util.List;

public interface EmployeeBo {
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    List<Employee> getEmployee();
    Employee search(String id);
}
