package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BookBO;
import lk.ijse.dto.BookDTO;
import lk.ijse.dto.tm.BookTM;
import lk.ijse.pageController.PageControl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookFormController implements Initializable {
    @FXML
    private JFXButton btnClose;

    @FXML
    private TableView<BookTM> bookTable;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colAvailability_Status;

    @FXML
    private TableColumn<?, ?> colUpdate;

    @FXML
    private TableColumn<?, ?> colDelete;

    PageControl pageControl = new PageControl();
    BookBO bookBO = (BookBO) BOFactory.getBoFactory().BOTypes(BOFactory.BOTypes.BOOK);
    ObservableList<BookTM> obList = FXCollections.observableArrayList();

    @FXML
    void closeOnAction(ActionEvent event) {
        pageControl.closeWindow(btnClose);
    }

    @FXML
    void newBookOnAction(ActionEvent event) {

    }

    public void loadAllBooks(){
        try {
            List<BookDTO> bookDTOS = bookBO.getAllBook();
            for (BookDTO bookDTO : bookDTOS){
                obList.add(new BookTM(
                    bookDTO.getId(),
                    bookDTO.getTitle(),
                    bookDTO.getAuthor(),
                    bookDTO.getGenre(),
                    bookDTO.getAvailabilityStatus(),
                    new JFXButton("Update"),
                    new JFXButton("Delete")
                ));
            }
            bookTable.setItems(obList);

            for (int i = 0; i < obList.size(); i++) {
                obList.get(i).getUpdate().setOnAction(event->{
                    try{
                        pageControl.popUpWindow("/view/BookUpdateForm.fxml");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    bookTable.refresh();
                });
            }

            for (int i = 0; i < obList.size(); i++) {
                obList.get(i).getDelete().setOnAction(event -> {

                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        colAvailability_Status.setCellValueFactory(new PropertyValueFactory<>("AvailabilityStatus"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("Update"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllBooks();
        setCellValueFactory();
    }
}
