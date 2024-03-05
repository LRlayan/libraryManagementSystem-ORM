package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BookBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.dto.BookDTO;
import lk.ijse.entity.Books;

import java.util.*;

public class BookBOImpl implements BookBO {

    BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.BOOK);

    @Override
    public boolean save(BookDTO book) {
        return false;
    }

    @Override
    public boolean update(BookDTO book) {
        return false;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<BookDTO> getAll() {
        List<Books> bookList = bookDAO.getAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Books book : bookList){
            bookDTOS.add(new BookDTO(book.getId(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getAvailabilityStatus()));
        }
        return bookDTOS;
    }
}
