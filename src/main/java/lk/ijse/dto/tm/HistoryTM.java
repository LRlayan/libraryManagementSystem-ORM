package lk.ijse.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryTM {
    private long id;
    private String bookTitle;
    private String nameOfUser;
    private String time;
    private String startDate;
    private LocalDate returnDate;
    private JFXButton returnBook;
    private String status;

    public HistoryTM(long id, String bookTitle, String nameOfUser, String time, String startDate, LocalDate returnDate) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.nameOfUser = nameOfUser;
        this.time = time;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }
}
