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
import lk.ijse.bo.custom.QueryBO;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.dto.HistoryDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.dto.tm.HistoryTM;
import lk.ijse.pageController.PageControl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class adminHistoryFormController implements Initializable {
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

    ObservableList<HistoryTM> obList = FXCollections.observableArrayList();
    HistoryBO historyBO = (HistoryBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.HISTORY);
    QueryBO queryBO = (QueryBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.QUERY_BO);
    PageControl pageControl = new PageControl();
    @FXML
    void closeWindowOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllHistory();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("nameOfUser"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
    }

    private void loadAllHistory() {
        try{
            for (HistoryDTO historyDTO : historyBO.getAllTransaction()){
                obList.add(new HistoryTM(
                        historyDTO.getId(),
                        historyDTO.getBookTitle(),
                        historyDTO.getNameOfUser(),
                        historyDTO.getTime(),
                        historyDTO.getStartDate(),
                        historyDTO.getReturnDate()
                ));
            }
            historyTable.setItems(obList);

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

    @FXML
    void NotReturnBooksOnAction(ActionEvent event) throws IOException {
      pageControl.popUpWindow("/view/blackListUsers.fxml");
    }
}
