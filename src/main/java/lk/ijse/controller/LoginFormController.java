package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.pageController.PageControl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane loginAnchorpane;

    @FXML
    private JFXButton btnLogin;

    PageControl pageControl = new PageControl();

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
}
