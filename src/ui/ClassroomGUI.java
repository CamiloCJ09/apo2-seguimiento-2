package ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;

import java.io.File;
import java.io.IOException;

public class ClassroomGUI {

    private Classroom classroom;

    public ClassroomGUI(Classroom classroom){
        this.classroom = classroom;
    }

    @FXML
    private Pane mainPane;

    @FXML
    private TextField loginUsernameField;

    @FXML
    private TextField loginPasswordField;

    @FXML
    private TextField newUsername;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField fileDirectory;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private DatePicker birthdayDate;

    @FXML
    private ChoiceBox<String> favoriteBrowser;


    @FXML
    void browseFileToChoose(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        Stage primaryStage = (Stage)mainPane.getScene().getWindow();
        File fileToSave = fileChooser.showOpenDialog(primaryStage);
    }

    @FXML
    void createAccount(ActionEvent event) {
        try {

        }catch(Exception ex){

        }
    }

    @FXML
    void goToSignInScreen(ActionEvent event) {

    }
    @FXML
    void loginAction(ActionEvent event) {

    }

    @FXML
    void singUpAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader.setController(this);
        Parent addContactPane = fxmlLoader.load();

        //Parent addContacts = FXMLLoader.load(getClass().getResource("addContact.fxml"));
        mainPane.getChildren().setAll(addContactPane);


        favoriteBrowser.getItems().add("Brave");
        favoriteBrowser.getItems().add("Opera");
        favoriteBrowser.getItems().add("Chrome");
        /*
        favoriteBrowser = new ChoiceBox<String>();
        favoriteBrowser.getItems().add("Brave");
         */
    }
    @FXML
    void startApp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent addContactPane = fxmlLoader.load();

        //Parent addContacts = FXMLLoader.load(getClass().getResource("addContact.fxml"));
        mainPane.getChildren().setAll(addContactPane);
    }
}
