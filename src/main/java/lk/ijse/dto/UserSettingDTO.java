package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String branchName;
}
