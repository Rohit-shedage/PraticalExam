package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button closeButton;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeButton = findViewById(R.id.appKillButton);
        alertDialogBuilder = new AlertDialog.Builder(this);


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialogBuilder.setMessage("Do you really want to kill me?");

                alertDialogBuilder.setTitle("ALERT!");

                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();

                        Toast.makeText(MainActivity.this, "You have killed the App", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialogBuilder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                        Toast.makeText(MainActivity.this, "App is not killed", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialogBuilder.create();
                alertDialogBuilder.show();
            }
        });
    }

}