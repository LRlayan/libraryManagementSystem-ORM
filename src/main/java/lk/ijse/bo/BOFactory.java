package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER,SETTING,REGISTER,LOGIN,HISTORY,BOOK
    }

    public SuperBO BOTypes(BOTypes boTypes){
        switch (boTypes){
            case USER:
                return new UserFormBOImpl();
            case SETTING:
                return new SettingFormBOImpl();
            case REGISTER:
                return new RegisterFormBOImpl();
            case LOGIN:
                return new LoginFormBOImpl();
            case HISTORY:
                return new HistoryCardFormBOImpl();
            case BOOK:
                return new BookBOImpl();
            default:
                return null;
        }
    }
}
