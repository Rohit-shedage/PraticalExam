package com.example.playerandpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText playerName, playerPoints;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerName = findViewById(R.id.editTextPlayerName);
        playerPoints = findViewById(R.id.editTextPlayerPoints);
        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String player_name_data = playerName.getText().toString();
                String player_points_data = playerPoints.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Second.class);
                intent.putExtra("Player Name", player_name_data);
                intent.putExtra("Player Points", player_points_data);
                startActivity(intent);

            }
        });
    }
}