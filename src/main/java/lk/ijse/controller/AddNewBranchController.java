package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dto.BranchDTO;

import java.util.regex.Pattern;

public class AddNewBranchController {

    @FXML
    private JFXTextField txtBranchId;
    @FXML
    private JFXTextField txtBranchName;

    BranchBO branchBO = (BranchBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.BRANCH);

    @FXML
    void addBranchOnAction(ActionEvent event) {
        String branchId = txtBranchId.getText();
        String branchName = txtBranchName.getText();

        boolean id = Pattern.matches("[a-zA-z0-9]+",branchId);
        boolean name = Pattern.matches("[a-zA-z0-9]+",branchName);

        var branchDTO = new BranchDTO(0,branchId,branchName);
        try{
            if (!txtBranchId.getText().isEmpty() && id && !txtBranchName.getText().isEmpty() && name) {
                boolean isSaved = branchBO.saveBranches(branchDTO);
                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION, "Added Branch Successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Please try again later").show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
