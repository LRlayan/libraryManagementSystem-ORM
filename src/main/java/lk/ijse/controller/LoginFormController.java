package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    @FXML
    private AnchorPane loginAnchorpane;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnClose;

    PageControl pageControl = new PageControl();
    AdminBO adminBO = (AdminBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.ADMIN);

    static int increment = 0;

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {

        List<AdminDTO> allAdmin = adminBO.getAllAdmin();

        pageControl.popUpWindow("/view/userForm.fxml");
        pageControl.closeWindow(btnLogin);

        if (increment==0){
            createAdmin();
        }
        increment++;
    }

    public void registerOnAction(ActionEvent event) throws IOException {
        pageControl.changeOnlyAnchorPane("/view/registerForm.fxml" , loginAnchorpane);
    }

    @FXML
    void closeButtonOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void createAdmin() {
        String username = "admin";
        String password = "1234";

        try{
            var adminDTO = new AdminDTO(0,username,password);
            boolean isSaved = adminBO.saveAdmin(adminDTO);

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Not saved admin");
        }
    }
}
