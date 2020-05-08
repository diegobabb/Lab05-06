package com.example.milogin.activities.JobApplicationList;

import com.example.milogin.Logic.JobRequest;

import java.util.ArrayList;

public class JobApplicationModel {

    private ArrayList<JobRequest> mDataset;

    public ArrayList<JobRequest> getmDataset() {
        return mDataset;
    }

    public JobApplicationModel(ArrayList<JobRequest> mDataset) {
        this.mDataset = mDataset;
    }
}
