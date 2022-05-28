package com.example.playerandpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView fetchPlayerName, fetchPlayerPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fetchPlayerName = findViewById(R.id.fetchPlayerName);
        fetchPlayerPoints = findViewById(R.id.fetchPlayerPoints);

        Intent intent = getIntent();
        String player_name = intent.getStringExtra("Player Name");
        String player_points = intent.getStringExtra("Player Points");

        fetchPlayerName.setText(player_name);
        fetchPlayerPoints.setText(player_points);


    }
}