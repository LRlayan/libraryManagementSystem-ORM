package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BranchesDAO;
import lk.ijse.dao.custom.impl.AdminDAOImpl;
import lk.ijse.dto.BranchDTO;
import lk.ijse.entity.Branches;

import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {

    BranchesDAO branchesDAO = (BranchesDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.BRANCHES);

    @Override
    public boolean saveBranches(BranchDTO entity) {
        return false;
    }

    @Override
    public boolean updateBranches(BranchDTO entity) {
        return false;
    }

    @Override
    public void deleteBranches() {

    }

    @Override
    public List<BranchDTO> getAllBranches() {
        List<Branches> branchesList = branchesDAO.getAll();

        List<BranchDTO> branchDTOS = new ArrayList<>();
        for (Branches branches : branchesList){
            branchDTOS.add(new BranchDTO(branches.getId(),branches.getBranchName()));
        }
       // AdminDAOImpl.branches = branchesList;
        return branchDTOS;
    }
}
