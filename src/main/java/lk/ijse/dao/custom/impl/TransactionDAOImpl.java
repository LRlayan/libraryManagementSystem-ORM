package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.entity.Transaction;
import lk.ijse.entity.User;

import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
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
    public List<Transaction> getAll() {
        return null;
    }
}
