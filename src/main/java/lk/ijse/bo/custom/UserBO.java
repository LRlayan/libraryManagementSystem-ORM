package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BookDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    List<BookDTO> getAllBooks();
}
