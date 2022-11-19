package com.example.lab5profilemanager;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
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

        ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::onActivityResult);

        flag.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            profileActivityResultLauncher.launch(intent);
        });

        openMaps.setOnClickListener(view -> {
            // open google maps using and display address provided in teamAddress
        });

    }

    public String getFlagName(int id) {
        String drawableName;

        if (id == R.id.france) {
            drawableName = "flag_fr";
        } else if (id == R.id.egypt) {
            drawableName = "flag_eg";
        } else if (id == R.id.spain) {
            drawableName = "flag_sp";
        } else if (id == R.id.korea) {
            drawableName = "flag_kr";
        } else if (id == R.id.japan) {
            drawableName = "flag_jp";
        } else if (id == R.id.turkey) {
            drawableName = "flag_tr";
        } else if (id == R.id.greatBritain) {
            drawableName = "flag_uk";
        } else if (id == R.id.unitedStates) {
            drawableName = "flag_us";
        } else {
            drawableName = "flag_ca";
        }

        return drawableName;
    }

    public void onActivityResult(ActivityResult result) {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Intent data = result.getData();
            assert data != null;
            int id = data.getIntExtra("imageID", R.id.canada);
            String drawableName = getFlagName(id);
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            flag.setImageResource(resID);
        }
    }
}