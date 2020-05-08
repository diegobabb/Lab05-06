package com.example.milogin.activities.jobApplication;

import com.example.milogin.DataAccess.Data;
import com.example.milogin.Logic.Job;
import com.example.milogin.Logic.JobRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class JobApplicationModel {
    private ArrayList<Job> jobs;
    private ArrayList<String> countries;

    public JobApplicationModel() {
        this.jobs = Data.getInstance().getJobs();
        this.countries = Data.getInstance().getCountries();
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public ArrayList<String> getJobsNames(){

        ArrayList<String> jobs_names = new ArrayList<>();
        for(Job job: jobs){
            jobs_names.add(job.getDescription().toString());
        }

        return jobs_names;
    }

    public void addJobRequest(JobRequest request){
        Data.getInstance().getJobRequests().add(request);
    }

    public Job getJobByIndex(int index){
        return jobs.get(index);
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }
}
