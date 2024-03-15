package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.HistoryDTO;

import java.util.List;

public interface HistoryBO extends SuperBO {
    List<HistoryDTO> getAllTransaction();

    boolean updateBookStatus(HistoryDTO historyDTO);
}
