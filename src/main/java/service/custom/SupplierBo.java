package service.custom;

import model.Supplier;

import java.util.List;

public interface SupplierBo {
    boolean addSupplier(Supplier supplier);
    boolean deleteSupplier(Supplier entity);
    boolean updateSupplier(Supplier supplier);
    Supplier searchSupplier(String id);
    List<Supplier> getSupplier();
}
