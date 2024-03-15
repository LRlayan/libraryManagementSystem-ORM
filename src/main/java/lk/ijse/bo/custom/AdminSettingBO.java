package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AdminSettingDTO;
import lk.ijse.dto.UserSettingDTO;

import java.util.List;

public interface AdminSettingBO extends SuperBO {
     List<AdminSettingDTO> getAllAdmin();

    boolean updateUsername(String confirmUsername, long id);

    boolean updatePassword(String confirmPassword, long id);
}
