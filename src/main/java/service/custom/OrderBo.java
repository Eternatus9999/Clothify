package service.custom;

import model.Order;
import model.OrderDetails;

import java.util.List;

public interface OrderBo {
    List<Order> getOrder();
    boolean addOrder(Order order);
    boolean deleteOrder(Order order);
    Order searchOrder(String id);
    boolean addOrderDetails(OrderDetails orderDetails);
    List<OrderDetails> deleteOrderDetails(String id);
    List<OrderDetails> searchOrderDetail(String id);
}
