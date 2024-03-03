package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.pageController.PageControl;

public class NewAdminFormContController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtPassword;
    @FXML
    private JFXButton btnClose;

    PageControl pageControl = new PageControl();

    @FXML
    void saveAdminOnAction(ActionEvent event) {

    }

    @FXML
    void closeOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

}
