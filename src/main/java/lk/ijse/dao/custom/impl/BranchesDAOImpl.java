package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BranchesDAO;
import lk.ijse.entity.Branches;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BranchesDAOImpl implements BranchesDAO {
    @Override
    public boolean save(Branches branches) {
       Session session = FactoryConfiguration.getInstance().getSession();
       Transaction transaction = session.beginTransaction();

       AdminDAOImpl.branches = branches;
       UserDAOImpl.branches = branches;
       session.save(branches);

       transaction.commit();
       session.close();
       return true;
    }

    @Override
    public boolean update(Branches branches) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Branches> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Branches ").list();
    }
}
