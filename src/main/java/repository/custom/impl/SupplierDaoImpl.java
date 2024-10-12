package repository.custom.impl;

import entity.SupplierEntity;
import org.hibernate.Session;
import repository.custom.SupplierDao;
import util.HibernateUtil;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public boolean save(SupplierEntity supplier) {
        Session session = HibernateUtil.getSupplierSession();
        session.beginTransaction();
        session.persist(supplier);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<SupplierEntity> getAll() {
        Session session = HibernateUtil.getSupplierSession();
        return session.createQuery("from SupplierEntity",SupplierEntity.class).list();
    }

    @Override
    public boolean update(SupplierEntity supplierEntity) {
        return false;
    }

    @Override
    public SupplierEntity search(String name) {
        return null;
    }
}
