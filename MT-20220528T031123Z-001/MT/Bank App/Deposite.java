package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Deposite extends AppCompatActivity {

    EditText ip;
    Button btn;
    String str;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposite);

        ip=findViewById(R.id.it);
        btn=findViewById(R.id.depo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            str =ip.getText().toString();
                Toast.makeText(Deposite.this,"deposited "+ str,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Deposite.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
