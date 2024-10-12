package controller.maincontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Employee;

import service.custom.EmployeeBo;
import service.custom.impl.EmployeeBoImpl;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    private static MainController instance;

    final EmployeeBo employeeservice = new EmployeeBoImpl();

    public static Stage stage = new Stage();

    private MainController(){}

    public static MainController getInstance(){
        return instance==null?instance=new MainController():instance;
    }

    public void NavigatetoUserInterface(){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/user_form.fxml"))));
            stage.setFullScreen(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void NavigatetoAdminInterface(){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/admin_form.fxml"))));
            stage.setFullScreen(true);
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
    public void CheckValidation(String name,String email, String address, String password,String checkpassword,String phone){

        Pattern ppassword= Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        Matcher mpassword = ppassword.matcher(password);
        Pattern pemail= Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher memail = pemail.matcher(email);

        if(name.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter a Name!").showAndWait();
        }
        else if(phone.length()!=10){
            new Alert(Alert.AlertType.ERROR,"Phone number is incorrect").showAndWait();
        }
        else if(phone.charAt(0)!='0'){
            new Alert(Alert.AlertType.ERROR,"Phone number is incorrect").showAndWait();
        }
        else if (!memail.matches()){
            new Alert(Alert.AlertType.ERROR,"Inncorrect Email").showAndWait();
        }
        else if (address.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Enter an Address").showAndWait();
        }
        else if(password.length()<8){
            new Alert(Alert.AlertType.ERROR,"Password is Small").showAndWait();
        }
        else if (!mpassword.matches()) {
            new Alert(Alert.AlertType.ERROR,"Password must contain at least one of '!@#$%^&*' and one of numeric").showAndWait();
        }
        else if (!password.equals(checkpassword)) {
            new Alert(Alert.AlertType.ERROR,"Password doesn't match").showAndWait();
        }
        else {

            if(employeeservice.addEmployee(new Employee("Emp001", name, phone, email, address, password))){
                new Alert(Alert.AlertType.INFORMATION,"Employee added Successfully!").showAndWait();
                NavigatetoUserInterface();
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Employee didn't added Successfully!").showAndWait();
            }
        }
    }
}
