package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.pageController.PageControl;

import java.io.IOException;

public class BranchFormController {
    @FXML
    private TableView<?> branchTable;

    @FXML
    private TableColumn<?, ?> branchId;

    @FXML
    private TableColumn<?, ?> branchName;

    @FXML
    private TableColumn<?, ?> branchUpdate;

    @FXML
    private TableColumn<?, ?> branchDelete;

    @FXML
    private JFXButton btnClose;

    PageControl pageControl = new PageControl();

    @FXML
    void addNewBranchOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/addNewBranch.fxml");
        pageControl.closeWindow(btnClose);
    }

    @FXML
    void closeOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @FXML
    void viewBranchOnAction(ActionEvent event) throws IOException {
        pageControl.popUpWindow("/view/BranchForm.fxml");
        pageControl.closeWindow(btnClose);
    }
}
