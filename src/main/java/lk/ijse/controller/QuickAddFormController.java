package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuickAddFormController implements Initializable {
    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXDatePicker txtStartDate;

    @FXML
    private JFXDatePicker txtReturnDate;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private JFXTimePicker txtTime;

    PageControl pageControl = new PageControl();
    static String title;
    @FXML
    void closeWindowOnAction(ActionEvent event) throws IOException {
        pageControl.closeWindow(btnClose);
    }

    @FXML
    void quickAddOnAction(ActionEvent event) {
        String startDate = String.valueOf(txtStartDate.getValue());
        String time = String.valueOf(txtTime.getValue());
        String returnDate = String.valueOf(txtReturnDate.getValue());
        String name = txtName.getText();
        String title = txtTitle.getText();


    }

    private void setBookTitle() {
       txtTitle.setText(title);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setBookTitle();
    }
}
