package lk.ijse.bo.custom.impl;

import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.bo.custom.AdminSettingBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.dto.AdminSettingDTO;
import lk.ijse.dto.UserSettingDTO;
import lk.ijse.entity.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminSettingBOImpl implements AdminSettingBO {

    AdminDAO adminDAO = (AdminDAO) DAOFactory.getDaoFactory().DAOTypes(DAOFactory.DAOTypes.ADMIN);

    @Override
    public List<AdminSettingDTO> getAllAdmin() {
        List<AdminSettingDTO> getAllAdmin = new ArrayList<>();
        for (Admin admin : adminDAO.getAll()){
            getAllAdmin.add(new AdminSettingDTO(admin.getId(), admin.getUsername(), admin.getPassword()));
        }
        return getAllAdmin;
    }

    @Override
    public boolean updateUsername(String confirmUsername, long id) {
       return adminDAO.updateUsername(confirmUsername,id);
    }

    @Override
    public boolean updatePassword(String confirmPassword, long id) {
        return adminDAO.updatePassword(confirmPassword,id);
    }
}
