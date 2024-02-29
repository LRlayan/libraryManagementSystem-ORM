package lk.ijse.dao;

import lk.ijse.dao.custom.impl.TransactionDAOImpl;
import lk.ijse.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        USER,TRANSACTION,BRANCHES,ADMIN,BOOK
    }
    public SuperDAO DAOTypes(DAOTypes daoTypes){
        switch (daoTypes){
            case USER:
                return new UserDAOImpl();
            case TRANSACTION:
                return new TransactionDAOImpl();
            default:
                return null;
        }
    }
}
