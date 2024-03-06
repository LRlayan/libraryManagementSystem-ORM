package lk.ijse.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
   boolean save(T entity);
   boolean update(T entity);
   void delete();
   List<T> getAll();
}
