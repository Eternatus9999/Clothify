package service.custom;

import model.Order;

import java.util.List;

public interface OrderBo {
    List<Order> getOrder();
    boolean addOrder(Order order);
}
