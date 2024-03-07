package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AdminBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.entity.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminBOImpl implements AdminBO {

    AdminDAO adminDAO = (AdminDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.ADMIN);

    @Override
    public boolean saveAdmin(AdminDTO adminDTO) {
       return adminDAO.save(new Admin(adminDTO.getId(),adminDTO.getUsername(),adminDTO.getPassword()));
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) {
        return false;
    }

    @Override
    public boolean deleteAdmin() {
        return false;
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> adminList = adminDAO.getAll();
        List<AdminDTO> adminDTOS = new ArrayList<>();

        for (Admin admin : adminList){
            adminDTOS.add(new AdminDTO(admin.getId(),admin.getUsername(),admin.getPassword()));
        }
        return adminDTOS;
    }
}
