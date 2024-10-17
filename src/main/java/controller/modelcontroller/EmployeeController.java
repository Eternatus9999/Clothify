package controller.modelcontroller;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import model.Employee;
import model.Order;
import service.custom.EmployeeBo;
import service.custom.impl.EmployeeBoImpl;
import util.Encryptor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeController {

    private static EmployeeController instance;

    final EmployeeBo employeeservice = new EmployeeBoImpl();

    private EmployeeController(){}

    public static EmployeeController getInstance(){
        return instance==null?instance= new EmployeeController():instance;
    }

    public String GenerateId(){
        List<Employee> list = employeeservice.getEmployee();
        int id = list.isEmpty() ?1:Integer.parseInt((list.getLast().getId().split("Emp")[1]))+1;
        return "Emp"+id;
    }

    public void AddEmployee(String name,String email, String address, String password,String checkpassword,String phone){

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
            if(employeeservice.addEmployee(new Employee(id, name, phone, email, address, new Encryptor().encryptString(password)))){
                new Alert(Alert.AlertType.INFORMATION,"Employee added Successfully!").showAndWait();
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Employee didn't added Successfully!").showAndWait();
            }
        }
    }

    public void UpdateEmployee(String name,String email, String address, String password,String checkpassword,String phone){

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
            if(employeeservice.updateEmployee(new Employee(id, name, phone, email, address,new Encryptor().encryptString(password)))){
                new Alert(Alert.AlertType.INFORMATION,"Employee updated Successfully!").showAndWait();

            }
            else{
                new Alert(Alert.AlertType.ERROR,"Employee didn't updated Successfully!").showAndWait();
            }
        }
    }

    public void DeleteEmployee(Employee entity){
        new Alert(Alert.AlertType.CONFIRMATION,"Do you want to delete this Employee").showAndWait();
        employeeservice.deleteEmployee(entity);
    }

    public Employee SearchEmployee(String id){
        return employeeservice.search(id);
    }

    public List<Employee> GetEmployee(){
        return employeeservice.getEmployee();
    }

    public List<PieChart.Data> getEmployeeData(){
        List<PieChart.Data> list = new ArrayList<>();

        List<Order> orderlist = OrderController.getInstance().getOrder();
        for (int i = 0; i < orderlist.size(); i++) {
            int qty =0;
            for (int j = i; j < orderlist.size(); j++) {
                if(orderlist.get(i).getEmployeeid().equals(orderlist.get(j).getEmployeeid())){
                    qty++;
                }
            }
            list.add(new PieChart.Data(orderlist.get(i).getEmployeeid(),qty));
        }
        return list;
    }

    public String GetReport(){
        String text =" \t\t\t\t\t\t\t\t\t\t\t\tEMPLOYEE REPORT\n\n\nEmployee\t\tOrders Sold\n";
        List<Order> orderlist = OrderController.getInstance().getOrder();
        for (int i = 0; i < orderlist.size(); i++) {
            int qty =0;
            for (int j = i; j < orderlist.size(); j++) {
                if(orderlist.get(i).getEmployeeid().equals(orderlist.get(j).getEmployeeid())){
                    qty++;
                }
            }
            text += orderlist.get(i).getEmployeeid()+"\t\t\t\t"+qty+"\n";
        }
        return text;
    }

}
