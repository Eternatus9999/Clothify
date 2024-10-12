package service.custom.impl;

import entity.EmployeeEntity;
import entity.OrderEntity;
import model.Order;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import repository.custom.OrderDao;
import service.custom.OrderBo;
import util.DaoType;

public class OrderBoImpl implements OrderBo {
    @Override
    public boolean addEmployee(Order order) {
        OrderEntity entity = new ModelMapper().map(order, OrderEntity.class);

        OrderDao orderDao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);

        orderDao.save(entity);
        return false;
    }
}
