package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    @FXML
    private JFXButton btnLogout;

    @FXML
    private VBox vBox;

    PageControl pageControl = new PageControl();

    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        pageControl.closeWindow(btnLogout);
        pageControl.popUpWindow("/view/loginForm.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
