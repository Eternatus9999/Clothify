package repository.custom.impl;

import entity.EmployeeEntity;
import repository.custom.EmployeeDao;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean save(EmployeeEntity employee) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(EmployeeEntity.class,id));
        session.getTransaction().commit();
        return false;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery("from EmployeeEntity",EmployeeEntity.class).list();
    }

    @Override
    public boolean update(EmployeeEntity employeeentity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(employeeentity.getId(),employeeentity);
        session.getTransaction().commit();
        return false;
    }

    @Override
    public EmployeeEntity search(String id) {
        Session session = HibernateUtil.getSession();
        return session.get(EmployeeEntity.class, id);
    }
}
