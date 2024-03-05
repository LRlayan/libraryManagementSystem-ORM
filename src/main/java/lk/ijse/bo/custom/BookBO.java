package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BookDTO;

import java.util.List;

public interface BookBO extends SuperBO {
    boolean saveBook(BookDTO book);
    boolean updateBook(BookDTO book);
    void deleteBook();
    List<BookDTO> getAllBook();
}
