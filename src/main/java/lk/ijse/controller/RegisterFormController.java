package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pageController.PageControl;

import java.io.IOException;

public class RegisterFormController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private AnchorPane registerAnchorpane;

    PageControl pageControl = new PageControl();

    @FXML
    void loginOnAction(MouseEvent event) throws IOException {
        pageControl.changeOnlyAnchorPane("/view/loginForm.fxml" , registerAnchorpane);
    }

    @FXML
    void registerOnAction(ActionEvent event) {

    }
}
