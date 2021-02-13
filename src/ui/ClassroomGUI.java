package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;
import model.UserAccount;

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

    @FXML
    private TableView<UserAccount> tableViewUseraccount;

    @FXML
    private TableColumn<UserAccount, String> usernameColumn;

    @FXML
    private TableColumn<UserAccount, String> GenderColumn;

    @FXML
    private TableColumn<UserAccount, String> careerColumn;

    @FXML
    private TableColumn<UserAccount, String> birthdayColumn;

    @FXML
    private TableColumn<UserAccount, String> browserColumn;

    private Image imageProfile;

    @FXML
    private Label usernameInAccountList;

    @FXML
    private ImageView userImageInAccountList;

    @FXML
    public void browseFileToChoose(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        Stage primaryStage = (Stage)mainPane.getScene().getWindow();
        File fileToSave = fileChooser.showOpenDialog(primaryStage);
        imageProfile = new Image(fileToSave.toURI().toString());
        //System.out.println(fileToSave.getPath());
        if(imageProfile != null){
            fileDirectory.setText(fileToSave.getPath().toString());
        }else{
            fileDirectory.setText("Image not found");
        }
    }

    @FXML
    public void createAccount(ActionEvent event) {
        //getting the gender of the user from the radio button
        try{
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
            String favBrow = "";
            if(favoriteBrowser != null){
                favBrow = favoriteBrowser.getValue().toString();
            }
            if((!newUsername.getText().equals("")) && (!newPassword.getText().equals("")) && (!gender.equals(""))
                    && (imageProfile != null) && (!careers.isEmpty()) && !(birthdayDate.getValue() == null) && !(favoriteBrowser.getValue() == null)) {
                classroom.addUser(newUsername.getText(), newPassword.getText(), gender,
                        imageProfile,careers, birthday, favBrow);
                imageProfile = null;
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("User created successfully");
                alert.showAndWait();
                singUpAction(event);
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Fill al the fields before create a account");
                alert.showAndWait();
            }
        }catch(Exception ex){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Fill al the fields before create a account");
            alert.showAndWait();
        }

    }

    @FXML
    public void goToSignInScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent addContactPane = fxmlLoader.load();

        mainPane.getChildren().setAll(addContactPane);
    }
    @FXML
    public void loginAction(ActionEvent event) {
        try {
            if(!loginUsernameField.getText().equals("") && !loginPasswordField.getText().equals("")) {
                String userToLogin = loginUsernameField.getText();
                String passwordToLogin = loginPasswordField.getText();
                if (classroom.canLogin(userToLogin, passwordToLogin)) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
                    fxmlLoader.setController(this);
                    Parent addContactPane = fxmlLoader.load();
                    mainPane.getChildren().setAll(addContactPane);
                    userImageInAccountList.setImage(classroom.returnUserImage(userToLogin));
                    usernameInAccountList.setText(userToLogin);
                    //tableViewUseraccount.prefWidthProperty().bind(mainPane.widthProperty());
                    initializeTableView();
                }else{
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong data");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Fill al the fields before login");
                alert.showAndWait();
            }
        } catch (Exception ex){
            ex.printStackTrace();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Fill al the fields before login");
            alert.showAndWait();
        }
    }

    @FXML
    public void singUpAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader.setController(this);
        Parent addContactPane = fxmlLoader.load();

        //Parent addContacts = FXMLLoader.load(getClass().getResource("addContact.fxml"));
        mainPane.getChildren().setAll(addContactPane);


        favoriteBrowser.getItems().add("Brave");
        favoriteBrowser.getItems().add("Opera");
        favoriteBrowser.getItems().add("Chrome");

    }
    @FXML
    public void logOutAction(ActionEvent event) throws IOException {
        startApp(event);
    }
    @FXML
    public void startApp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent addContactPane = fxmlLoader.load();

        //Parent addContacts = FXMLLoader.load(getClass().getResource("addContact.fxml"));
        mainPane.getChildren().setAll(addContactPane);
    }
    private void initializeTableView(){
        ObservableList<UserAccount> observableList;
        observableList = FXCollections.observableArrayList(classroom.getUsers());

        tableViewUseraccount.setItems(observableList);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("username"));
        GenderColumn.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("gender"));
        careerColumn.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("careers"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));
        browserColumn.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("favBrowser"));
    }
}
