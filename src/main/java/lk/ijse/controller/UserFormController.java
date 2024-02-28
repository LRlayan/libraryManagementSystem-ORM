package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lk.ijse.entity.Transaction;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    @FXML
    private JFXButton btnLogout;
    @FXML
    private HBox cardLayout;

    @FXML
    private VBox vBox;
    PageControl pageControl = new PageControl();
    private List<Transaction> history;
    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        pageControl.closeWindow(btnLogout);
        pageControl.popUpWindow("/view/loginForm.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        history = new ArrayList<>(transactionsHistory());
        try {
            for (int i = 0; i < history.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/historyCardForm.fxml"));

                cardLayout = fxmlLoader.load();
                HistoryCardFormController historyCardFormController = fxmlLoader.getController();
                historyCardFormController.setData(history.get(i));
                vBox.getChildren().add(cardLayout);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Transaction> transactionsHistory(){
         List<Transaction> list = new ArrayList<>();
         Transaction transaction = new Transaction();
         transaction.setId(0);
         transaction.setBookTitle("Madolduwa");
         transaction.setTime("10.20");
         transaction.setStartDate("2024-02-28");
         transaction.setReturnDate("2024-03-15");
         transaction.setNameOfUSer("Ramesh");
        list.add(transaction);

        Transaction transaction1 = new Transaction();
        transaction.setId(1);
        transaction.setBookTitle("Madolduwa");
        transaction.setTime("10.20");
        transaction.setStartDate("2024-02-28");
        transaction.setReturnDate("2024-03-15");
        transaction.setNameOfUSer("layan");
        list.add(transaction1);
         return list;
    }
}
