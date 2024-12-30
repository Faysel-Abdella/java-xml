package com.example.carwash;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Frame228 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_frame228);

            // Find the TextView by its ID
            TextView final2 = findViewById(R.id.final2);

            // Set an OnClickListener on the TextView
            final2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create an Intent to navigate to Frame228
                    Intent intent = new Intent(Frame228.this, Frame229.class);
                    startActivity(intent); // Start the new activity
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error setting content view: " + e.getMessage(), e);
        }
    }
}