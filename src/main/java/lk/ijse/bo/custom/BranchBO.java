package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BranchDTO;

import java.util.List;

public interface BranchBO extends SuperBO {
    boolean saveBranches(BranchDTO entity);
    boolean updateBranches(BranchDTO entity);
    void deleteBranches();
    List<BranchDTO> getAllBranches();
}
