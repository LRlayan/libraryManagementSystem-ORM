package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.entity.Books;
import lk.ijse.entity.Transaction;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {

    @Override
    public boolean save(Transaction transaction) {
           return false;
        }

    @Override
    public boolean saveSeveralObject(Transaction transaction, User user , Books books) {
        String status = "Not Available";

        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction1 = null;
        try {
            transaction1 = session.beginTransaction();

            List<Transaction> transactions = new ArrayList<>();

            transaction.setUserList(user);
            user.setTransactions(transactions);

            transaction.setBookList(books);
            books.setTransactions(transactions);

            transactions.add(transaction);
            session.save(transaction);

            session.createQuery("UPDATE Books b SET b.availabilityStatus = :status WHERE b.id = :bookId")
                .setParameter("status" , status).setParameter("bookId" , books.getId())
                .executeUpdate();

            transaction1.commit();
            return true;
        } catch (Exception ex) {
            if (transaction1 != null) {
                transaction1.rollback();
            }
            ex.printStackTrace(); // or log the exception
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Transaction transaction) {
        String status = "Available";
        String transactionBookStatus = "Returned";

        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction1 = null;

        try {
            transaction1 = session.beginTransaction();
            session.createQuery("UPDATE Books b SET b.availabilityStatus = :status WHERE b.id = :bookId")
                    .setParameter("status", status)
                    .setParameter("bookId",transaction.getId())
                    .executeUpdate();

            session.createQuery("UPDATE Transaction t SET t.status = :transactionBookStatus WHERE t.id = :transactionId")
                    .setParameter("transactionBookStatus", transactionBookStatus)
                    .setParameter("transactionId",transaction.getId())
                    .executeUpdate();

            transaction1.commit();
            return true;
        }catch (Exception e){
            if (transaction1 != null){
                transaction1.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Transaction> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Transaction ").list();
    }

    @Override
    public List<User> getUsersWithOverdueBooks() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {

            String currentDate = String.valueOf(LocalDate.now());

            List<User> users = session.createQuery("SELECT DISTINCT t.userList FROM Transaction t WHERE t.returnDate < :currentDate", User.class)
                    .setParameter("currentDate", currentDate)
                    .getResultList();

            return users;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
