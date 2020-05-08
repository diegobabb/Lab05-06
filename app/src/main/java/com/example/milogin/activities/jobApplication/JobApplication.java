package com.example.milogin.activities.jobApplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
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
import com.example.milogin.activities.JobApplicationList.JobApplicationList;
import com.example.milogin.activities.login.MainActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class JobApplication extends AppCompatActivity {

    JobApplicationModel model;
    DatePickerDialog picker;
    private EditText firstname, lastname;
    private EditText street_address, street_address_2, city, state, zip;
    private EditText email;
    private EditText area_code, phone;
    private EditText start_date;
    private Spinner job, country;
    private Button send_data;
    private Toolbar toolbar;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_application);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setTitle("Job Application");
        model = new JobApplicationModel();

        // INICIALIZACION DE ELEMENTOS CON R
        initElements();

        // ERROR HANDLER
        model.getJobApplicationFormState().observe(this, new Observer<JobApplicationFormState>() {
            @Override
            public void onChanged(@Nullable JobApplicationFormState loginFormState) {

                if (loginFormState == null) {
                    return;
                }
                send_data.setEnabled(loginFormState.isDataValid());

                if (loginFormState.getFirstNameError() != null) {
                    firstname.setError(getString(loginFormState.getFirstNameError()));
                }
                if (loginFormState.getLastNameError() != null) {
                    lastname.setError(getString(loginFormState.getLastNameError()));
                }
                if (loginFormState.getStreetAdrrError() != null) {
                    street_address.setError(getString(loginFormState.getStreetAdrrError()));
                }
                if (loginFormState.getStreetAdrr2Error() != null) {
                    street_address_2.setError(getString(loginFormState.getStreetAdrr2Error()));
                }
                if (loginFormState.getCityError() != null) {
                    city.setError(getString(loginFormState.getCityError()));
                }
                if (loginFormState.getProvinceError() != null) {
                    state.setError(getString(loginFormState.getProvinceError()));
                }
                if (loginFormState.getZipError() != null) {
                    zip.setError(getString(loginFormState.getZipError()));
                }
                if (loginFormState.getEmailError() != null) {
                    email.setError(getString(loginFormState.getEmailError()));
                }
                if (loginFormState.getAreaError() != null) {
                    area_code.setError(getString(loginFormState.getAreaError()));
                }
                if (loginFormState.getPhoneError() != null) {
                    phone.setError(getString(loginFormState.getPhoneError()));
                }
                if (loginFormState.getDateError() != null) {
                    start_date.setError(getString(loginFormState.getDateError()));
                }
            }
        });

        //Inicializacion de spinner
        initSpinner();

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
                                start_date.setError(null);
                            }

                        }, year, month, day);
                picker.show();
            }
        });

        send_data.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                JobRequest jobRequest = getJobByFields();
                model.addJobRequest(jobRequest);
                Toast.makeText(getApplicationContext(), "Succefull!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getExtras() != null) {
                JobRequest jobRequest = (JobRequest) intent.getSerializableExtra(JobApplicationList.VER_JOBREQUEST);
                if (jobRequest != null) {
                    Person person = jobRequest.getApplicant();
                    this.firstname.setText(person.getFirstname());
                    this.firstname.setEnabled(false);
                    this.lastname.setText(person.getLastname());
                    this.lastname.setEnabled(false);
                    this.street_address.setText(person.getStreet_address());
                    this.street_address.setEnabled(false);
                    this.street_address_2.setText(person.getStreet_address_2());
                    this.street_address_2.setEnabled(false);
                    this.city.setText(person.getCity());
                    this.city.setEnabled(false);
                    this.state.setText(person.getState());
                    this.state.setEnabled(false);
                    this.zip.setText(Integer.toString(person.getZip()));
                    this.zip.setEnabled(false);
                    this.country.setSelection(model.getCountries().indexOf(person.getCountry()));
                    this.country.setEnabled(false);
                    this.email.setText(person.getEmail());
                    this.email.setEnabled(false);
                    this.area_code.setText(Integer.toString(person.getArea_code()));
                    this.area_code.setEnabled(false);
                    this.phone.setText(Integer.toString(person.getPhone()));
                    this.phone.setEnabled(false);
                    this.job.setSelection(model.getJobs().indexOf(jobRequest.getJob()));
                    this.job.setEnabled(false);
                    this.start_date.setText(android.text.format.DateFormat.format("dd/MM/yyyy", jobRequest.getStart_date()));
                    this.start_date.setEnabled(false);
                    this.send_data.setEnabled(false);
                }
            }
        }
    }

    private void initSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, model.getJobsNames());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.job.setAdapter(adapter);
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, model.getCountries());

        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.country.setAdapter(adapterCountry);
    }

    private JobRequest getJobByFields() {

        Date date = picker == null ? new Date() : new Date(picker.getDatePicker().getYear(), picker.getDatePicker().getMonth(), picker.getDatePicker().getDayOfMonth());
        int zip = (this.zip.getText().toString().isEmpty()) ? 1 : Integer.parseInt(this.zip.getText().toString());
        int area_code = (this.area_code.getText().toString().isEmpty()) ? 1 : Integer.parseInt(this.area_code.getText().toString());
        int phone = (this.phone.getText().toString().isEmpty()) ? 1 : Integer.parseInt(this.phone.getText().toString());
        Job job = model.getJobByIndex(this.job.getSelectedItemPosition());

        Person applicant = new Person(
                firstname.getText().toString().trim(),
                lastname.getText().toString().trim(),
                street_address.getText().toString().trim(),
                street_address_2.getText().toString().trim(),
                city.getText().toString().trim(),
                state.getText().toString().trim(),
                zip,
                country.getSelectedItem().toString(),
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
        switch (item.getItemId()) {
            case R.id.logout:
                Toast.makeText(getApplicationContext(), "See ya!", Toast.LENGTH_LONG).show();
                intent = new Intent(JobApplication.this, MainActivity.class);
                CurrentUser.setUser(null);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    private void initElements() {
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

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                model.dataChanged(
                        firstname.getText().toString().trim(),
                        lastname.getText().toString().trim(),
                        street_address.getText().toString().trim(),
                        street_address_2.getText().toString().trim(),
                        city.getText().toString().trim(),
                        state.getText().toString().trim(),
                        zip.getText().toString().trim(),
                        email.getText().toString().trim(),
                        area_code.getText().toString().trim(),
                        phone.getText().toString().trim(),
                        start_date.getText().toString().trim()
                );
            }
        };

        // Ligamos los eventos
        this.firstname.addTextChangedListener(afterTextChangedListener);
        this.lastname.addTextChangedListener(afterTextChangedListener);
        this.street_address.addTextChangedListener(afterTextChangedListener);
        this.street_address_2.addTextChangedListener(afterTextChangedListener);
        this.city.addTextChangedListener(afterTextChangedListener);
        this.state.addTextChangedListener(afterTextChangedListener);
        this.zip.addTextChangedListener(afterTextChangedListener);
        this.email.addTextChangedListener(afterTextChangedListener);
        this.area_code.addTextChangedListener(afterTextChangedListener);
        this.phone.addTextChangedListener(afterTextChangedListener);
        this.start_date.addTextChangedListener(afterTextChangedListener);
        send_data.setEnabled(true);
    }
}
