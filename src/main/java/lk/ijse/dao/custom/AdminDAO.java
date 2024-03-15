package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Admin;

public interface AdminDAO extends CrudDAO<Admin> {
    boolean updateUsername(String confirmUsername , long id);
    boolean updatePassword(String confirmPassword , long id);
}
