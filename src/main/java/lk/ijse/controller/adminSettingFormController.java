package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminSettingBO;
import lk.ijse.bo.custom.SettingFormBO;
import lk.ijse.dto.*;
import lk.ijse.pageController.PageControl;

import java.util.List;

public class adminSettingFormController {
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
    private Label lblCurrentUsername;

    @FXML
    private Label lblNewUsername;

    @FXML
    private Label lblConfirmUsername;

    @FXML
    private Label lblCurrentPassword;

    @FXML
    private Label lblNewPassword;

    @FXML
    private Label lblConfirmPassword;

    PageControl pageControl = new PageControl();

    AdminSettingBO adminSettingBO = (AdminSettingBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.ADMIN_SETTING);

    @FXML
    void saveChangePasswordOnAction(ActionEvent event) {
        String currentPassword = txtCurrentPassword.getText();
        String newPassword = txtNewPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        for (AdminSettingDTO admin : adminSettingBO.getAllAdmin()) {
            if (admin.getPassword().equals(currentPassword)) {
                if (confirmPassword.equals(newPassword)){
                    if (!txtConfirmPassword.getText().isEmpty()){
                        boolean isUpdate = adminSettingBO.updatePassword(confirmPassword,admin.getId());
                        if (isUpdate){
                            new Alert(Alert.AlertType.INFORMATION,"Updates Successfully").show();
                        }else {
                            new Alert(Alert.AlertType.ERROR,"Please try again later").show();
                        }
                    }else {
                        lblConfirmPassword.setText("Please confirm password");
                    }
                }else {
                    lblConfirmPassword.setText("Please re-enter new password");
                }
            }else {
                lblCurrentPassword.setText("Invalid Password");
            }
        }
    }

    @FXML
    void saveChangeUsernameOnAction(ActionEvent event) {

        String currentUsername = txtCurrentUsername.getText();
        String newUsername = txtNewUsername.getText();
        String confirmUsername = txtConfirmUsername.getText();

        for (AdminSettingDTO admin : adminSettingBO.getAllAdmin()) {
            if (admin.getUsername().equals(currentUsername)) {
                if (confirmUsername.equals(newUsername)){
                    if (!txtConfirmUsername.getText().isEmpty()){
                        boolean isUpdate = adminSettingBO.updateUsername(confirmUsername,admin.getId());
                        if (isUpdate){
                            new Alert(Alert.AlertType.INFORMATION,"Updates Successfully").show();
                        }else {
                            new Alert(Alert.AlertType.ERROR,"Please ty again later").show();
                        }
                    }else {
                        lblConfirmUsername.setText("Please confirm username");
                    }
                }else {
                    lblConfirmUsername.setText("Please re-enter new username");
                }
            }else {
                lblCurrentUsername.setText("Invalid Username");
            }
        }
    }

    @FXML
    void closeWindowOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }
}
