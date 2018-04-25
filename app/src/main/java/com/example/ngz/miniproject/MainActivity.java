package com.example.ngz.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2;
    AutoCompleteTextView tvUsername,tvPassword;
    //    TextView tv3,tv4;
    Manage Manage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.butLogin);
        bt2 = findViewById(R.id.butRegister);
        tvUsername = findViewById(R.id.textUsername);
        tvPassword = findViewById(R.id.textPassword);
        Manage = new Manage(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = tvUsername.getText().toString();
                String password = tvPassword.getText().toString();

                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input User name !!", Toast.LENGTH_SHORT).show();
                    tvUsername.requestFocus();
                } else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input Password !!", Toast.LENGTH_SHORT).show();
                    tvPassword.requestFocus();
                } else {
                    boolean isSuccess = Manage.checkLoginValidate(username, password);
                    if (isSuccess) {
                        Intent intent = new Intent(getApplication(), MainDB.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), Register.class);
                startActivity(intent);
            }
        });
    }
}
