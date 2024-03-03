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
public class Branches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String branchName;
}
