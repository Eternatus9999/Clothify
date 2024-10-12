package service.custom.impl;

import entity.SupplierEntity;
import model.Supplier;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierBo;
import util.DaoType;

import java.util.List;

public class SupplierBoImpl implements SupplierBo {
    @Override
    public boolean addSupplier(Supplier supplier) {
        SupplierEntity entity = new ModelMapper().map(supplier, SupplierEntity.class);

        SupplierDao supplierdao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);

        supplierdao.save(entity);
        return false;
    }

    @Override
    public List<SupplierEntity> getSupplier() {
        SupplierDao supplierdao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);
        return supplierdao.getAll();
    }
}
