package com.example.milogin.DataAccess;

import com.example.milogin.Logic.Job;
import com.example.milogin.Logic.JobRequest;
import com.example.milogin.Logic.Person;
import com.example.milogin.Logic.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class Data {

    private static Data single_instance = null;
    private ArrayList<Job> jobs;
    private ArrayList<User> users;
    private ArrayList<JobRequest> jobRequests;
    private ArrayList<Person> people;
    private ArrayList<String> countries;

    private Data(){
        initJobs();
        initUsers();
        initPeople();
        initCountries();
        initJobRequests();
    }

    public static Data getInstance()
    {
        if (single_instance == null)
            single_instance = new Data();

        return single_instance;
    }

    private void initCountries(){
        Locale[] locales = Locale.getAvailableLocales();
        countries = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length()>0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        Collections.sort(countries);
    }

    private void initJobs(){
        jobs = new ArrayList<>();

        Job job = new Job(1, "Teacher");
        jobs.add(job);

        job = new Job(2, "Accountant");
        jobs.add(job);

        job = new Job(3, "Concierge");
        jobs.add(job);
    }

    private void initJobRequests(){
        jobRequests = new ArrayList<>();
        for (int i = 0;  i < 3; i++ ) {
            jobRequests.add(new JobRequest(people.get(i), jobs.get(i), new Date()));
        }
    }

    private void initPeople() {
        people = new ArrayList<>();
        people.add(new Person(
                "Florette",
                "Fairbridge",
                "9 Bultman Alley",
                "00984 Troy Place",
                "Myitkyina",
                "state1",
                1293,
                "Myanmar",
                "ffairbridge0@sohu.com",
                1293,
                79631452));
        people.add(new Person(
                "orah",
                "Klaff",
                "64 International Way",
                "161 Sunfield Avenue",
                "Al Majāridah",
                "state2",
                1548,
                "Saudi Arabia",
                "nklaff1@smugmug.com",
                9465,
                998342835));
        people.add(new Person(
                "Hanson",
                "Houseman",
                "480 Leroy Trail",
                "7 Dorton Point",
                "Pasco",
                "state3",
                5925,
                "Argentina",
                "hhouseman2@symantec.com",
                5709,
                49006677));
    }

    private void initUsers(){
        users = new ArrayList<>();

        User user = new User("402400313", "Josue", "111", true);
        users.add(user);

        user = new User("admin", "admin","Juan", true);
        users.add(user);

        user = new User("user", "user", "Maria", false);
        users.add(user);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public ArrayList<String> getCountries() {
        return countries;
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
