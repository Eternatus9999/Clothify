package service.custom.impl;


import entity.ProductEntity;
import model.Product;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.ProductDao;
import service.custom.ProductBo;
import util.DaoType;

import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBo {
    @Override
    public boolean addProduct(Product product) {
        ProductEntity entity = new ModelMapper().map(product, ProductEntity.class);

        ProductDao productdao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);

        productdao.save(entity);
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        ProductEntity entity = new ModelMapper().map(product, ProductEntity.class);

        ProductDao productdao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);

        productdao.update(entity);
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        ProductEntity entity = new ModelMapper().map(product, ProductEntity.class);
        ProductDao productdao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
        productdao.delete(entity.getId());
        return false;
    }

    @Override
    public Product searchProduct(String id) {
        ProductDao productdao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
        ProductEntity entity = productdao.search(id);
        return new ModelMapper().map(entity,Product.class);
    }

    @Override
    public List<Product> getProduct() {
        ProductDao productdao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
        List<ProductEntity> list = productdao.getAll();
        List<Product> productlist = new ArrayList<>();
        for (ProductEntity productEntity : list) {
            productlist.add(new ModelMapper().map(productEntity, Product.class));
        }
        return productlist;
    }
}
