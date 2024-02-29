package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SettingFormController {
    @FXML
    private JFXTextField txtCurrentUsername;

    @FXML
    private JFXTextField txtNewUsername;

    @FXML
    private JFXTextField txtConfirmUsername;

    @FXML
    private JFXTextField txtConfirmPassword;

    @FXML
    private JFXTextField txtNewPassword;

    @FXML
    private JFXTextField txtCurrentPassword;

    @FXML
    private JFXButton btnClose;

    @FXML
    void closeButtonOnAction(ActionEvent event) {

    }

    @FXML
    void saveChangesOnAction(ActionEvent event) {

    }
}
