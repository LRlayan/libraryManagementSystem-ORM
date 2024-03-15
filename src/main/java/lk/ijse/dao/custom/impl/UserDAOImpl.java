package lk.ijse.dao.custom.impl;

import jakarta.persistence.Query;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.Books;
import lk.ijse.entity.Branches;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public static Branches branches;

    @Override
    public boolean save(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            List<User> userList = new ArrayList<>();

            user.setBranches(branches);
            branches.setUserList(userList);
            user.setBranchName(branches.getBranchName());

            userList.add(user);
            session.save(user);

            transaction.commit();
            session.close();
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
    public boolean update(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE User u SET u.id = :id , u.name = :username , u.passwords = :password WHERE u.id = :userId");
        query.setParameter("id" , user.getId());
        query.setParameter("username" , user.getName());
        query.setParameter("password" , user.getPasswords());
        query.setParameter("userId" , user.getId());
        int row = query.executeUpdate();

        transaction.commit();
        session.close();
        return row > 0;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM User ").list();
    }

    @Override
    public boolean updateUsername(String confirmUsername, long id) {
       Session session = FactoryConfiguration.getInstance().getSession();
       Transaction transaction = null;

       try{
           transaction = session.beginTransaction();
           session.createQuery("UPDATE User u SET u.name = :confirmUsername WHERE u.id = :userId")
                   .setParameter("confirmUsername",confirmUsername)
                   .setParameter("userId" , id)
                   .executeUpdate();

           transaction.commit();
           return true;
       }catch (Exception e){
           if (transaction != null){
               transaction.rollback();
           }
           e.printStackTrace();
           return false;
       }finally {
           session.close();
       }
    }

    @Override
    public boolean updatePassword(String confirmPassword, long id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.createQuery("UPDATE User u SET u.passwords = :confirmPassword WHERE u.id = :userId")
                    .setParameter("confirmPassword",confirmPassword)
                    .setParameter("userId" , id)
                    .executeUpdate();

            transaction.commit();
            return true;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }finally {
            session.close();
        }
    }
}
