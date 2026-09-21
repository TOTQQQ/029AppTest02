package com.example.a029apptest02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openLinear(View v) {
        startActivity(new Intent(this, LinearLayoutActivity.class));
    }

    public void openTable(View v) {
        startActivity(new Intent(this, TableLayoutActivity.class));
    }

    public void openCalculator(View v) {
        startActivity(new Intent(this, CalculatorActivity.class));
    }

    public void openSpaceTravel(View v) {
        startActivity(new Intent(this, SpaceTravelActivity.class));
    }

    public void openCompose(View v) {
        startActivity(new Intent(this, ComposeActivity.class));
    }
}
