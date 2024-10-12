package repository.custom.impl;

import entity.EmployeeEntity;
import model.Employee;
import repository.custom.EmployeeDao;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(EmployeeEntity employee) {
        Session session = HibernateUtil.getEmployeeSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        Session session = HibernateUtil.getEmployeeSession();
        return session.createQuery("from EmployeeEntity",EmployeeEntity.class).list();
    }

    @Override
    public boolean update(EmployeeEntity employee) {
        return false;
    }

    @Override
    public EmployeeEntity search(String name) {
        return null;
    }
}
