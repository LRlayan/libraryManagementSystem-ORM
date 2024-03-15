package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.dto.TransactionDTO;
import org.hibernate.Session;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<TransactionDTO> notReturnBooks() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("select t.nameOfUser from User u join Transaction t on u.id = t.userList.id where t.returnDate < local date").list();
    }
}
