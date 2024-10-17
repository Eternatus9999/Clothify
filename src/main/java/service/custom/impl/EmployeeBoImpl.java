package service.custom.impl;


import entity.EmployeeEntity;
import model.Employee;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import service.custom.EmployeeBo;
import util.DaoType;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {
    @Override
    public boolean addEmployee(Employee employee) {
        EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);

        EmployeeDao employeedao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);

        employeedao.save(entity);

        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee){
        EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);

        EmployeeDao employeedao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);

        employeedao.update(entity);

        return true;
    }

    @Override
    public boolean deleteEmployee(Employee employee){
        EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);
        EmployeeDao employeedao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);
        employeedao.delete(entity.getId());
        return true;
    }

    @Override
    public List<Employee> getEmployee() {
        EmployeeDao employeedao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);
        List<EmployeeEntity> list =employeedao.getAll();
        List<Employee> employeelist = new ArrayList<>();
        for (EmployeeEntity entity : list) {
            employeelist.add(new ModelMapper().map(entity, Employee.class));
        }
        return employeelist;
    }

    @Override
    public Employee search(String id) {
        EmployeeDao employeedao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);
        return new ModelMapper().map(employeedao.search(id),Employee.class);
    }
}
