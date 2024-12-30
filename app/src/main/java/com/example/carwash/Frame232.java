package com.example.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Frame232 extends AppCompatActivity {
    private TextView[] passwordDots;
    private StringBuilder currentPassword;
    private static final int MAX_PASSWORD_LENGTH = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame232);

        // Initialize password dots
        passwordDots = new TextView[4];
        passwordDots[0] = findViewById(R.id.passwordDot1);
        passwordDots[1] = findViewById(R.id.passwordDot2);
        passwordDots[2] = findViewById(R.id.passwordDot3);
        passwordDots[3] = findViewById(R.id.passwordDot4);

        currentPassword = new StringBuilder();

        // Set up number buttons
        setupNumberButton(R.id.btn0, "0");
        setupNumberButton(R.id.btn1, "1");
        setupNumberButton(R.id.btn2, "2");
        setupNumberButton(R.id.btn3, "3");
        setupNumberButton(R.id.btn4, "4");
        setupNumberButton(R.id.btn5, "5");
        setupNumberButton(R.id.btn6, "6");
        setupNumberButton(R.id.btn7, "7");
        setupNumberButton(R.id.btn8, "8");
        setupNumberButton(R.id.btn9, "9");

        // Set up clear button
        Button clearButton = findViewById(R.id.btnClear);
        clearButton.setOnClickListener(v -> clearPassword());

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start HomeFragment activity
                Intent intent = new Intent(Frame232.this, HomeFragment.class);
                startActivity(intent);
            }
        });
    }

    private void setupNumberButton(int buttonId, String number) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> addNumber(number));
    }

    private void addNumber(String number) {
        if (currentPassword.length() < MAX_PASSWORD_LENGTH) {
            currentPassword.append(number);
            updatePasswordDisplay();
        }
    }

    private void clearPassword() {
        currentPassword.setLength(0);
        updatePasswordDisplay();
    }

    private void updatePasswordDisplay() {
        // Clear all dots
        for (int i = 0; i < MAX_PASSWORD_LENGTH; i++) {
            passwordDots[i].setText("");
        }

        // Fill in entered numbers
        for (int i = 0; i < currentPassword.length(); i++) {
            passwordDots[i].setText(String.valueOf(currentPassword.charAt(i)));
        }
    }
}