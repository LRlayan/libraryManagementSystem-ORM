package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {
    private long id;
    private String bookTitle;
    private String nameOfUser;
    private String time;
    private String startDate;
    private LocalDate returnDate;
    private String status;

    public HistoryDTO(long id, String bookTitle, String nameOfUser, String time, String startDate, LocalDate returnDate) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.nameOfUser = nameOfUser;
        this.time = time;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }
}
