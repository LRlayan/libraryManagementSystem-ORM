package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;

import java.util.List;

public interface QueryDAO<T> extends SuperDAO {
    List<T> notReturnBooks();
}
