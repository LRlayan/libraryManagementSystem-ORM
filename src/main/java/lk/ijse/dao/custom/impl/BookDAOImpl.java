package lk.ijse.dao.custom.impl;

import jakarta.persistence.Query;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.entity.Books;
import lk.ijse.entity.Branches;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public boolean save(Books books) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        try{
        transaction = session.beginTransaction();
        session.save(books);

        transaction.commit();
        return true;
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean saveSeveralObject(lk.ijse.entity.Transaction entity, User user , Books books) {
        return false;
    }

    @Override
    public boolean update(Books books) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE Books b SET b.title = :title , b.author = :author , b.genre = :genre , b.availabilityStatus = :availableStatus WHERE b.id = :bookId");
        query.setParameter("title" , books.getTitle());
        query.setParameter("author" , books.getAuthor());
        query.setParameter("genre" , books.getGenre());
        query.setParameter("availableStatus" , books.getAvailabilityStatus());
        query.setParameter("bookId" , books.getId());

        int row = query.executeUpdate();

        transaction.commit();
        session.close();
        return row > 0;
    }

    @Override
    public boolean delete(long id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Books books = session.get(Books.class, id);

            for (lk.ijse.entity.Transaction transaction1 : books.getTransactions()) {
                session.delete(transaction1);
            }

            session.delete(books);

            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public List<Books> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Books ").list();
    }
}
