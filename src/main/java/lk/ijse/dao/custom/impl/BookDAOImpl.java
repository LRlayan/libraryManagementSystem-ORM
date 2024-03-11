package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.entity.Books;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public boolean save(Books books) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(books);

        session.close();
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Books user) {
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
