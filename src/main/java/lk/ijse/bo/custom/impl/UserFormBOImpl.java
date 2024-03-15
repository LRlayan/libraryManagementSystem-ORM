package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.dto.BookDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Books;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserFormBOImpl implements UserBO {

    BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.BOOK);
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.USER);
    AdminDAO adminDAO = (AdminDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.ADMIN);

    @Override
    public List<BookDTO> getAllBooks() {
        List<Books> bookList = bookDAO.getAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Books book : bookList){
            bookDTOS.add(new BookDTO(book.getId(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getAvailabilityStatus(),book.getImage()));
        }
        return bookDTOS;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userDAO.getAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : userList){
            userDTOS.add(new UserDTO(user.getId(),user.getName(),user.getEmail(),user.getPasswords(),user.getBranchName()));
        }
        return userDTOS;
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<AdminDTO> adminDTOS = new ArrayList<>();
        for (Admin admin : adminDAO.getAll()){
            adminDTOS.add(new AdminDTO(admin.getId(),admin.getUsername(),admin.getPassword()));
        }
        return adminDTOS;
    }
}
