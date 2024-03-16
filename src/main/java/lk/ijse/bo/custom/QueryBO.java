package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.UserDTO;

import java.util.List;

public interface QueryBO extends SuperBO {
    List<UserDTO> notReturnBookGetAllUser();
}
