package controller.usercontroller;

import javafx.scene.control.Alert;

public class UserController {
    private static UserController instance;
    private UserController(){}
    public static UserController getInstance(){
        return instance==null?instance= new UserController():instance;
    }
    public void AddProduct(String id,String name, String size, String supplier, int qty, double price,String category){
        if(name.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter a Name!").showAndWait();
        }
        else if(size.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter a Size!").showAndWait();
        }
        else if(qty==0){
            new Alert(Alert.AlertType.ERROR,"Enter a QTY!").showAndWait();
        }
        else if(price==0){
            new Alert(Alert.AlertType.ERROR,"Enter a Price!").showAndWait();
        }
        else{
            new Alert(Alert.AlertType.INFORMATION,"Product added successfully!").showAndWait();
        }
    }
}
