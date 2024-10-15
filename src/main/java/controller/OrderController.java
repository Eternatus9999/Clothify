package controller;

import model.Order;
import model.OrderDetails;
import service.custom.OrderBo;
import service.custom.impl.OrderBoImpl;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private static OrderController instance;

    private List<OrderDetails> cart = new ArrayList<>();

    final OrderBo orderservice = new OrderBoImpl();

    double totalprice = 0;

    private OrderController(){};

    public static OrderController getInstance(){
        return instance==null?instance=new OrderController():instance;
    }

    public List<OrderDetails> getCart(){
        return cart;
    }

    public List<OrderDetails> getCart(int i){
        totalprice =0;
        cart = new ArrayList<>();
        return cart;
    }

    public List<OrderDetails> getCart(String i){

        return cart;
    }

    public void setCart(List<OrderDetails> list){
        cart = list;
    }

    public void setTotal(double total){
        totalprice+=total;
    }

    public String getTotal(){
        return totalprice+"";
    }

    public boolean PlaceOrder(Order order){
        cart.forEach(orderDetails -> {
            order.setDiscount(orderDetails.getDiscount()+order.getDiscount());
        });
        return orderservice.addOrder(order);

    }

    public List<Order> getOrder(){
        return orderservice.getOrder();
    }

    public String GenerateId(){
        List<Order> list = orderservice.getOrder();
        int id = list.isEmpty() ?1:Integer.parseInt((list.getLast().getOrid().split("OR"))[1])+1;
        return "OR"+id;
    }
}
