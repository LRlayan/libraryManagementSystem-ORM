package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.pageController.PageControl;

import java.io.IOException;

public class UserFormController {

    @FXML
    private JFXButton btnLogout;

    PageControl pageControl = new PageControl();

    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        pageControl.closeWindow(btnLogout);
        pageControl.popUpWindow("/view/loginForm.fxml");
    }
}
