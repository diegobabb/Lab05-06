package com.example.milogin.DataAccess;

import com.example.milogin.Logic.Job;
import com.example.milogin.Logic.JobRequest;
import com.example.milogin.Logic.User;

import java.util.ArrayList;

public class Data {

    private static Data single_instance = null;
    private ArrayList<Job> jobs;
    private ArrayList<User> users;
    private ArrayList<JobRequest> jobRequests;

    private Data(){
        jobs = initJobs();
        users = initUsers();
        jobRequests = new ArrayList<>();
    }

    public static Data getInstance()
    {
        if (single_instance == null)
            single_instance = new Data();

        return single_instance;
    }

    private ArrayList<Job> initJobs(){
        ArrayList<Job> jobs = new ArrayList<>();

        Job job = new Job(1, "Teacher");
        jobs.add(job);

        job = new Job(2, "Accountant");
        jobs.add(job);

        job = new Job(3, "Concierge");
        jobs.add(job);

        return jobs;
    }

    private ArrayList<User> initUsers(){
        ArrayList<User> users = new ArrayList<>();

        User user = new User("402400313", "Josue", "111", true);
        users.add(user);

        user = new User("admin", "admin","Juan", true);
        users.add(user);

        user = new User("user", "user", "Maria", false);
        users.add(user);

        return users;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<JobRequest> getJobRequests() {
        return jobRequests;
    }

    // USER CRUD

    public boolean addUser(User user){
        for(User u: users){
            if(u.getID().equals(user.getID())) return false;
        }
        users.add(user);
        return true;
    }
}
