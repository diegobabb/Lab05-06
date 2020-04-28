package com.example.milogin.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.milogin.Logic.User;
import com.example.milogin.R;


public class SignUp extends AppCompatActivity {
    private  LoginModel model;
    private EditText name;
    private EditText id;
    private EditText password;
    private Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.model = new LoginModel();
        this.name = findViewById(R.id.name);
        this.id = findViewById(R.id.id);
        this.password = findViewById(R.id.password);
        this.send = findViewById(R.id.send);

        this.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User new_user = new User(
                         id.getText().toString(),
                         password.getText().toString() ,
                         name.getText().toString(),
                        false
                );
                if(model.addUser(new_user)){
                    Toast.makeText(SignUp.this, "Usuario creado exitosamente", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignUp.this, "Usuario con id "+ new_user.getID() + " ya existe", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
