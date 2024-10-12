package repository.custom.impl;

import entity.ProductEntity;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import repository.custom.ProductDao;
import util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean save(ProductEntity product) {
        Session session = HibernateUtil.getProductSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<ProductEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(ProductEntity productEntity) {
        return false;
    }

    @Override
    public ProductEntity search(String name) {
        return null;
    }
}
