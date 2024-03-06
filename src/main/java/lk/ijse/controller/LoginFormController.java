package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dto.AdminDTO;
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

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/userForm.fxml");
        pageControl.closeWindow(btnLogin);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();
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
        createAdmin();
    }

    private void createAdmin() {
        String username = "admin";
        String password = "1234";
        int branchesId = 1;

        try{
            var adminDTO = new AdminDTO(0,username,password);
            boolean isSaved = adminBO.saveAdmin(adminDTO);

            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"saved admin").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Not saved").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
