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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Frame221 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frame221);

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
        final Dialog dialog = new Dialog(Frame221.this);
        dialog.setContentView(R.layout.popup_frame255);

        // Get the background layout (this will be blurred)
        final ConstraintLayout backgroundLayout = findViewById(R.id.main);

        // Dim the background
        backgroundLayout.setAlpha(0.4f);

        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnDismissListener(dialogInterface -> {
            // Reset the background dimming when the dialog is dismissed
            backgroundLayout.setAlpha(1f);
        });



        // Set click listener for the dialog's window
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        View decorView = dialog.getWindow().getDecorView();
        decorView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    float x = event.getX();
                    float y = event.getY();

                    // Get the popup content view
                    View contentView = dialog.findViewById(R.id.popup_content);
                    if (contentView != null) {
                        int[] location = new int[2];
                        contentView.getLocationOnScreen(location);

                        float contentX = location[0];
                        float contentY = location[1];

                        // Check if touch is outside the popup content
                        if (x < contentX || x > contentX + contentView.getWidth() ||
                                y < contentY || y > contentY + contentView.getHeight()) {
                            backgroundLayout.setAlpha(1f);
                            dialog.dismiss();
                            return true;
                        }
                    }
                }
                return false;
            }
        });

        dialog.show();

        // Find the TextView (button1) and set an OnClickListener
        TextView button2 = dialog.findViewById(R.id.button10);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frame221.this, Frame251.class);
                startActivity(intent);
                dialog.dismiss();
                backgroundLayout.setAlpha(1f);
            }
        });
        CardView backButton = findViewById(R.id.back4);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and go back to the previous activity
        });
    }
}
