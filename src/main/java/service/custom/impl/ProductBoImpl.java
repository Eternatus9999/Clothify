package service.custom.impl;


import entity.ProductEntity;
import model.Product;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.ProductDao;
import service.custom.ProductBo;
import util.DaoType;

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
    public List<ProductEntity> getProduct() {
        ProductDao productdao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
        return productdao.getAll();
    }
}
