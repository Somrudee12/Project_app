package com.example.ngz.miniproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    AutoCompleteTextView tvUsername, tvPassword, tvConfirmPassword;
    Button btRegister;
    Manage manage;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvUsername = findViewById(R.id.RegitserUser);
        tvPassword = findViewById(R.id.RegisterPass);
        tvConfirmPassword = findViewById(R.id.RegisterConfirm);
        btRegister = findViewById(R.id.butRegister);
        manage = new Manage(this);
        context = this;

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = tvUsername.getText().toString();
                String password = tvPassword.getText().toString();
                String confirm = tvConfirmPassword.getText().toString();

                if (username.isEmpty()) {
                    Toast.makeText(context, "Please input User name !!", Toast.LENGTH_SHORT).show();
                    tvUsername.requestFocus();
                } else if (password.isEmpty()) {
                    Toast.makeText(context, "Please input Password !!", Toast.LENGTH_SHORT).show();
                    tvPassword.requestFocus();
                } else if (confirm.isEmpty()) {
                    Toast.makeText(context, "Please input Confirm Password !!", Toast.LENGTH_SHORT).show();
                    tvConfirmPassword.requestFocus();
                } else if (!password.equals(confirm)) {
                    Toast.makeText(context, "Password does not match the confirm password. Please try again !!", Toast.LENGTH_SHORT).show();
                    tvConfirmPassword.requestFocus();
                } else if (password.equals(confirm)) {
                    boolean isSuccess = false;
                    isSuccess = manage.registerUser(username, password);

                    if (isSuccess) {
                        Toast.makeText(getApplicationContext(), "register success", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "register failed, Please try again!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
