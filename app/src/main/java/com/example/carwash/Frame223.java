package com.example.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Frame223 extends AppCompatActivity {
    private static final String TAG = "Frame223";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_frame223);
        } catch (Exception e) {
            Log.e(TAG, "Error setting content view: " + e.getMessage(), e);
        }
        TextView textView = findViewById(R.id.button15);
        if (textView == null) {
            Log.e(TAG, "TextView with id 'button14' not found!");
            return;
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button clicked");
                try {

                    // Create and start the intent
                    Intent intent = new Intent(Frame223.this, Frame224.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e(TAG, "Error starting Frame223: " + e.getMessage(), e);

                }
            }
        });
        CardView backButton = findViewById(R.id.back6);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and go back to the previous activity
        });
    }
}