package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.dep:
                Intent intent = new Intent(MainActivity.this, Deposite.class);
                Toast.makeText(getApplicationContext(),"Deposite Selected",Toast.LENGTH_LONG).show();
                startActivity(intent);
                return true;
            case R.id.with:
                Intent intent2 = new Intent(MainActivity.this, Withdraw.class);
                Toast.makeText(getApplicationContext(),"Withdraw Selected",Toast.LENGTH_LONG).show();
                startActivity(intent2);
                return true;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"About Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

