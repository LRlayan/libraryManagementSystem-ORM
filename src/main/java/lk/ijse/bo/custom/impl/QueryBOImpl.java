package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.QueryBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.dto.UserDTO;

import java.util.List;

public class QueryBOImpl implements QueryBO {

    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<UserDTO> notReturnBookGetAllUser() {
        return queryDAO.notReturnBooks();
    }
}
