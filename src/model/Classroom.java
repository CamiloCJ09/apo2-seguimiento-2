package model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Classroom {

    private ArrayList<UserAccount> users;

    public Classroom(){
        users = new ArrayList<UserAccount>();
    }

    public void addUser(String username, String password, String gender, Image photo, ArrayList<String> careers, String birthday, String favBrowser){
        UserAccount userAccount1 = new UserAccount(username, password, gender, photo, careers, birthday, favBrowser);
        users.add(userAccount1);

        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).getUsername());
        }
    }
    public boolean canLogin(String loginUsername, String loginPassword){
        boolean canLogin = false;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(loginUsername)
            && users.get(i).getPassword().equals(loginPassword)){
                canLogin = true;
            }
        }
        return canLogin;
    }
    public ArrayList<UserAccount> getUsers(){
        return users;
    }
    public Image returnUserImage(String usernameToFind){
        Image imageToReturn = null;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(usernameToFind)){
                imageToReturn = users.get(i).getPhoto();
            }
        }
        return imageToReturn;
    }
}
