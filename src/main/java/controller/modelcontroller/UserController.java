package controller.modelcontroller;

import javafx.collections.ObservableList;
import model.Order;
import model.OrderDetails;
import util.CreatePdf;
import util.EmailSender;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserController {
    private static UserController instance;

    public static String employee;

    private UserController(String employee){
        UserController.employee = employee;
    }

    private UserController(){}

    public static UserController getInstance(String employee){
        return instance==null?instance= new UserController(employee):instance;
    }

    public static UserController getInstance(){
        return instance==null?instance= new UserController():instance;
    }

    public LocalDate getDate(){
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return LocalDate.parse(f.format(date));
    }

    public boolean PlaceOrder(Order order, ObservableList list){
        OrderController.getInstance().PlaceOrder(order);
        list.forEach(o -> {
            OrderController.getInstance().addCart((OrderDetails) o);
            productController.getInstance().UpdateItemQty(((OrderDetails) o).getQty()*-1,((OrderDetails) o).getId());
        });
        String subject = "Clothify Order Number: "+order.getOrid();
        String text = GenerateBill(list);
        String file = new CreatePdf().create(text);
        EmailSender.create(order.getCustemail(), subject, " Name: "+order.getCustname()+"\nTotal : "+order.getTotal(),file);
        return true;
    }

    public boolean DeleteOrder(Order order){
        OrderController.getInstance().DeleteOrder(order);
        List<OrderDetails> list = OrderController.getInstance().deleteCart(order);
        list.forEach(orderDetails -> {
            productController.getInstance().UpdateItemQty(orderDetails.getQty(),orderDetails.getId());
        });
        return true;
    }

    public String GenerateBill(ObservableList list){
        String text = "Item Name      Qty          Price\n";
        double total = 0;
        for (int i = 0; i <list.size(); i++) {
            text +=((OrderDetails)list.get(i)).getName()+"\t\t\t"+((OrderDetails)list.get(i)).getQty()+"\t\t\t"+((OrderDetails)list.get(i)).getPrice()+"\n";
            total+=((OrderDetails)list.get(i)).getPrice();
        }
        text+="----------------------------------\n\t\t\t\t\t\t\t"+total+"\n\n\n\t\tThank you for Purchasing!";
        return text;
    }

}
