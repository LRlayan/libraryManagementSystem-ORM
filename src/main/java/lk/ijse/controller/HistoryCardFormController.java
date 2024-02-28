package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import lk.ijse.entity.Transaction;

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

    public void setData(Transaction transaction){
        bookTitle.setText(transaction.getBookTitle());
        startDate.setText(transaction.getStartDate());
        returnDate.setText(transaction.getReturnDate());
        time.setText(transaction.getTime());
        nameOfUser.setText(transaction.getNameOfUSer());
    }
}
