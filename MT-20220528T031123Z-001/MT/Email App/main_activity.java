package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edText,edSubject;
    Button btnSend,btnAttachment;
    URI uri = null;

    private static final int PICK_FROM_GALLERY = 101;
    private Object URI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.email);
        edText = findViewById(R.id.emailMessage);
        edSubject = findViewById(R.id.emailSubject);

        btnSend = findViewById(R.id.buttonSend);
        btnAttachment = findViewById(R.id.buttonAttachment);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

        btnAttachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFolder();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK)
        {
            URI = data.getData();
            Toast.makeText(this, "This Toast Ran!", Toast.LENGTH_SHORT).show();

        }
    }


    public void sendEmail()
    {
        try {
            String email = edEmail.getText().toString();
            String subject = edSubject.getText().toString();
            String message = edText.getText().toString();

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);

            if(uri != null)
            {
                emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
            }
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);
            this.startActivity(Intent.createChooser(emailIntent,"Sending Email"));
        } catch (Exception e) {
            Toast.makeText(this, "Request Failed", Toast.LENGTH_SHORT).show();
        }

    }
    public void openFolder()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-date", true);
        startActivityForResult(Intent.createChooser(intent, "Complete Action Using"), PICK_FROM_GALLERY);
    }
}