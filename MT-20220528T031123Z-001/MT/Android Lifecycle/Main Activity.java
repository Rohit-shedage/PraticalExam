package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle" , "onCreate has been called here");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle" , "onStart has been called here");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle" , "onPause has been called here");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle" , "onStop has been called here");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle" , "onResume has been called here");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle" , "onRestart has been called here");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle" , "onDestroy has been called here");
    }
}