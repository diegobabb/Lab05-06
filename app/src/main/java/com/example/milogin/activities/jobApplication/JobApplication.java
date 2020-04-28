package com.example.milogin.activities.jobApplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.milogin.R;
import com.example.milogin.Logic.Job;
import com.example.milogin.Logic.JobRequest;
import com.example.milogin.Logic.Person;
import com.example.milogin.Logic.CurrentUser;
import com.example.milogin.activities.MyProfile;
import com.example.milogin.activities.login.MainActivity;

import java.util.Calendar;
import java.util.Date;

public class JobApplication extends AppCompatActivity {

    JobApplicationModel model;
    DatePickerDialog picker;
    private EditText firstname, lastname;
    private EditText street_address, street_address_2, city, state, zip, country;
    private EditText email;
    private EditText area_code, phone;
    private EditText start_date;
    private Spinner job;
    private Button send_data;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_application);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setTitle("Job Application");
        model = new JobApplicationModel();

        // Inicializacion de los campos
        this.firstname = findViewById(R.id.first_name);
        this.lastname = findViewById(R.id.last_name);
        this.street_address = findViewById(R.id.street_address_line);
        this.street_address_2 = findViewById(R.id.street_address_line2);
        this.city = findViewById(R.id.city);
        this.state = findViewById(R.id.province);
        this.zip = findViewById(R.id.postal_code);
        this.country = findViewById(R.id.country);
        this.email = findViewById(R.id.email);
        this.area_code = findViewById(R.id.area_code);
        this.phone = findViewById(R.id.phone_number);
        this.job = findViewById(R.id.position);
        this.start_date = findViewById(R.id.start_date);
        this.send_data = findViewById(R.id.send_data);

        //Inicializacion de spinner
        initSpinner();;

        // Evento para que muestra el calendario
        // BY https://www.tutlane.com/tutorial/android/android-datepicker-with-examples
        start_date.setInputType(InputType.TYPE_NULL);
        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(JobApplication.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                start_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }

                        }, year, month, day);
                picker.show();
            }
        });

        send_data.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                JobRequest jobRequest = getJobByFields();
                model.addJobRequest(jobRequest);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

    }

    private void initSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, model.getJobsNames());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.job.setAdapter(adapter);
    }

    private JobRequest getJobByFields(){

        Date date = picker == null ? new Date() : new Date(picker.getDatePicker().getYear(), picker.getDatePicker().getMonth(), picker.getDatePicker().getDayOfMonth());
        int zip = (this.zip.getText().toString().isEmpty()) ? 1 : Integer.parseInt(this.zip.getText().toString());
        int area_code = (this.area_code.getText().toString().isEmpty()) ? 1 : Integer.parseInt(this.area_code.getText().toString());
        int phone = (this.phone.getText().toString().isEmpty()) ? 1 : Integer.parseInt(this.phone.getText().toString());
        Job job = model.getJobByIndex(this.job.getSelectedItemPosition());

        Person applicant = new Person(
                firstname.getText().toString().trim() + "" + lastname.getText().toString().trim(),
                street_address.getText().toString().trim(),
                street_address_2.getText().toString().trim(),
                city.getText().toString().trim(),
                state.getText().toString().trim(),
                zip,
                country.getText().toString().trim(),
                email.getText().toString().trim(),
                area_code,
                phone);

        return new JobRequest(applicant, job, date);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.logout:
                Toast.makeText(getApplicationContext(), "See ya!",Toast.LENGTH_LONG).show();
                intent = new Intent(JobApplication.this, MainActivity.class);
                CurrentUser.setUser(null);
                startActivity(intent);
                break;
            case R.id.upt_pass:
                intent = new Intent(JobApplication.this, MyProfile.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
