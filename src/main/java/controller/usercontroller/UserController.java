package controller.usercontroller;

import controller.OrderController;
import controller.ProductController;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Order;
import model.OrderDetails;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserController {
    private static UserController instance;

    private UserController(){}

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
            ProductController.getInstance().UpdateItemQty(((OrderDetails) o).getQty()*-1,((OrderDetails) o).getId());
        });
        return true;
    }
    public boolean DeleteOrder(Order order){
        new Alert(Alert.AlertType.CONFIRMATION,"Order Delete Successfully").showAndWait();
        OrderController.getInstance().DeleteOrder(order);
        List<OrderDetails> list = OrderController.getInstance().deleteCart(order);
        list.forEach(orderDetails -> {
            ProductController.getInstance().UpdateItemQty(orderDetails.getQty(),orderDetails.getId());
        });
        return true;
    }

}
