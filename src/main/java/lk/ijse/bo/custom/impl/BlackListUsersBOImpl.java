package lk.ijse.bo.custom.impl;

import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BlackListUsersBO;
import lk.ijse.bo.custom.QueryBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class BlackListUsersBOImpl implements BlackListUsersBO {

   QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<UserDTO> blackListUsers() {
       // return queryDAO.notReturnBooks();
        List<UserDTO> users = new ArrayList<>();
        List<User> userDTOList = queryDAO.notReturnBooks();

        for (User userList : userDTOList) {
            users.add(new UserDTO(userList.getId(),userList.getName(),userList.getEmail(),userList.getBranchName()));
        }
        return users;
    }
}
