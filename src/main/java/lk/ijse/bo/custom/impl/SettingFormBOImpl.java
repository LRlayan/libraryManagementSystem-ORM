package lk.ijse.bo.custom.impl;

import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.SettingFormBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.RegisterDTO;
import lk.ijse.entity.User;

public class SettingFormBOImpl implements SettingFormBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.USER);

    @Override
    public boolean updateCredential(RegisterDTO userDTO) {
        return userDAO.update(new User(userDTO.getPasswords()));
    }
}
