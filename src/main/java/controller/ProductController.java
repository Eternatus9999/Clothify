package controller;

import javafx.scene.control.Alert;
import model.Product;
import service.custom.ProductBo;
import service.custom.impl.ProductBoImpl;

import java.util.List;

public class ProductController {
    private static ProductController instance;

    private ProductController(){}

    public static ProductController getInstance(){
        return instance==null?instance=new ProductController():instance;
    }

    final ProductBo productservice = new ProductBoImpl();

    public String GenerateId(){
        List<Product> list = productservice.getProduct();
        int id = list.isEmpty() ?1:Integer.parseInt((list.getLast().getId().split("P")[1]))+1;
        return "P"+id;
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
            productservice.addProduct(new Product(id, name, size, supplier, qty, price, category));
        }
    }

    public void UpdateProduct(String id,String name, String size, String supplier, int qty, double price,String category){
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
            new Alert(Alert.AlertType.INFORMATION,"Product update successfully!").showAndWait();
            productservice.updateProduct(new Product(id, name, size, supplier, qty, price, category));
        }
    }

    public void DeleteProduct(Product entity){
        new Alert(Alert.AlertType.CONFIRMATION,"Do you want to delete this Product").showAndWait();
        productservice.deleteProduct(entity);
    }

    public Product SearchProduct(String id){
       return productservice.searchProduct(id);
    }

    public List<Product> getProduct(){
        return productservice.getProduct();
    }


}
