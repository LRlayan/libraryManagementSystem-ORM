package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.pageController.PageControl;

public class BookFormController {
    @FXML
    private JFXButton btnClose;

    @FXML
    private TableView<?> bookTable;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colAvailability_Status;

    PageControl pageControl = new PageControl();

    @FXML
    void closeOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @FXML
    void newBookOnAction(ActionEvent event) {

    }
}
