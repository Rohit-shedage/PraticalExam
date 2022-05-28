package com.example.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText insertName, insertEmail, insertNumber;
    Button buttonInsert, buttonUpdate, buttonDelete, buttonView;
    DBhelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertName = findViewById(R.id.editTextName);
        insertEmail = findViewById(R.id.editTextEmail);
        insertNumber = findViewById(R.id.editTextNumber);

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonView  = findViewById(R.id.buttonView);
        db = new DBhelper(this);

        buttonInsert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                String nameText = insertName.getText().toString();
                String emailText = insertEmail.getText().toString();
                String numberText = insertNumber.getText().toString();

                Boolean checkInsertedData = db.insertData(nameText, emailText, numberText);
                if(checkInsertedData == true)
                {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameText = insertName.getText().toString();
                String emailText = insertEmail.getText().toString();
                String numberText = insertNumber.getText().toString();

                Boolean checkUpdatedData = db.insertData(nameText, emailText, numberText);
                if(checkUpdatedData == true)
                {
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = insertName.getText().toString();
                Boolean checkDeletedData = db.deleteData(nameText);

                if(checkDeletedData == true)
                {
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursorView = db.viewData();

                if(cursorView.getCount() == 0)
                {
                    Toast.makeText(MainActivity.this, "No Data To View", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(cursorView.moveToNext())
                {
                    buffer.append("Name: " + cursorView.getString(0) + "\n");
                    buffer.append("Email: " + cursorView.getString(1) + "\n");
                    buffer.append("Number: " + cursorView.getString(2) + "\n");
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setCancelable(true);
                alert.setTitle("Customer Entries");
                alert.setMessage(buffer.toString());
                alert.show();
            }
        });
    }
}