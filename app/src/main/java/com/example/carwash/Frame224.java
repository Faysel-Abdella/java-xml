package com.example.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Frame224 extends AppCompatActivity {
    private static final String TAG = "Frame224";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_frame224);
        } catch (Exception e) {
            Log.e(TAG, "Error setting content view: " + e.getMessage(), e);
        }

        TextView textView = findViewById(R.id.button16);
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
                    Intent intent = new Intent(Frame224.this, Frame225.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e(TAG, "Error starting Frame223: " + e.getMessage(), e);

                }
            }
        });
        CardView backButton = findViewById(R.id.back7);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and go back to the previous activity
        });
    }
}