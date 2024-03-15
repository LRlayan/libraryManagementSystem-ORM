package lk.ijse.bo;

import lk.ijse.dto.UserSettingDTO;

import java.util.List;

public interface UserSettingBO extends SuperBO{
    List<UserSettingDTO> getAllUser();

    boolean updateUsername(String confirmUsername, long id);

    boolean updatePassword(String confirmPassword, long id);
}
