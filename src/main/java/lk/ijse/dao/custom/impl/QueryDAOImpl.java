package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<User> notReturnBooks() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String hql = "SELECT DISTINCT u " +
                "FROM User u " +
                "JOIN FETCH u.transactions t " +
                "WHERE t.status = 'taked book' " +
                "AND t.returnDate < :currentDate";

        return session.createQuery(hql, User.class)
                .setParameter("currentDate", LocalDate.now())
                .list();
    }
}
