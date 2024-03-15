package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.HistoryBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.dto.HistoryDTO;
import lk.ijse.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoryBOImpl implements HistoryBO {

    TransactionDAO transactionDAO = (TransactionDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.TRANSACTION);

    @Override
    public List<HistoryDTO> getAllTransaction() {
        List<Transaction> transactionList = transactionDAO.getAll();
        List<HistoryDTO> historyDTOS = new ArrayList<>();

        for (Transaction transaction : transactionList){
            historyDTOS.add(new HistoryDTO(transaction.getId(),transaction.getBookTitle(),transaction.getNameOfUser(),transaction.getTime(),transaction.getStartDate(),transaction.getReturnDate()));
        }
        return historyDTOS;
    }

    @Override
    public boolean updateBookStatus(HistoryDTO historyDTO) {
        return transactionDAO.update(new  Transaction(historyDTO.getId(),historyDTO.getBookTitle(),historyDTO.getNameOfUser(),historyDTO.getTime(),historyDTO.getStartDate(),historyDTO.getReturnDate()));
    }
}
