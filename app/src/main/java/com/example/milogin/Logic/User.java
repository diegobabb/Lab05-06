package com.example.milogin.Logic;

import java.io.Serializable;

public class User implements Serializable
{
    private String ID;
    private String password;
    private String name;
    private boolean privileged;

    public User(String id, String password, String name, boolean privileged){
        this.ID = id;
        this.password = password;
        this.name = name;
        this.privileged = privileged;
    }

    public User(String id, String password)
    {
        this(id,password,"", false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID()
    {
        return this.ID;
    }

    public void setID(String id)
    {
        this.ID = id;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isPrivileged()
    {
        return privileged;
    }

    public void setPrivileged(boolean privileged)
    {
        this.privileged = privileged;
    }
}
