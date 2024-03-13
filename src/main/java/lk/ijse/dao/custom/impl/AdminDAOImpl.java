package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Branches;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    public static Branches branches;

    @Override
    public boolean save(Admin admin) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Admin> adminList = new ArrayList<>();

        admin.setBranches(branches);
        adminList.add(admin);
        branches.setAdminList(adminList);

        session.save(admin);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Admin> getAll() {
       Session session = FactoryConfiguration.getInstance().getSession();
       return session.createQuery("from Admin").list();
    }
}
