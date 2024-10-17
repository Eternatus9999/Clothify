package controller.maincontroller;

import controller.EmployeeController;
import controller.usercontroller.UserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Employee;
import util.Encryptor;


import java.io.IOException;
import java.util.List;

public class MainController {
    private static MainController instance;

    public static Stage stage = new Stage();

    private MainController(){}

    public static MainController getInstance(){
        return instance==null?instance=new MainController():instance;
    }

    private void NavigateToUserInterface(){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/user_form.fxml"))));
            stage.setResizable(false);
            stage.setX(0);
            stage.setY(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void NavigateToAdminInterface(){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/admin_form.fxml"))));
            stage.setX(0);
            stage.setY(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void CheckUser(String password, String username){
        if(password.contains("Admin123")&&username.contains("Admin")){
            NavigateToAdminInterface();
        }
        else if(isEmployee(username,password)){
            UserController.getInstance(username);
            NavigateToUserInterface();
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Password or ID is Incorrect").showAndWait();
        }
    }

    private boolean isEmployee(String username, String password){
        List<Employee> list =  EmployeeController.getInstance().GetEmployee();
        for(Employee employee : list) {
            if (employee.getName().equals(username) && employee.getPassword().equals(new Encryptor().encryptString(password))) {
                return true;
            }
        }
        return false;
    }
}
