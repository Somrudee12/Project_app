package com.example.ngz.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainDB extends AppCompatActivity {
    Button btAdd, btView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_db);

        btAdd = findViewById(R.id.butAdd);
        btView = findViewById(R.id.butView);

        btAdd.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(getApplication(), Add.class);
                startActivity(intent);
            }
        });
        btView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(getApplication(), View.class);
                startActivity(intent);
            }
        });
    }
}
