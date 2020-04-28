package com.example.milogin.activities.jobApplication;

import com.example.milogin.DataAccess.Data;
import com.example.milogin.Logic.Job;
import com.example.milogin.Logic.JobRequest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.milogin.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class JobApplicationModel {

    private ArrayList<Job> jobs = Data.getInstance().getJobs();
    private MutableLiveData<JobApplicationFormState> jobApplicationFormState = new MutableLiveData<>();
    private MutableLiveData<JobApplicationFormResult> jobApplicationFormResult = new MutableLiveData<>();

    LiveData<JobApplicationFormState> getJobApplicationFormState() {
        return jobApplicationFormState;
    }

    LiveData<JobApplicationFormResult> getJobApplicationFormResult() {
        return jobApplicationFormResult;
    }

    public ArrayList<String> getJobsNames(){

        ArrayList<String> jobs_names = new ArrayList<>();
        for(Job job: jobs){
            jobs_names.add(job.getDescription().toString());
        }

        return jobs_names;
    }

    public ArrayList<String> getCountries(){
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length()>0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        Collections.sort(countries);
        return countries;
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

    // ERROR HANDLER
    public void dataChanged(String first_name, String last_name, String street_address, String street_address_2,
                            String city, String province, String zip, String email, String area, String phone, String start_date) {
        JobApplicationFormState state = new JobApplicationFormState();
        String email_regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        if (first_name.matches(".*\\d.*") || first_name.length() < 2 || first_name.length() > 15) {
            state.setFirstNameError(R.string.invalid_firstname);
            jobApplicationFormState.setValue(state);
        } else if (last_name.matches(".*\\d.*") || last_name.length() < 2 || last_name.length() > 15) {
            state.setLastNameError(R.string.invalid_lastname);
            jobApplicationFormState.setValue(state);
        } else if (street_address.length() < 5 || street_address.length() > 30) {
            state.setStreetAdrrError(R.string.invalid_street);
            jobApplicationFormState.setValue(state);
        } else if (street_address_2.length() < 5 || street_address_2.length() > 30) {
            state.setStreetAdrr2Error(R.string.invalid_street2);
            jobApplicationFormState.setValue(state);
        } else if (city.length() < 3 || city.length() > 30) {
            state.setCityError(R.string.invalid_city);
            jobApplicationFormState.setValue(state);
        } else if (province.length() < 5 || province.length() > 30) {
            state.setProvinceError(R.string.invalid_province);
            jobApplicationFormState.setValue(state);
        } else if (!zip.matches("[0-9]+") || zip.length() < 2 || zip.length() > 6) {
            state.setZipError(R.string.invalid_zip);
            jobApplicationFormState.setValue(state);
        } else if (!email.matches(email_regex)) {
            state.setEmailError(R.string.invalid_email);
            jobApplicationFormState.setValue(state);
        } else if (!area.matches("[0-9]+") || area.length() != 3) {
            state.setAreaError(R.string.invalid_area);
            jobApplicationFormState.setValue(state);
        } else if (!phone.matches("[0-9]+") || phone.length() < 8 || phone.length() > 10) {
            state.setPhoneError(R.string.invalid_phone);
            jobApplicationFormState.setValue(state);
        } else if (start_date.isEmpty()) {
            state.setDateError(R.string.invalid_date);
            jobApplicationFormState.setValue(state);
        } else {
            jobApplicationFormState.setValue(new JobApplicationFormState(true));
        }
    }

}
