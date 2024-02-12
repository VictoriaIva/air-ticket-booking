package DAO;
import java.util.List;

public interface DAO<T> {
    boolean save(T obj);
    boolean update(T obj);
    boolean delete(T obj);
    T findById(int id);
    List<T> findAll();
}