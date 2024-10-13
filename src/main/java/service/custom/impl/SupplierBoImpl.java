package service.custom.impl;

import entity.SupplierEntity;
import model.Supplier;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierBo;
import util.DaoType;

import java.util.ArrayList;
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
    public boolean deleteSupplier(Supplier supplier) {
        SupplierEntity entity = new ModelMapper().map(supplier, SupplierEntity.class);

        SupplierDao supplierdao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);

        supplierdao.delete(entity.getId());
        return false;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public Supplier searchSupplier(String id) {
        SupplierDao supplierdao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);
        return new ModelMapper().map(supplierdao.search(id), Supplier.class);
    }

    @Override
    public List<Supplier> getSupplier() {
        SupplierDao supplierdao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);
        List<SupplierEntity> list = supplierdao.getAll();
        List<Supplier> supplierlist = new ArrayList<>();
        for (SupplierEntity supplierEntity : list) {
            supplierlist.add(new ModelMapper().map(supplierEntity, Supplier.class));
        }
        return supplierlist;
    }
}
