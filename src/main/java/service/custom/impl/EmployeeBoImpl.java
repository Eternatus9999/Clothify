package service.custom.impl;


import entity.EmployeeEntity;
import model.Employee;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import service.custom.EmployeeBo;
import util.DaoType;

import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {
    public boolean addEmployee(Employee employee) {
        EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);

        EmployeeDao customerdao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);

        customerdao.save(entity);

        return true;
    }

    @Override
    public List<EmployeeEntity> getEmployee() {

        EmployeeDao customerdao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);

        return customerdao.getAll();
    }
}
