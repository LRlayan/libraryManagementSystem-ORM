package lk.ijse.bo.custom.impl;

import lk.ijse.bo.UserSettingBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserSettingDTO;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserSettingBOImpl implements UserSettingBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.USER);

    @Override
    public List<UserSettingDTO> getAllUser() {
        List<UserSettingDTO> userSettingDTOS = new ArrayList<>();

        for (User user : userDAO.getAll()){
            userSettingDTOS.add(new UserSettingDTO(user.getId(),user.getName(),user.getEmail(),user.getPasswords(),user.getBranchName()));
        }
        return userSettingDTOS;
    }

    @Override
    public boolean updateUsername(String confirmUsername, long id) {
        return userDAO.updateUsername(confirmUsername,id);
    }

    @Override
    public boolean updatePassword(String confirmPassword, long id) {
        return userDAO.updatePassword(confirmPassword,id);
    }
}


