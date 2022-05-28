package com.example.smsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText vareditTextNumber, vareditTextMessage;
    Button varsubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submitButton);

        final EditText editTextNumber = findViewById(R.id.editTextNumber);
        final EditText editTextMessage = findViewById(R.id.editTextMessage);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = editTextMessage.getText().toString();
                String phoneNo = editTextNumber.getText().toString();

                if(!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo))
                {

                    Uri uri = Uri.parse("smsto:YOUR_SMS_NUMBER" + phoneNo);
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra("sms_body", "" + message);
                    startActivity(intent);
                }
            }
        });
    }
}