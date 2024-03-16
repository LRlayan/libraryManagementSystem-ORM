package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private long id;
    private String bookTitle;
    private String nameOfUser;
    private String time;
    private String startDate;
    private LocalDate returnDate;
    private String status;
}
