package com.example.intellicasepro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPassword;
    private Button buttonUpdateProfile, buttonUpdateNotifications, buttonUpdatePrivacy, buttonTrainingResources, buttonProfile;
    private CheckBox checkBoxEmailNotifications, checkBoxSmsNotifications, checkBoxProfileVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile Settings");

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonUpdateProfile = findViewById(R.id.buttonUpdateProfile);
        buttonUpdateNotifications = findViewById(R.id.buttonUpdateNotifications);
        buttonUpdatePrivacy = findViewById(R.id.buttonUpdatePrivacy);
        checkBoxEmailNotifications = findViewById(R.id.checkBoxEmailNotifications);
        checkBoxSmsNotifications = findViewById(R.id.checkBoxSmsNotifications);
        checkBoxProfileVisibility = findViewById(R.id.checkBoxProfileVisibility);
        buttonTrainingResources = findViewById(R.id.buttonTrainingResources);
        buttonProfile = findViewById(R.id.buttonProfile);

        buttonTrainingResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, TrainingActivity.class);
                startActivity(intent);
            }
        });

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Add functionality to buttons here
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
