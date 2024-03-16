package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BlackListUsersBO;
import lk.ijse.bo.custom.QueryBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.dto.tm.BlackListTM;
import lk.ijse.entity.User;
import lk.ijse.pageController.PageControl;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class BlackListUsersController implements Initializable {

    BlackListUsersBO blackListUsersBO = (BlackListUsersBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.BLACKLIST);


    @FXML
    private TableView<BlackListTM> backListTable;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colBranch;

    @FXML
    private JFXButton btnClose;

    PageControl pageControl = new PageControl();
    BlackListUsersBO blackListUsers = (BlackListUsersBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.BLACKLIST);
    ObservableList<BlackListTM> obList = FXCollections.observableArrayList();

    @FXML
    void closeWindowOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllBlackListUsers();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));
    }

    private void loadAllBlackListUsers() {
        try{
            for (UserDTO userDTO : blackListUsers.blackListUsers()){
                obList.add(new BlackListTM(
                        userDTO.getId(),
                        userDTO.getName(),
                        userDTO.getEmail(),
                        userDTO.getBranch()
                ));
            }
            backListTable.setItems(obList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
