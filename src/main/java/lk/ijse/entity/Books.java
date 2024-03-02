package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "book")
    private List<Transaction> transactionList;

    @ManyToMany
    private List<User> userList;

    @ManyToMany(mappedBy = "booksList" , cascade = CascadeType.ALL)
    private List<Branches> branchesList;
}
