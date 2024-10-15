package service.custom;

import entity.ProductEntity;
import model.Product;

import java.util.List;

public interface ProductBo {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(Product product);
    Product searchProduct(String id);
    List<Product> getProduct();
}
