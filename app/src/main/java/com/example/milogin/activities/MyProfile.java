package com.example.milogin.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.milogin.Logic.CurrentUser;
import com.example.milogin.Logic.User;
import com.example.milogin.R;
import com.example.milogin.activities.jobApplication.JobApplication;
import com.example.milogin.activities.login.MainActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyProfile extends AppCompatActivity {

    private EditText old_pass;
    private EditText new_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        this.old_pass = findViewById(R.id.old_pass);
        this.new_pass = findViewById(R.id.new_pass);
        Button update = findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String real_old_pass = CurrentUser.getUser().getPassword();
                String input_old_pass = old_pass.getText().toString().trim();
                String input_new_pass = new_pass.getText().toString().trim();

                if(real_old_pass.equals(input_old_pass)){
                    Toast.makeText(MyProfile.this, "Password Update Successful!", Toast.LENGTH_SHORT).show();
                    CurrentUser.getUser().setPassword(input_new_pass);
                    Intent intent = new Intent(MyProfile.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    showDialog("ERROR","Incorrect Old Password");
                }
            }
        });
    }

    private void showDialog(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(msg)
                .setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }
}
