package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BranchesDAO;
import lk.ijse.entity.Branches;
import org.hibernate.Session;

import java.util.List;

public class BranchesDAOImpl implements BranchesDAO {
    @Override
    public boolean save(Branches branches) {
        return false;
    }

    @Override
    public boolean update(Branches branches) {
        return false;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<Branches> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Branches ").list();
    }
}
