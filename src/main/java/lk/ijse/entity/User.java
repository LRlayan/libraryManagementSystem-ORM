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
    private String branchName;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branches branches;

    @ManyToMany
    @JoinTable(name = "Transaction")
    @Column(name = "user_id , branch_id")
    private List<Books> bookList;

    public User(String passwords) {
        this.passwords = passwords;
    }

    public User(long id, String name, String email, String passwords,String branchName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwords = passwords;
    }
}
