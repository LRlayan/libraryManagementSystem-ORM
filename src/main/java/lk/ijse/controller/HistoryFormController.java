package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.HistoryBO;
import lk.ijse.dto.HistoryDTO;
import lk.ijse.dto.tm.HistoryTM;
import lk.ijse.pageController.PageControl;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HistoryFormController implements Initializable {
    @FXML
    private JFXButton btnClose;

    @FXML
    private TableView<HistoryTM> historyTable;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableColumn<?, ?> colStartDate;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colReturnBook;

    PageControl pageControl = new PageControl();
    HistoryBO historyBO = (HistoryBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.HISTORY);
    ObservableList<HistoryTM> obList = FXCollections.observableArrayList();

    @FXML
    void closeWindowOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllTransaction();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("nameOfUser"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colReturnBook.setCellValueFactory(new PropertyValueFactory<>("returnBook"));
    }

    private void loadAllTransaction() {
        try{
            for (HistoryDTO historyDTO : historyBO.getAllTransaction()){
                obList.add(new HistoryTM(
                        historyDTO.getId(),
                        historyDTO.getBookTitle(),
                        historyDTO.getNameOfUser(),
                        historyDTO.getTime(),
                        historyDTO.getStartDate(),
                        historyDTO.getReturnDate(),
                        new JFXButton("Return Book")
                ));
            }
            historyTable.setItems(obList);

            for (int i = 0; i < obList.size(); i++) {
                obList.get(i).getReturnBook().setTextFill(Color.WHITE);
                obList.get(i).getReturnBook().setStyle("-fx-background-color: #0089ab");
            }

            historyTable.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
                for (int i = 0; i < obList.size(); i++) {

                    obList.get(i).getReturnBook().setOnAction(event -> {

                        ButtonType buttonYes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                        ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                        Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure return Book!", buttonYes, buttonNo).showAndWait();
                        if (type.get().getText().equals("Yes")) {
                            var historyDTO = new HistoryDTO(newSelection.getId(), newSelection.getBookTitle(), newSelection.getNameOfUser(), newSelection.getTime(), newSelection.getStartDate(), newSelection.getReturnDate());

                            try {
                                boolean isUpdate = historyBO.updateBookStatus(historyDTO);

                                if (isUpdate) {
                                    new Alert(Alert.AlertType.INFORMATION, "return Successfully").show();
                                } else {
                                    new Alert(Alert.AlertType.ERROR, "Please Try again later!").show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
