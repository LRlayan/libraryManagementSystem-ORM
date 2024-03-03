package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lk.ijse.entity.Transaction;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    @FXML
    private JFXButton btnLogout;
    @FXML
    private HBox cardLayout;

    @FXML
    private VBox vBox;
    PageControl pageControl = new PageControl();
    private List<Transaction> history;
    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        pageControl.closeWindow(btnLogout);
        pageControl.popUpWindow("/view/loginForm.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void historyOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/historyCardForm.fxml");
    }

    @FXML
    void settingOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/settingForm.fxml");
    }


    @FXML
    void newAdminOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/newAdminForm.fxml");
    }


    @FXML
    void branchOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/branchForm.fxml");
    }
}
