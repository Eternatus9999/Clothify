package controller;

import entity.SupplierEntity;
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

    public List<SupplierEntity> getSupplier(){
        return supplierservice.getSupplier();
    }

    public String GenerateId(){
        List<SupplierEntity> list = supplierservice.getSupplier();
        int id = list.size()==0?1:Integer.parseInt((list.get(list.size()-1).getId().split("S"))[1])+1;
        return "S"+id;
    }
}
