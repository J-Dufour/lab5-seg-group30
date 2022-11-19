package com.example.lab5profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findViewById(R.id.france).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.egypt).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.canada).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.spain).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.korea).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.japan).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.turkey).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.greatBritain).setOnClickListener(this::setTeamIcon);
        findViewById(R.id.unitedStates).setOnClickListener(this::setTeamIcon);

    }

    public void setTeamIcon(View view) {
        Intent returnIntent = new Intent();

        ImageView selectedImage = (ImageView) view;

        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        finish();
    }


}