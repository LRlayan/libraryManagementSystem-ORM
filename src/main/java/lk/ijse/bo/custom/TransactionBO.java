package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.TransactionDTO;

public interface TransactionBO extends SuperBO {
    boolean saveTransaction(TransactionDTO transactionDTO);
}
