package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import model.Classroom;

import java.io.IOException;

public class ClassroomGUI {

    private Classroom classroom;

    public ClassroomGUI(Classroom classroom){this.classroom = classroom;}

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

    }

    @FXML
    void createAccount(ActionEvent event) {

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
