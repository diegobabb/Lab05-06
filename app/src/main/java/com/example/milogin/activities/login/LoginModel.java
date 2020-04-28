package com.example.milogin.activities.login;

import com.example.milogin.DataAccess.Data;
import com.example.milogin.Logic.User;


public class LoginModel {

    public LoginModel(){

    }

    public User validate(User user){
        for (User u: Data.getInstance().getUsers()) {
            if(user.getID().equals(u.getID()) &&
              user.getPassword().equals(u.getPassword())){
                return u;
            }
        }
        return null;
    }

    public User getUserByID(String id) {
        for (User u : Data.getInstance().getUsers()) {
            if (id.equals(u.getID())) {
                return u;
            }
        }
        return null;
    }

    public boolean addUser(User u){
        return Data.getInstance().addUser(u);
    }

}
