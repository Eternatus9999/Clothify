package service.custom.impl;

import entity.EmployeeEntity;
import entity.SupplierEntity;
import model.Supplier;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import repository.custom.SupplierDao;
import service.custom.SupplierBo;
import util.DaoType;

public class SupplierBoImpl implements SupplierBo {
    @Override
    public boolean addEmployee(Supplier supplier) {
        SupplierEntity entity = new ModelMapper().map(supplier, SupplierEntity.class);

        SupplierDao supplierdao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);

        supplierdao.save(entity);
        return false;
    }
}
