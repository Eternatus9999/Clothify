package controller.modelcontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Employee;
import util.Encryptor;


import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (employee.getId().equals(username) && employee.getPassword().equals(new Encryptor().encryptString(password))) {
                return true;
            }
        }
        return false;
    }

    public void setPassword(String password, String checkpassword, String id){
        Pattern ppassword= Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        Matcher mpassword = ppassword.matcher(password);

        if(password.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter a Password").showAndWait();
        } else if (!mpassword.matches()) {
            new Alert(Alert.AlertType.ERROR,"Password must contain at least one of '!@#$%^&*' and one of numeric").showAndWait();
        } else if (checkpassword.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Re-Enter the Password").showAndWait();
        } else if (!password.equals(checkpassword)) {
            new Alert(Alert.AlertType.ERROR,"Password doesn't match").showAndWait();
        } else{
            Employee employee = EmployeeController.getInstance().SearchEmployee(id);
            employee.setPassword(new Encryptor().encryptString(password));
            EmployeeController.getInstance().UpdateEmployee(employee);
        }
    }
}
