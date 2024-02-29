package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegisterFormBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.RegisterDTO;
import lk.ijse.entity.User;

public class RegisterFormBOImpl implements RegisterFormBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(RegisterDTO registerDTO) {
        return userDAO.save(new User(registerDTO.getId(),registerDTO.getName(),registerDTO.getEmail(),registerDTO.getPasswords()));
    }
}
