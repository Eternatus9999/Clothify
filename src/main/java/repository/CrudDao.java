package repository;

import javafx.collections.ObservableList;

public interface CrudDao <T> extends SuperDao{
    boolean save(T t);
    boolean delete(String id);
    ObservableList<T> getAll();
    boolean update(T t);
    T search(String name);
}
