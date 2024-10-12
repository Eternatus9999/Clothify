package service.custom;

import entity.EmployeeEntity;
import model.Employee;

import java.util.List;

public interface EmployeeBo {
    boolean addEmployee(Employee employee);

    List<EmployeeEntity> getEmployee();
}
