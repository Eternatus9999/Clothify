package controller;

import controller.maincontroller.MainController;
import entity.EmployeeEntity;
import javafx.scene.control.Alert;
import model.Employee;
import service.custom.EmployeeBo;
import service.custom.impl.EmployeeBoImpl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeController {

    private static EmployeeController instance;

    private EmployeeController(){}

    public static EmployeeController getInstance(){
        return instance==null?instance= new EmployeeController():instance;
    }

    final EmployeeBo employeeservice = new EmployeeBoImpl();

    public String GenerateId(){
        List<EmployeeEntity> list = employeeservice.getEmployee();
        int id = list.size()==0?1:Integer.parseInt((list.get(list.size()-1).getId().split("Emp")[1]))+1;
        return "Emp"+id;
    }
    public void addEmployee(String name,String email, String address, String password,String checkpassword,String phone){

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
            String id = GenerateId();
            if(employeeservice.addEmployee(new Employee(id, name, phone, email, address, password))){
                new Alert(Alert.AlertType.INFORMATION,"Employee added Successfully!").showAndWait();
                MainController.getInstance().NavigatetoUserInterface();
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Employee didn't added Successfully!").showAndWait();
            }
        }
    }
}
