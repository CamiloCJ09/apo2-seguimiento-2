package model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class UserAccount {

    private String username;
    private String password;
    private String gender;
    private Image photo;
    private ArrayList<String> careers;
    private String birthday;
    private String favBrowser;

    public UserAccount(String username, String password, String gender, Image photo, ArrayList<String> careers, String birthday, String favBrowser) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.photo = photo;
        this.careers = careers;
        this.birthday = birthday;
        this.favBrowser = favBrowser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public ArrayList<String> getCareers() {
        return careers;
    }

    public void setCareers(ArrayList<String> careers) {
        this.careers = careers;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFavBrowser() {
        return favBrowser;
    }

    public void setFavBrowser(String favBrowser) {
        this.favBrowser = favBrowser;
    }
}
