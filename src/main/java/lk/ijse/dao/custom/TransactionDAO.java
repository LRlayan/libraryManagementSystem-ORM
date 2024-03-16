package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Transaction;
import lk.ijse.entity.User;

import java.util.List;

public interface TransactionDAO extends CrudDAO<Transaction> {
    List<User> getUsersWithOverdueBooks();
}
