package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branches branches;

    public Admin(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
