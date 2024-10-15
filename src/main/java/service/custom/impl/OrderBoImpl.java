package service.custom.impl;

import entity.OrderEntity;
import model.Order;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.OrderDao;
import service.custom.OrderBo;
import util.DaoType;

import java.util.ArrayList;
import java.util.List;

public class OrderBoImpl implements OrderBo {

    @Override
    public List<Order> getOrder() {
        OrderDao orderdao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
        List<Order> orderlist = new ArrayList<>();
        List<OrderEntity> list = orderdao.getAll();
        list.forEach(orderEntity -> {
            orderlist.add(new ModelMapper().map(orderEntity,Order.class));
        });
        return orderlist;
    }

    @Override
    public boolean addOrder(Order order) {
        OrderEntity entity = new ModelMapper().map(order,OrderEntity.class);
        OrderDao orderdao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
        orderdao.save(entity);
        return false;
    }
}
