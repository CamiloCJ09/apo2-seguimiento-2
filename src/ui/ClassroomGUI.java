package ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
    private RadioButton maleSelect;

    @FXML
    private RadioButton femaleSelect;

    @FXML
    private RadioButton otherSelect;

    @FXML
    private CheckBox softwareEnSelect;

    @FXML
    private CheckBox teleamticEnSelect;

    @FXML
    private CheckBox industrialEnSelect;

    @FXML
    private DatePicker birthdayDate;

    @FXML
    private ChoiceBox<String> favoriteBrowser;

    private Image imageProfile;

    @FXML
    void browseFileToChoose(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        Stage primaryStage = (Stage)mainPane.getScene().getWindow();
        File fileToSave = fileChooser.showOpenDialog(primaryStage);
        imageProfile = new Image(fileToSave.toURI().toString());
        if(imageProfile != null){
            fileDirectory.setText("Image uploaded");
        }else{
            fileDirectory.setText("Image not found");
        }
    }

    @FXML
    void createAccount(ActionEvent event) {
        //getting the gender of the user from the radio button
        String gender = "";
        if(maleSelect.isSelected()){ gender = "Male";}
        else if(femaleSelect.isSelected()){ gender = "Female";}
        else { gender = "Other";}

        //getting the career of the user from the check box
        ArrayList<String> careers = new ArrayList<String>(3);
        if(softwareEnSelect.isSelected()){careers.add("Software Engineering");}
        if(teleamticEnSelect.isSelected()){careers.add("Telematic Engineering");}
        if(industrialEnSelect.isSelected()){careers.add("Industrial Engineering");}

        String birthday = "";
        if(birthdayDate != null){
            birthday = birthdayDate.getValue().toString();
        }

        try {
            if(genderGroup.getSelectedToggle() != null) {
                //classroom.addUser(newUsername.getText(), newPassword.getText(), gender,
                        //imageProfile,careers, birthday);
            imageProfile = null;
            }
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
