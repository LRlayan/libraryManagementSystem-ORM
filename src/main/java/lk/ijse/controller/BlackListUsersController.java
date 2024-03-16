package lk.ijse.controller;

import javafx.fxml.Initializable;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BlackListUsersBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class BlackListUsersController implements Initializable {

    BlackListUsersBO blackListUsersBO = (BlackListUsersBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.BLACKLIST);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(LocalDate.now());
//         List<UserDTO> userDTOS = blackListUsersBO.blackListUsers();
//
//        System.out.println(userDTOS.size());
//         for (int i = 0; i < userDTOS.size(); i++) {
//             System.out.println(userDTOS.get(i).getId());
//             System.out.println(userDTOS.get(i).getName());
//
//         }
        setCellValueFactory();
        loadAllBlackListUsers();
    }

    private void setCellValueFactory() {

    }

    private void loadAllBlackListUsers() {


    }
}
