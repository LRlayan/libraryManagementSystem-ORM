package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String branch;

    public UserDTO(long id, String name, String email, String branchName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branchName;
    }
}
