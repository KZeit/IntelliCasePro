package com.example.intellicasepro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    private Button buttonSettings, buttonTrainingResources, buttonViewCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Investigator Profile");

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Get the username passed from the login screen
        String username = getIntent().getStringExtra("USERNAME");

        // Initialize TextViews
        TextView tvName = findViewById(R.id.textViewName);
        TextView tvExperience = findViewById(R.id.textViewExperience);
        TextView tvSpecialty = findViewById(R.id.textViewSpecialty);
        TextView tvContact = findViewById(R.id.textViewContact);

        // Set TextView values
        tvName.setText(username);
        tvExperience.setText("5 years");
        tvSpecialty.setText("Undercover, Surveillance");
        tvContact.setText("johndoe@intellicasepro.com");

        // Initialize Buttons
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonTrainingResources = findViewById(R.id.buttonTrainingResources);
        buttonViewCases = findViewById(R.id.buttonViewCases);

        // Set Click Listeners
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        buttonTrainingResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, TrainingActivity.class);
                startActivity(intent);
            }
        });;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
