package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RegisterDTO;

public interface SettingFormBO extends SuperBO {
    boolean updateCredential(RegisterDTO userDTO);
}
