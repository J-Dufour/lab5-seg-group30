package com.example.lab5profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView flag;
    Button openMaps;
    EditText teamName, teamAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flag = findViewById(R.id.imageView);
        teamName = findViewById(R.id.teamName);
        teamAddress = findViewById(R.id.teamAddress);
        openMaps = findViewById(R.id.openMaps);


        flag.setOnClickListener(view -> {
            // open new ProfileActivity, choose flag, and display it here
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });

        openMaps.setOnClickListener(view -> {
            // open google maps using and display address provided in teamAddress
        });

    }
}