package model;

public class UserAccount {

    private String username;
    private String password;
    private String gender;
    private String photoUrl;
    private String[] carrers;
    private String birthday;
    private String favBrowser;

    public UserAccount(String username, String password, String gender, String photoUrl, String[] carrers, String birthday, String favBrowser) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.photoUrl = photoUrl;
        this.carrers = carrers;
        this.birthday = birthday;
        this.favBrowser = favBrowser;
    }
}
