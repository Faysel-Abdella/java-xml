package com.example.carwash;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Frame220 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frame220);

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
        }, 5000); // Delay of 5 seconds
    }

    private void showPopupMessage() {
        // Create a Dialog
        final Dialog dialog = new Dialog(Frame220.this);
        dialog.setContentView(R.layout.popup_frame254);

        // Ensure the dialog's background is transparent to honor the layout's rounded corners
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        // Enable dismissing the dialog when clicking outside
        dialog.setCanceledOnTouchOutside(true);

        // Get the background layout (this will be blurred)
        final RelativeLayout backgroundLayout = findViewById(R.id.main);

        // Dim the background
        backgroundLayout.setAlpha(0.4f);

        dialog.setOnDismissListener(dialogInterface -> {
            // Reset the background dimming when the dialog is dismissed
            backgroundLayout.setAlpha(1f);
        });

        dialog.show();

        // Find the TextView (button1) and set an OnClickListener
        TextView button1 = dialog.findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            // Create an Intent to open the new activity
            Intent intent = new Intent(Frame220.this, Frame251.class); // Replace with your target activity class
            startActivity(intent); // Start the new activity
            dialog.dismiss(); // Dismiss the popup
            backgroundLayout.setAlpha(1f); // Reset the background dimming
        });
        CardView backButton = findViewById(R.id.back2);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and go back to the previous activity
        });
    }
}
