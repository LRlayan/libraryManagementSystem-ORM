package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

public interface UserDAO extends CrudDAO<User> {
    boolean updateUsername(String confirmUsername, long id);
    boolean updatePassword(String confirmPassword, long id);
}
