package lk.ijse.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryTM {
    private long id;
    private String bookTitle;
    private String nameOfUser;
    private String time;
    private String startDate;
    private String returnDate;
    private JFXButton returnBook;

    public HistoryTM(long id, String bookTitle, String nameOfUser, String time, String startDate, String returnDate) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.nameOfUser = nameOfUser;
        this.time = time;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }
}
