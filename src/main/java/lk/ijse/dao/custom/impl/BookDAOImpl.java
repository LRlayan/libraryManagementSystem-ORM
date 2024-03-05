package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.entity.Books;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<Books> getAll() {

        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Books ").list();
    }
}
