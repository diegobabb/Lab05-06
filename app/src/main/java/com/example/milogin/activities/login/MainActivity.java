package com.example.milogin.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milogin.Logic.CurrentUser;
import com.example.milogin.activities.JobApplicationList.JobApplicationList;
import com.example.milogin.activities.jobApplication.JobApplication;
import com.example.milogin.R;
import com.example.milogin.Logic.User;

public class MainActivity extends AppCompatActivity {

    private EditText id;
    private EditText password;
    private Button login;
    private TextView signUp;
    private LoginModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.model = new LoginModel();

        this.id = (EditText) findViewById(R.id.cedula);
        this.password = (EditText) findViewById(R.id.clave);

        this.login = (Button) findViewById(R.id.ingresar);

        this.signUp = findViewById(R.id.signUp);

        if(signUp!=null) signUp.requestFocus();

        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(id.getText().toString(), password.getText().toString());
                User user_founded = model.validate(user);

                if(user_founded != null){
                    CurrentUser.setUser(user_founded);
                    acceder(user_founded.isPrivileged());
                }
                else{
                    Toast.makeText(MainActivity.this, "Credenciales invalidas", Toast.LENGTH_LONG).show();
                }
            }
        });

        this.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

    }

    private void acceder(boolean privileged){
        Intent intent = privileged ? new Intent(MainActivity.this, JobApplicationList.class) : new Intent(MainActivity.this, JobApplication.class);
        startActivity(intent);
    }
}
