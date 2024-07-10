package com.example.intellicasepro;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TrainingActivity extends AppCompatActivity {

    private static final String TAG = "TrainingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.training_activity);

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Set up buttons
        Button downloadHandbookButton = findViewById(R.id.downloadHandbookButton);
        Button downloadChecklistButton = findViewById(R.id.downloadChecklistButton);
        Button watchWebinarButton = findViewById(R.id.watchWebinarButton);

        downloadHandbookButton.setOnClickListener(view -> downloadFile("https://www.example.com/surveillance_handbook.pdf", "Surveillance Handbook.pdf"));
        downloadChecklistButton.setOnClickListener(view -> downloadFile("https://www.example.com/legal_compliance_checklist.pdf", "Legal Compliance Checklist.pdf"));
        watchWebinarButton.setOnClickListener(view -> watchVideo("https://www.youtube.com/watch?v=rUD7R31ZsXk&ab_channel=NationalGeographic")); // Replace with actual YouTube video URL
    }

    private void downloadFile(String url, String fileName) {
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.setTitle(fileName);
            request.setDescription("Downloading " + fileName);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

            DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            if (downloadManager != null) {
                downloadManager.enqueue(request);
                Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Download started for: " + url);
            } else {
                Toast.makeText(this, "Download manager is not available", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Download manager is not available");
            }
        } catch (Exception e) {
            Toast.makeText(this, "Download failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Download failed", e);
        }
    }

    private void watchVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.putExtra("force_fullscreen", true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No application can handle this request. Please install a web browser or YouTube app", Toast.LENGTH_LONG).show();
            Log.e(TAG, "No application can handle this request.");
        }
    }
}
