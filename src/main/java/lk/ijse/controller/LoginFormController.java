package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pageController.PageControl;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane loginAnchorpane;

    PageControl pageControl = new PageControl();

    public void registerOnAction(ActionEvent event) throws IOException {
        pageControl.changeOnlyAnchorPane("/view/registerForm.fxml" , loginAnchorpane);
    }
}
