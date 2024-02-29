package lk.ijse.dao;

import lk.ijse.entity.User;

public interface CrudDAO<T> extends SuperDAO {
   boolean save(User user);
   void update();
   void delete();
}
