package lk.ijse.dao;

import lk.ijse.entity.Books;
import lk.ijse.entity.User;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
   boolean save(User user);
   boolean update(User user);
   void delete();
   List<Books> getAll();
}
