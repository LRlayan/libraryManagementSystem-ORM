package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.UserSettingBO;
import lk.ijse.dto.UserSettingDTO;
import lk.ijse.pageController.PageControl;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class UserSettingFormController {
    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXTextField txtCurrentUsername;

    @FXML
    private JFXTextField txtNewUsername;

    @FXML
    private JFXTextField txtConfirmUsername;

    @FXML
    private Label lblCurrentUsername;

    @FXML
    private Label lblNewUsername;

    @FXML
    private Label lblConfirmUsername;

    @FXML
    private JFXTextField txtConfirmPassword;

    @FXML
    private JFXTextField txtNewPassword;

    @FXML
    private JFXTextField txtCurrentPassword;

    @FXML
    private Label lblCurrentPassword;

    @FXML
    private Label lblNewPassword;

    @FXML
    private Label lblConfirmPassword;

    PageControl pageControl = new PageControl();
    UserSettingBO userSettingBO = (UserSettingBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.USER_SETTING);
    @FXML
    void closeWindowOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @FXML
    void saveChangePasswordOnAction(ActionEvent event) {
        String currentPassword = txtCurrentPassword.getText();
        String newPassword = txtNewPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        boolean newPass = Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",newPassword);

        for (UserSettingDTO user : userSettingBO.getAllUser()){
            String password = pageControl.encryptPassword(currentPassword);

                if (user.getPassword().equals(password)) {
                    lblCurrentPassword.setText("");

                    if (!txtConfirmPassword.getText().isEmpty() && newPass) {
                        if (confirmPassword.equals(newPassword)) {
                            lblConfirmPassword.setText("");

                            String encryptPassword = pageControl.encryptPassword(confirmPassword);
                            boolean isUpdated = userSettingBO.updatePassword(encryptPassword, user.getId());

                            if (isUpdated) {
                                new Alert(Alert.AlertType.INFORMATION, "change password successfully").show();
                            } else {
                                new Alert(Alert.AlertType.INFORMATION, "please try again later").show();
                            }
                        } else {
                            lblConfirmPassword.setText("please re-enter your new password");
                        }
                    } else {
                    lblCurrentPassword.setText("");
                    }
                 }else {
                lblConfirmPassword.setText("please confirm password");
            }
        }
    }

    @FXML
    void saveChangeUsernameOnAction(ActionEvent event) {
        String currentUsername = txtCurrentUsername.getText();
        String newUsername = txtNewUsername.getText();
        String confirmUsername = txtConfirmUsername.getText();

        for (UserSettingDTO user : userSettingBO.getAllUser()) {
            if (!txtConfirmPassword.getText().isEmpty()) {
                if (user.getName().equals(currentUsername)) {
                    lblCurrentUsername.setText("");
                    if (confirmUsername.equals(newUsername)) {
                        lblConfirmUsername.setText("");
                        try {
                            boolean isUpdated = userSettingBO.updateUsername(confirmUsername, user.getId());
                            if (isUpdated) {
                                new Alert(Alert.AlertType.INFORMATION, "change username successfully").show();
                            } else {
                                new Alert(Alert.AlertType.INFORMATION, "please try again later").show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        lblConfirmUsername.setText("please re-enter your new username");
                    }
                } else {
                    lblCurrentUsername.setText("invalid username");
                }
            }else {
                lblConfirmPassword.setText("please confirm username");
            }
        }
    }
}
