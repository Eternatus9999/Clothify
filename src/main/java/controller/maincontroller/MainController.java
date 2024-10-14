package controller.maincontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.io.IOException;

public class MainController {
    private static MainController instance;

    public static Stage stage = new Stage();

    private MainController(){}

    public static MainController getInstance(){
        return instance==null?instance=new MainController():instance;
    }

    public void NavigatetoUserInterface(){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/user_form.fxml"))));
            stage.setResizable(false);
            stage.setX(0);
            stage.setY(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void NavigatetoAdminInterface(){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/admin_form.fxml"))));
            stage.setX(0);
            stage.setY(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void CheckUser(String password, String username){
        if(password.contains("Admin")){
            NavigatetoAdminInterface();
        }
        else if(password.contains("User")){
            NavigatetoUserInterface();
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Password is Incorrect").showAndWait();
        }
    }
}
