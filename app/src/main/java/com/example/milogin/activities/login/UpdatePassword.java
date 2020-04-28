package com.example.milogin.activities.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.milogin.Logic.User;
import com.example.milogin.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePassword extends AppCompatActivity {

    private LoginModel model;
    private EditText user_id;
    private EditText old_pass;
    private EditText new_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        this.model = new LoginModel();
        this.old_pass = findViewById(R.id.old_pass);
        this.new_pass = findViewById(R.id.new_pass);
        this.user_id = findViewById(R.id.user_id);
        Button update = findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = model.getUserByID(user_id.getText().toString().trim());
                if (user != null) {
                    String input_old_pass = old_pass.getText().toString().trim();
                    String input_new_pass = new_pass.getText().toString().trim();

                    if (user.getPassword().equals(input_old_pass)) {
                        Toast.makeText(UpdatePassword.this, "Password Update Successful!", Toast.LENGTH_SHORT).show();
                        user.setPassword(input_new_pass);
                        Intent intent = new Intent(UpdatePassword.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        showDialog("ERROR", "Incorrect Old Password");
                    }
                } else {
                    showDialog("ERROR", "User doesn't exist!");
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
