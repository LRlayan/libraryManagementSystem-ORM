package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BookDTO;

import java.awt.print.Book;
import java.util.List;

public interface BookBO extends SuperBO {
    boolean save(BookDTO book);
    boolean update(BookDTO book);
    void delete();
    List<BookDTO> getAll();
}
