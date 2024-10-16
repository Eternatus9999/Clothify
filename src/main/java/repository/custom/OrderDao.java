package repository.custom;

import entity.OrderDetailsEntity;
import entity.OrderEntity;
import repository.CrudDao;

import java.util.List;

public interface OrderDao extends CrudDao<OrderEntity> {
    boolean savedetails(OrderDetailsEntity entity);
    List<OrderDetailsEntity> deletedetails(String id);
    OrderEntity searchdetails(String id);
    List<OrderDetailsEntity> getalldetails(String id);
}
