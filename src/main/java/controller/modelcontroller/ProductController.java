package controller.modelcontroller;


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
        list.sort((item1,item2) -> {
            int id1 = Integer.parseInt(item1.getId().split("P")[1]);
            int id2 = Integer.parseInt(item2.getId().split("P")[1]);
            return Integer.compare(id1, id2);
        });
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

    public boolean UpdateItemQty(int qty,String id){
        Product product = productservice.searchProduct(id);
        product.setQty(product.getQty()+qty);
        productservice.updateProduct(product);
        return true;
    }

    public double getData(String category){
        double total = 0;
        List<Product> list =  productservice.getProduct();
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getCategory().equals(category)) {
                total += list.get(i).getQty() * list.get(i).getPrice();
            }
        }
        return total;
    }

    public double getSupplierData(String category){
        double total = 0;
        List<Product> list =  productservice.getProduct();
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getCategory().equals(category)) {
                total += list.get(i).getQty();
            }
        }
        return total;
    }

    public String GetReport(){
        String text =" \t\t\t\t\t\t\t\t\t\t\t\tPRODUCT REPORT\n\n\nProduct\t\tQty\t\t  \tPrice\t\t\t\tTotal Price\n";
        List<Product> list =  ProductController.getInstance().getProduct();
        for (int i = 0; i <list.size(); i++) {
            text += list.get(i).getId()+"\t\t\t\t"+list.get(i).getQty()+"\t\t\t\t"+list.get(i).getPrice()+"\t\t\t\t"+list.get(i).getPrice()*list.get(i).getQty()+"\n";
        }
        return text;
    }
}
