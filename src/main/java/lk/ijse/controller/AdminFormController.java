package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminFormController implements Initializable {

    @FXML
    private JFXButton btnLogout;
    PageControl pageControl = new PageControl();

    @FXML
    public void logoutOnAction(ActionEvent event) throws IOException {
        pageControl.closeWindow(btnLogout);
        pageControl.popUpWindow("/view/loginForm.fxml");
    }

    @FXML
    public void settingOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/settingForm.fxml");
    }

    @FXML
    public void historyOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/historyForm.fxml");
    }

    @FXML
    void branchOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/branchForm.fxml");
    }

    @FXML
    void bookOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/bookForm.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
