package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RegisterDTO;

import java.util.List;

public interface SettingFormBO extends SuperBO {
    boolean updateCredential(RegisterDTO userDTO);
    List<RegisterDTO> getAllUser();
}
