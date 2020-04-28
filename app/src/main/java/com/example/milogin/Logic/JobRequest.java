package com.example.milogin.Logic;

import java.util.Date;

public class JobRequest {

    private Person applicant;
    private Date start_date;
    private Job job;

    public JobRequest(Person applicant, Job job, Date date){

        this.applicant = applicant;
        this.job = job;
        this.start_date = date;
    }

    public JobRequest(){
        this(new Person(),new Job(), new Date());
    }

    public Person getApplicant(){return applicant;}

    public Date getStart_date(){
        return start_date;
    }

    public Job getJob(){
        return job;
    }

    public void setApplicant(Person person){this.applicant = person;}

    public void setStart_date(Date start_date){
        this.start_date = start_date;
    }

    public void setJob(Job job){
        this.job = job;
    }

    @Override
    public String toString() {
        return "JobRequest{" +
                "applicant=" + applicant +
                ", start_date=" + start_date +
                ", job=" + job +
                '}';
    }
}
