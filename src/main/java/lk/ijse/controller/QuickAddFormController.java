package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class QuickAddFormController {
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

    @FXML
    void closeWindowOnAction(ActionEvent event) {

    }

    @FXML
    void quickAddOnAction(ActionEvent event) {

    }
}
