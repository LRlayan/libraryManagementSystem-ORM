package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BookBO;
import lk.ijse.dto.BookDTO;

import java.util.regex.Pattern;

public class AddNewBookController {

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXTextField txtBookName;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtGenre;

    @FXML
    private JFXTextField txtAvailabilityStatus;

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.BOOK);

    @FXML
    void saveBookOnAction(ActionEvent event) {
        String bookName = txtBookName.getText();
        String author = txtAuthor.getText();
        String genre = txtGenre.getText();
        String availableStatus = txtAvailabilityStatus.getText();

        boolean name = Pattern.matches("[a-zA-Z0-9]+",bookName);
        boolean bookAuthor = Pattern.matches("[a-zA-Z0-9]+",author);
        boolean bookGenre = Pattern.matches("[a-zA-Z0-9]+",genre);
        boolean status = Pattern.matches("[a-zA-Z0-9]+",availableStatus);

        try{
            if (!txtBookName.getText().isEmpty() && name && !txtAuthor.getText().isEmpty() && bookAuthor && !txtGenre.getText().isEmpty() && bookGenre && !txtAvailabilityStatus.getText().isEmpty() && status) {
                boolean isSaved = bookBO.saveBook(new BookDTO(0, bookName, author, genre, availableStatus));

                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION, "added book successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "please try again later").show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void windowCloseOnAction(ActionEvent event) {

    }
}
