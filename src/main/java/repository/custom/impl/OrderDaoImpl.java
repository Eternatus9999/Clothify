package repository.custom.impl;

import entity.OrderEntity;
import org.hibernate.Session;
import repository.custom.OrderDao;
import util.HibernateUtil;

import java.util.List;


public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean save(OrderEntity orderEntity) {
        Session session = HibernateUtil.getOrderSession();
        session.beginTransaction();
        session.persist(orderEntity);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<OrderEntity> getAll() {
        Session session = HibernateUtil.getOrderSession();
        return session.createQuery("from OrderEntity",OrderEntity.class).list();
    }

    @Override
    public boolean update(OrderEntity orderEntity) {
        return false;
    }

    @Override
    public OrderEntity search(String id) {
        return null;
    }
}
