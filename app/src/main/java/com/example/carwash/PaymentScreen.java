package com.example.carwash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up click listener for RelativeLayout 1
        RelativeLayout relativeLayout1 = findViewById(R.id.click_1);
        relativeLayout1.setOnClickListener(v -> {
            relativeLayout1.setBackgroundColor(Color.parseColor("#CAC3F1"));
            Intent intent = new Intent(PaymentScreen.this, Frame220.class);  // Replace with your desired Activity class
            startActivity(intent);
        });

        // Set up click listener for RelativeLayout 2
        RelativeLayout relativeLayout2 = findViewById(R.id.click_2);
        relativeLayout2.setOnClickListener(v -> {
            relativeLayout2.setBackgroundColor(Color.parseColor("#CAC3F1"));
            Intent intent = new Intent(PaymentScreen.this, Frame221.class);  // Replace with your desired Activity class
            startActivity(intent);
        });

        // Set up click listener for RelativeLayout 3
        RelativeLayout relativeLayout3 = findViewById(R.id.click_3);
        relativeLayout3.setOnClickListener(v -> {
            relativeLayout3.setBackgroundColor(Color.parseColor("#CAC3F1"));
            Intent intent = new Intent(PaymentScreen.this, Frame222.class);  // Replace with your desired Activity class
            startActivity(intent);
        });

        LinearLayout relativeLayout4 = findViewById(R.id.click_4);
        relativeLayout4.setOnClickListener(v -> {
            relativeLayout4.setBackgroundColor(Color.parseColor("#CAC3F1"));
            Intent intent = new Intent(PaymentScreen.this, Frame219.class);  // Replace with your desired Activity class
            startActivity(intent);
        });

        CardView backButton = findViewById(R.id.back1);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and go back to the previous activity
        });
    }
}


