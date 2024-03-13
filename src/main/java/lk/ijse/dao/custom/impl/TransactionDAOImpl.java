package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.entity.Transaction;

import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public boolean save(Transaction transaction) {

        return false;
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
