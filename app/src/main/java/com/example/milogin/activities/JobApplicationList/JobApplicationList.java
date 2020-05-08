package com.example.milogin.activities.JobApplicationList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.milogin.DataAccess.Data;
import com.example.milogin.Logic.JobRequest;
import com.example.milogin.R;
import com.example.milogin.Logic.CurrentUser;
import com.example.milogin.activities.jobApplication.JobApplication;
import com.example.milogin.activities.login.MainActivity;

import java.util.ArrayList;
import java.util.Date;

public class JobApplicationList extends AppCompatActivity implements JobApplicationAdapter.OnClickItem {

    public static String VER_JOBREQUEST = "JOBREQUEST";
    private JobApplicationModel jobApplicationModel;
    private JobApplicationAdapter jobApplicationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(JobApplicationList.this, "Hola de nuevo, " + CurrentUser.getUser().getName() , Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);

        jobApplicationModel = new JobApplicationModel(Data.getInstance().getJobRequests());

        setContentView(R.layout.activity_job_application_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setTitle("Job Request List");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(layoutManager);

        jobApplicationAdapter = new JobApplicationAdapter(jobApplicationModel.getmDataset(), this);
        recyclerView.setAdapter(jobApplicationAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logout:
                Toast.makeText(getApplicationContext(), "See ya!",Toast.LENGTH_LONG).show();
                CurrentUser.setUser(null);
                Intent intent = new Intent(JobApplicationList.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void onClickItem(int position) {
        Intent intent = new Intent(this, JobApplication.class);
        intent.putExtra(JobApplicationList.VER_JOBREQUEST, jobApplicationModel.getmDataset().get(position));
        startActivity(intent);
    }
}