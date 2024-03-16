package lk.ijse.dao.custom.impl;

import jakarta.persistence.Query;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Books;
import lk.ijse.entity.Branches;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    public static Branches branches;

    @Override
    public boolean save(Admin admin) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List<Admin> adminList = new ArrayList<>();

            admin.setBranches(branches);
            adminList.add(admin);
            branches.setAdminList(adminList);

            session.save(admin);

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

    @Override
    public boolean saveSeveralObject(lk.ijse.entity.Transaction entity, User user , Books books) {
        return false;
    }

    @Override
    public boolean update(Admin admin) {
       Session session = FactoryConfiguration.getInstance().getSession();
       Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE Admin a SET a.id = :id , a.username = :username , a.password = :password WHERE a.id = :adminId");
        query.setParameter("id" , admin.getId());
        query.setParameter("username" , admin.getUsername());
        query.setParameter("password" , admin.getPassword());
        query.setParameter("adminId" , admin.getId());
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
    public List<Admin> getAll() {
       Session session = FactoryConfiguration.getInstance().getSession();
       return session.createQuery("from Admin").list();
    }

    @Override
    public boolean updateUsername(String confirmUsername, long id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.createQuery("UPDATE Admin a SET a.username = :confirmUsername WHERE a.id = :adminId")
                    .setParameter("confirmUsername",confirmUsername)
                    .setParameter("adminId" , id)
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
            session.createQuery("UPDATE Admin a SET a.password = :confirmPassword WHERE a.id = :adminId")
                    .setParameter("confirmPassword",confirmPassword)
                    .setParameter("adminId" , id)
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
}
