package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.bo.custom.BranchBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dto.AdminDTO;
import lk.ijse.dto.BranchDTO;
import lk.ijse.pageController.PageControl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
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
        pageControl.popUpWindow("/view/userForm.fxml");
        pageControl.closeWindow(btnLogin);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();

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

            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"saved admin").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"not saved admin").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Not saved admin");
        }
    }
}
