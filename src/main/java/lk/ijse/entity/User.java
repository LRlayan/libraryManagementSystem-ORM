package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String passwords;


    public User(String passwords) {
        this.passwords = passwords;
    }

    public User(long id, String name, String email, String passwords) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwords = passwords;
    }
}
