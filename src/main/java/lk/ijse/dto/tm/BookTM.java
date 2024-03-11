package lk.ijse.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookTM {
    private long id;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;
    private JFXButton update;
    private JFXButton delete;
}
