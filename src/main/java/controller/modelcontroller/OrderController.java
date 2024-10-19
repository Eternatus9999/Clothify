package controller.modelcontroller;

import javafx.scene.chart.PieChart;
import model.Order;
import model.OrderDetails;
import service.custom.OrderBo;
import service.custom.impl.OrderBoImpl;

import java.time.LocalDate;
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

    public boolean DeleteOrder(Order order){
        return orderservice.deleteOrder(order);
    }

    public Order SearchOrder(String id){
        return orderservice.searchOrder(id);
    }

    public List<Order> getOrder(){
        return orderservice.getOrder();
    }

    public String GenerateId(){
        List<Order> list = orderservice.getOrder();
        list.sort((order1,order2) -> {
            int id1 = Integer.parseInt(order1.getOrid().split("OR")[1]);
            int id2 = Integer.parseInt(order2.getOrid().split("OR")[1]);
            return Integer.compare(id1, id2);
        });
        int id = list.isEmpty() ?1:Integer.parseInt((list.getLast().getOrid().split("OR"))[1])+1;
        return "OR"+id;
    }

    public void addCart(OrderDetails orderDetails){
        orderservice.addOrderDetails(orderDetails);
    }

    public List<OrderDetails> deleteCart(Order order){
        return orderservice.deleteOrderDetails(order.getOrid());
    }

    public List<OrderDetails> getorderdetails(String id){
        cart = orderservice.searchOrderDetail(id);
        cart.forEach(orderDetails -> {
            setTotal(orderDetails.getPrice());
        });
        return cart;
    }

    public String GetReport(String type){
        String text =" \t\t\t\t\t\t\t\t\t\t\t\tSALSE REPORT\n\n\nOrder\t\tCustomer\t\tDiscount\t\tPrice\n";
        LocalDate date = UserController.getInstance().getDate();
        String[] list = date.toString().split("-");
        List<Order> orderlist = OrderController.getInstance().getOrder();
        if(type.equals("Daily")){
            for (int i = 0; i < orderlist.size(); i++){
                if(orderlist.get(i).getDate().toString().split("-")[2].equals(list[2])){
                    text += orderlist.get(i).getOrid()+"\t\t\t"+orderlist.get(i).getCustname()+"\t\t"+orderlist.get(i).getDiscount()+"\t\t\t"+orderlist.get(i).getTotal()+"\n";
                }
            }
        } else if (type.equals("Monthly")) {
            for (int i = 0; i < orderlist.size(); i++){
                if(orderlist.get(i).getDate().toString().split("-")[1].equals(list[1])){
                    text += orderlist.get(i).getOrid()+"\t\t\t"+orderlist.get(i).getCustname()+"\t\t"+orderlist.get(i).getDiscount()+"\t\t\t"+orderlist.get(i).getTotal()+"\n";
                }
            }
            
        } else if (type.equals("Annual")) {
            for (int i = 0; i < orderlist.size(); i++){
                if(orderlist.get(i).getDate().toString().split("-")[0].equals(list[0])){
                    text += orderlist.get(i).getOrid()+"\t\t\t"+orderlist.get(i).getCustname()+"\t\t"+orderlist.get(i).getDiscount()+"\t\t\t"+orderlist.get(i).getTotal()+"\n";
                }
            }

        }
        return text;
    }

    public List<PieChart.Data> getData(){
        List<PieChart.Data> list = new ArrayList<>();
        List<Order> orderlist = OrderController.instance.getOrder();
        double gentqty =0;
        double ladiesqty =0;
        double kidsqty =0;
        for (int i = 0; i <orderlist.size(); i++) {
            List<OrderDetails> orderDetailsList = OrderController.getInstance().getorderdetails(orderlist.get(i).getOrid());
            for (int j = 0; j <orderDetailsList.size(); j++) {
                if(ProductController.getInstance().SearchProduct(orderDetailsList.get(j).getId()).getCategory().equals("Gents")){
                    gentqty+=orderDetailsList.get(j).getQty();
                }else if(ProductController.getInstance().SearchProduct(orderDetailsList.get(j).getId()).getCategory().equals("Ladies")){
                    ladiesqty+=orderDetailsList.get(j).getQty();
                }else if(ProductController.getInstance().SearchProduct(orderDetailsList.get(j).getId()).getCategory().equals("Kids")){
                    kidsqty+=orderDetailsList.get(j).getQty();
                }
            }
        }
        list.add(new PieChart.Data("Gents",gentqty));
        list.add(new PieChart.Data("Ladies",ladiesqty));
        list.add(new PieChart.Data("Kids",kidsqty));

        return list;
    }







}
