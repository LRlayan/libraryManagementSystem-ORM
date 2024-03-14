package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TransactionBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.dto.TransactionDTO;
import lk.ijse.entity.Transaction;

public class TransactionBOImpl implements TransactionBO {

    TransactionDAO transactionDAO = (TransactionDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.TRANSACTION);

    @Override
    public boolean saveTransaction(TransactionDTO transactionDTO) {
        return transactionDAO.save(new Transaction(transactionDTO.getId(),transactionDTO.getBookTitle(),transactionDTO.getNameOfUser(),transactionDTO.getTime(),transactionDTO.getStartDate(),transactionDTO.getReturnDate()));
    }
}
