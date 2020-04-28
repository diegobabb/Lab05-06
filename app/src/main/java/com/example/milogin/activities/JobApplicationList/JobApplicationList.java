package com.example.milogin.activities.JobApplicationList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.milogin.R;
import com.example.milogin.Logic.CurrentUser;
import com.example.milogin.activities.login.MainActivity;

public class JobApplicationList extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(JobApplicationList.this, "Hola de nuevo, " + CurrentUser.getUser().getName() , Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_application_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setTitle("Job Request List");
    }
}