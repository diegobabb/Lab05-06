package com.example.milogin.Logic;

import com.example.milogin.Logic.User;

public class CurrentUser {
    private static User user = null;

    public static void setUser(User u) {
        user = u;
    }

    public static User getUser(){return user;}

}
