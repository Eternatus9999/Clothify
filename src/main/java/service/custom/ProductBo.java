package service.custom;

import entity.ProductEntity;
import model.Product;

import java.util.List;

public interface ProductBo {
    boolean addProduct(Product product);
    List<ProductEntity> getProduct();
}
