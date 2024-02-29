package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RegisterFormBO;
import lk.ijse.dto.RegisterDTO;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.util.regex.Pattern;

public class RegisterFormController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private AnchorPane registerAnchorpane;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPassword;

    PageControl pageControl = new PageControl();
    RegisterFormBO registerFormBO = (RegisterFormBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.REGISTER);

    @FXML
    void loginOnAction(MouseEvent event) throws IOException {
        pageControl.changeOnlyAnchorPane("/view/loginForm.fxml" , registerAnchorpane);
    }

    @FXML
    void registerOnAction(ActionEvent event) {
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        boolean name = Pattern.matches("[a-zA-Z0-9]+",username);
        boolean mail = Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",email);
        boolean pass = Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",password);
        hiddenErrorMessage(name,mail,pass);
        if (!username.isEmpty() && name && !email.isEmpty() && mail && !password.isEmpty() && pass){
            var registerDTO = new RegisterDTO(0, username, email, password);

            try {
                 boolean isSaved = registerFormBO.saveUser(registerDTO);
                 if (isSaved){
                     new Alert(Alert.AlertType.INFORMATION,"Save Successfully!").show();
                 }else {
                     new Alert(Alert.AlertType.ERROR,"Try again!").show();
                 }

            }catch (Exception e){
               e.printStackTrace();
           }

        }else {
            if(!username.isEmpty() && !name){
                lblUsername.setText("Please input correct username");
            }
            if (!email.isEmpty() && !mail) {
                lblEmail.setText("Please enter correct email address");
            }
            if (!password.isEmpty() && !pass){
                lblPassword.setText("Please enter a strong password with capital letters,\nsimple letters, symbols and numbers and 8 characters.");
            }
        }
    }

    private void hiddenErrorMessage(boolean name,boolean mail,boolean pass){
        if(name){
            lblUsername.setText("");
        }
        if (mail){
            lblEmail.setText("");
        }
        if (pass){
            lblPassword.setText("");
        }
    }
}
