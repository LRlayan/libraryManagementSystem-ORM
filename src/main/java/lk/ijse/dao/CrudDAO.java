package lk.ijse.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
   boolean save(T entity);
   boolean update(T entity);
   boolean delete(long id);
   List<T> getAll();
}
