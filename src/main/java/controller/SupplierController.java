package controller;

import javafx.scene.control.Alert;
import model.Supplier;
import service.custom.SupplierBo;
import service.custom.impl.SupplierBoImpl;

import java.util.List;

public class SupplierController {
    private static SupplierController instance;

    final SupplierBo supplierservice = new SupplierBoImpl();

    private SupplierController(){}

    public static SupplierController getInstance(){
        return instance==null?instance=new SupplierController():instance;
    }

    public void AddSupplier(String id, String name, String company,String contact){
        if(name.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter a Name").showAndWait();
        }
        else if (company.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Enter a Company").showAndWait();
        }
        else if(contact.length()!=10){
            new Alert(Alert.AlertType.ERROR,"Phone number is incorrect").showAndWait();
        }
        else if(contact.charAt(0)!='0'){
            new Alert(Alert.AlertType.ERROR,"Phone number is incorrect").showAndWait();
        }
        else{
            new Alert(Alert.AlertType.INFORMATION,"Supplier added Successfully").showAndWait();
            supplierservice.addSupplier(new Supplier(id,name,company,contact));
        }
    }

    public void UpdateSupplier(String id, String name, String company,String contact){
        if(name.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter a Name").showAndWait();
        }
        else if (company.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Enter a Company").showAndWait();
        }
        else if(contact.length()!=10){
            new Alert(Alert.AlertType.ERROR,"Phone number is incorrect").showAndWait();
        }
        else if(contact.charAt(0)!='0'){
            new Alert(Alert.AlertType.ERROR,"Phone number is incorrect").showAndWait();
        }
        else{
            new Alert(Alert.AlertType.INFORMATION,"Supplier updated Successfully").showAndWait();
            supplierservice.updateSupplier(new Supplier(id,name,company,contact));
        }
    }

    public void DeleteSupplier(Supplier entity){
        new Alert(Alert.AlertType.CONFIRMATION,"Do you want to delete this Supplier").showAndWait();
        supplierservice.deleteSupplier(entity);
    }

    public Supplier SearchSupplier(String id){
        return supplierservice.searchSupplier(id);
    }

    public List<Supplier> getSupplier(){
        return supplierservice.getSupplier();
    }

    public String GenerateId(){
        List<Supplier> list = supplierservice.getSupplier();
        int id = list.isEmpty() ?1:Integer.parseInt((list.getLast().getId().split("S"))[1])+1;
        return "S"+id;
    }
}
