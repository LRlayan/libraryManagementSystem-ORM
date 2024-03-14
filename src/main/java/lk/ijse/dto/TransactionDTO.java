package lk.ijse.dto;

import lk.ijse.entity.Books;
import lk.ijse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private long id;
    private String bookTitle;
    private String nameOfUser;
    private String time;
    private String startDate;
    private String returnDate;
}
