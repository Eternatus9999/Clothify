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

    public boolean AddProduct(String id,String name, String size, String supplier, String qtys, String prices,String category){
        int qty =0;
        double price =0;
        try{
            qty = Integer.parseInt(qtys);
            try{
                price = Double.parseDouble(prices);

                if(name.isEmpty()){
                    new Alert(Alert.AlertType.ERROR,"Enter a Name!").showAndWait();
                    return true;
                }
                else if(size.isEmpty()){
                    new Alert(Alert.AlertType.ERROR,"Enter a Size!").showAndWait();
                    return true;
                }
                else if(qty==0){
                    new Alert(Alert.AlertType.ERROR,"Enter a QTY!").showAndWait();
                    return true;
                }
                else if(price==0){
                    new Alert(Alert.AlertType.ERROR,"Enter a Price!").showAndWait();
                    return true;
                }
                else{
                    new Alert(Alert.AlertType.INFORMATION,"Product added successfully!").showAndWait();
                    productservice.addProduct(new Product(id, name, size, supplier, qty, price, category));
                }
            }
            catch (NumberFormatException ex){
                new Alert(Alert.AlertType.ERROR,"price cannot contains letters!").showAndWait();
                return false;
            }
        }
        catch (NumberFormatException ex){
            new Alert(Alert.AlertType.ERROR,"qty cannot contains letters!").showAndWait();
            return false;
        }
        return true;
    }

    public boolean UpdateProduct(String id,String name, String size, String supplier, String qtys, String prices,String category){
        int qty =0;
        double price =0;
        try{
            qty = Integer.parseInt(qtys);
            try{
                price = Double.parseDouble(prices);

                if(name.isEmpty()){
                    new Alert(Alert.AlertType.ERROR,"Enter a Name!").showAndWait();
                    return true;
                }
                else if(size.isEmpty()){
                    new Alert(Alert.AlertType.ERROR,"Enter a Size!").showAndWait();
                    return true;
                }
                else if(qty==0){
                    new Alert(Alert.AlertType.ERROR,"Enter a QTY!").showAndWait();
                    return true;
                }
                else if(price==0){
                    new Alert(Alert.AlertType.ERROR,"Enter a Price!").showAndWait();
                    return true;
                }
                else{
                    new Alert(Alert.AlertType.INFORMATION,"Product added successfully!").showAndWait();
                    productservice.updateProduct(new Product(id, name, size, supplier, qty, price, category));
                }
            }
            catch (NumberFormatException ex){
                new Alert(Alert.AlertType.ERROR,"price cannot contains letters!").showAndWait();
                return false;
            }
        }
        catch (NumberFormatException ex){
            new Alert(Alert.AlertType.ERROR,"qty cannot contains letters!").showAndWait();
            return false;
        }
        return true;
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