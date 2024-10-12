package service.custom;

import entity.SupplierEntity;
import model.Employee;
import model.Supplier;

import java.util.List;

public interface SupplierBo {
    boolean addSupplier(Supplier supplier);

    List<SupplierEntity> getSupplier();
}
