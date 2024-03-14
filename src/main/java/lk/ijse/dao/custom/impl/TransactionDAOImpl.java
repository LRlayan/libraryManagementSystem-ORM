package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.entity.Transaction;
import org.hibernate.Session;

import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {

    @Override
    public boolean save(Transaction transaction) {
            Session session = FactoryConfiguration.getInstance().getSession();
            org.hibernate.Transaction transaction1 = null;
            try {
                transaction1 = session.beginTransaction();

//                String hql = "INSERT INTO Transaction (id, bookTitle, nameOfUser, time, startDate, returnDate) " +
//                        "VALUES (:id, :bookTitle, :nameOfUser, :time, :startDate, :returnDate)";
//
//                session.createQuery(hql)
//                        .setParameter("id", transaction.getId())
//                        .setParameter("bookTitle", transaction.getBookTitle())
//                        .setParameter("nameOfUser", transaction.getNameOfUser())
//                        .setParameter("time", transaction.getTime())
//                        .setParameter("startDate", transaction.getStartDate())
//                        .setParameter("returnDate", transaction.getReturnDate())
//                        .executeUpdate();

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

        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Transaction> getAll() {
        return null;
    }
}
