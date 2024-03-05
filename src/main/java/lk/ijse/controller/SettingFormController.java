package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RegisterFormBO;
import lk.ijse.bo.custom.SettingFormBO;
import lk.ijse.dto.RegisterDTO;
import lk.ijse.pageController.PageControl;

import java.util.List;

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

    RegisterFormBO registerFormBO = (RegisterFormBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.REGISTER);
    SettingFormBO settingFormBO = (SettingFormBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.SETTING);

    @FXML
    void saveChangesOnAction(ActionEvent event) {


        String currentUsername = txtCurrentUsername.getText();
        String newUsername = txtNewUsername.getText();
        String confirmUsername = txtConfirmUsername.getText();

        String currentPassword = txtCurrentPassword.getText();
        String newPassword = txtNewPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (!currentUsername.isEmpty() && !newUsername.isEmpty() && !confirmUsername.isEmpty()){

             boolean isChecked = checkingUsername(confirmUsername,newUsername,confirmUsername);
             if (isChecked){
                 var userDTO = new RegisterDTO();
                 userDTO.setName(confirmUsername);
                 boolean isUpdated = settingFormBO.updateCredential(userDTO);

                 if (isUpdated){
                     new Alert(Alert.AlertType.INFORMATION,"Updated Successfully").show();
                 }
             }
        }else if (!currentPassword.isEmpty() && !newPassword.isEmpty() && !confirmPassword.isEmpty()){

        }
    }

    private boolean checkingUsername(String currentUsername , String newUsername , String confirmUsername) {
        boolean isChecked = false;
        List<RegisterDTO> registerUsers = registerFormBO.getAll();

        for (int i = 0; i < registerUsers.size(); i++){
            if (currentUsername.equals(registerUsers.get(i).getName())){
                if (newUsername.equals(confirmUsername)){
                   isChecked = true;
                }else {
                    lblNewUsername.setText("incorrect username.please reEnter new username.");
                }
            }else {
                lblCurrentUsername.setText("Please input correct username");
            }
        }
        return isChecked;
    }
}
