package service.custom.impl;

import entity.EmployeeEntity;
import entity.ProductEntity;
import model.Product;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import repository.custom.ProductDao;
import service.custom.ProductBo;
import util.DaoType;

public class ProductBoImpl implements ProductBo {
    @Override
    public boolean addEmployee(Product product) {
        ProductEntity entity = new ModelMapper().map(product, ProductEntity.class);

        ProductDao productdao = DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);

        productdao.save(entity);
        return false;
    }
}
