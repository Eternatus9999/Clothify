package service.custom.impl;

import entity.OrderDetailsEntity;
import entity.OrderEntity;
import model.Order;
import model.OrderDetails;
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

    @Override
    public boolean addOrderDetails(OrderDetails orderDetails) {
        OrderDetailsEntity entity = new ModelMapper().map(orderDetails,OrderDetailsEntity.class);
        OrderDao orderdao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
        orderdao.savedetails(entity);
        return false;
    }

    @Override
    public List<OrderDetails> deleteOrderDetails(String id) {
        OrderDao orderdao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
        List<OrderDetailsEntity> templist =  orderdao.deletedetails(id);
        List<OrderDetails> list = new ArrayList<>();
        templist.forEach(entity -> {
            list.add(new ModelMapper().map(entity,OrderDetails.class));
        });
        return list;
    }

    @Override
    public List<OrderDetails> searchOrderDetail(String id) {
        OrderDao orderdao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
        List<OrderDetailsEntity> templist =  orderdao.getalldetails(id);
        List<OrderDetails> list = new ArrayList<>();
        templist.forEach(entity -> {
            list.add(new ModelMapper().map(entity,OrderDetails.class));
        });
        return list;
    }

    @Override
    public boolean deleteOrder(Order order) {
        OrderEntity entity = new ModelMapper().map(order,OrderEntity.class);
        OrderDao orderdao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
        orderdao.delete(entity.getOrid());
        return false;
    }

    @Override
    public Order searchOrder(String id) {
        OrderDao orderdao = DaoFactory.getInstance().getDaoType(DaoType.ORDER);
        return new ModelMapper().map(orderdao.search(id),Order.class);
    }
}
