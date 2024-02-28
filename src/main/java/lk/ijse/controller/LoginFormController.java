package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pageController.PageControl;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane loginAnchorpane;

    @FXML
    private JFXButton btnLogin;

    PageControl pageControl = new PageControl();

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/userForm.fxml");
        pageControl.closeWindow(btnLogin);
    }

    public void registerOnAction(ActionEvent event) throws IOException {
        pageControl.changeOnlyAnchorPane("/view/registerForm.fxml" , loginAnchorpane);
    }
}
