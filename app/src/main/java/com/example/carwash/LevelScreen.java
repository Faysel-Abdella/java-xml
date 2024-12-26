package com.example.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LevelScreen extends AppCompatActivity {

//      LevelGridAdapter gridAdapter;
//      GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_screen);

//        gridAdapter= new LevelGridAdapter(this, Arrays.asList(customerLevelList));
//        gridView = findViewById(R.id.gr);
//        gridView.setAdapter(gridAdapter);

//        ViewCompat.setOnApplyWindowInsetsListener(gridView, (v, insets) -> {
//            Insets systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            // Adjust margins or padding based on insets
//            return insets.consumeStableInsets();
//        });
    }
   

    public void onFrenchClicked(View view) {
    }

    public void onUSClicked(View view) {
    }

    public void onSouthKoreaClicked(View view) {
    }

    public void onGridClicked(View view) {
        Intent intent = new Intent(this, PaymentScreen.class);
        startActivity(intent);
    }
}