package com.example.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Frame225 extends AppCompatActivity {
    private static final String TAG = "Frame225";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_frame225);

            // Find the TextView by its ID
            TextView final1 = findViewById(R.id.final1);

            // Set an OnClickListener on the TextView
            final1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create an Intent to navigate to Frame228
                    Intent intent = new Intent(Frame225.this, Frame228.class);
                    startActivity(intent); // Start the new activity
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error setting content view: " + e.getMessage(), e);
        }
        CardView backButton = findViewById(R.id.back8);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and go back to the previous activity
        });
    }
}
