package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RegisterDTO;

import java.util.List;

public interface RegisterFormBO extends SuperBO {
    boolean saveUser(RegisterDTO registerDTO);
    List<RegisterDTO> getAll();
}
