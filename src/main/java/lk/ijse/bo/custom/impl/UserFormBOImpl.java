package lk.ijse.bo.custom.impl;

import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.dto.BookDTO;
import lk.ijse.entity.Books;

import java.util.ArrayList;
import java.util.List;

public class UserFormBOImpl implements UserBO {

    BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.BOOK);

    @Override
    public List<BookDTO> getAllBooks() {
        List<Books> bookList = bookDAO.getAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Books book : bookList){
            bookDTOS.add(new BookDTO(book.getId(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getAvailabilityStatus()));
        }
        return bookDTOS;
    }
}
