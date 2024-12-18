package controller.modelcontroller;

import javafx.scene.control.Alert;
import model.Product;
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
        list.sort((supplier1,supplier2) -> {
            int id1 = Integer.parseInt(supplier1.getId().split("S")[1]);
            int id2 = Integer.parseInt(supplier2.getId().split("S")[1]);
            return Integer.compare(id1, id2);
        });
        int id = list.isEmpty() ?1:Integer.parseInt((list.getLast().getId().split("S"))[1])+1;
        return "S"+id;
    }

    public String GetReport(){
        String text =" \t\t\t\t\t\t\t\t\t\t\t\tSUPPLIER REPORT\n\n\nProduct\t\tSupplier\t\tOrder Qty\n";
        List<Product> list =  productController.getInstance().getProduct();
        for (int i = 0; i <list.size(); i++) {
            text += list.get(i).getId()+"\t\t\t\t"+list.get(i).getSupplier()+"\t\t\t\t"+list.get(i).getQty()+"\n";
        }
        return text;
    }
}
