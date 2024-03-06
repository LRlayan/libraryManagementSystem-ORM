package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Branches;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    public static Branches branches;

    @Override
    public boolean save(Admin admin) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Admin adminEntity = new Admin();
      //  Branches branches = new Branches();

        adminEntity.setBranches(branches);
        adminEntity.setId(admin.getId());
        adminEntity.setUsername(admin.getUsername());
        adminEntity.setPassword(admin.getPassword());

        session.save(adminEntity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<Admin> getAll() {
        return null;
    }
}
