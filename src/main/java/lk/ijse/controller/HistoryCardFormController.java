package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryCardFormController implements Initializable {

    @FXML
    private HBox hBox;

    @FXML
    private Label bookTitle;

    @FXML
    private Label startDate;

    @FXML
    private Label returnDate;

    @FXML
    private Label time;

    @FXML
    private Label nameOfUser;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
