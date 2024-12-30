package com.example.carwash;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Frame222 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frame222);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Show the popup after 3 seconds (adjust as needed)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showPopupMessage();
            }
        }, 3000); // Delay of 3 seconds
    }

    private void showPopupMessage() {
        // Create a Dialog
        final Dialog dialog = new Dialog(Frame222.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_frame256);

        // Set the dialog background to transparent
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        final ConstraintLayout backgroundLayout = findViewById(R.id.main);
        // Dim the background
        backgroundLayout.setAlpha(0.4f);

        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnDismissListener(dialogInterface -> {
            // Reset the background dimming when the dialog is dismissed
            backgroundLayout.setAlpha(1f);
        });// Allow closing the dialog by clicking outside
        dialog.show();

        // Immediately dismiss the dialog on any touch event in the background (single click)
        backgroundLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset background opacity
                backgroundLayout.setAlpha(1f);
                // Dismiss the dialog with a single click
                dialog.dismiss();
            }
        });

        // Prevent the dialog from closing when touched inside
        dialog.setOnCancelListener(null);

        // Find the TextView (button1) and set an OnClickListener
        TextView button1 = dialog.findViewById(R.id.button11);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the new activity
                Intent intent = new Intent(Frame222.this, Frame251.class);  // Replace NewActivity.class with your target activity class
                startActivity(intent);  // Start the new activity
                dialog.dismiss();  // Dismiss the popup
                backgroundLayout.setAlpha(1f);  // Reset the background dimming
            }
        });

        CardView backButton = findViewById(R.id.back5);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and go back to the previous activity
        });
    }
}
