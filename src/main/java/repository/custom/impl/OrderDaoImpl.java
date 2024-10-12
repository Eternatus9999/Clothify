package repository.custom.impl;

import entity.OrderEntity;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import repository.custom.OrderDao;
import util.HibernateUtil;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(OrderEntity order) {
        Session session = HibernateUtil.getOrderSession();
        session.beginTransaction();
        session.persist(order);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<OrderEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(OrderEntity orderEntity) {
        return false;
    }

    @Override
    public OrderEntity search(String name) {
        return null;
    }
}
