package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.util.List;

public interface BlackListUsersBO extends SuperBO {
    List<UserDTO> blackListUsers();
}
