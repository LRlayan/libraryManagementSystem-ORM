package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.HistoryDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.util.List;

public interface HistoryBO extends SuperBO {
    List<HistoryDTO> getAllTransaction();
    boolean updateBookStatus(HistoryDTO historyDTO);
    List<UserDTO> getUsersWithOverdueBooks();
}
