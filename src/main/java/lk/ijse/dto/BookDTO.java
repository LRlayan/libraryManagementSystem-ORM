package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private long id;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;
    private String image;
}
