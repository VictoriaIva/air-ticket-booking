package Service;
import java.util.List;

public interface Service<T> {
    void saveEntity(T entity);
    void updateEntity(T entity);
    void deleteEntity(T entity);
    List<T> findAllEntities();
    T findEntity(int id);

}