package com.example.simpleregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String collector = "";
    EditText editTextUsername, editTextPassword, editTextContact, editTextComment;
    Button register;
    RadioButton radioButtonMale, radioButtonFemale;
    CheckBox buttonCheckBoxHTML, buttonCheckBoxCSS, buttonCheckBoxPHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextContact = findViewById(R.id.editTextContactNo);
        editTextComment = findViewById(R.id.editTextComment);

        radioButtonMale = findViewById(R.id.buttonRadioMale);
        radioButtonFemale = findViewById(R.id.buttonRadioFemale);

        buttonCheckBoxHTML = findViewById(R.id.buttonCheckBoxHTML);
        buttonCheckBoxCSS = findViewById(R.id.buttonCheckBoxCSS);
        buttonCheckBoxPHP = findViewById(R.id.buttonCheckBoxPHP);

        spinner = findViewById(R.id.spinnerCountry);

        register = findViewById(R.id.buttonRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String contactNo = editTextContact.getText().toString();
                String comment = editTextComment.getText().toString();

                if (username.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Username or Password Cannot Be Empty!", Toast.LENGTH_SHORT).show();
                }

                else if (password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Username or Password Cannot Be Empty!", Toast.LENGTH_SHORT).show();
                }
                else if (contactNo.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Fill Contact No.", Toast.LENGTH_SHORT).show();
                }
                else if (comment.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Write a Comment", Toast.LENGTH_SHORT).show();
                }

                else {
                    collector+= username + "\n";
                    collector+= password + "\n";
                    collector+= contactNo+ "\n";

                    if(radioButtonMale.isChecked())
                    {
                        collector+= "Male" + "\n";
                    }
                    if (radioButtonFemale.isChecked())
                    {
                        collector+= "Female" + "\n";
                    }

                    if(buttonCheckBoxHTML.isChecked())
                    {
                        collector+= "HTML" + "\n";
                    }
                    if(buttonCheckBoxCSS.isChecked())
                    {
                        collector+= "CSS" + "\n";
                    }
                    if(buttonCheckBoxPHP.isChecked())
                    {
                        collector+= "PHP" + "\n";
                    }

                    collector+= comment+ "\n";

                    Toast.makeText(MainActivity.this, "User Information " + "\n" + "\n" + collector, Toast.LENGTH_SHORT).show();
                }
            }
        });

        List  <String> categoryCountry = new ArrayList<>();

        categoryCountry.add("Select Country");
        categoryCountry.add("INDIA");
        categoryCountry.add("USA");
        categoryCountry.add("UK");
        categoryCountry.add("JAPAN");

        ArrayAdapter <String> arrayAdapter;

        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categoryCountry);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);



        /*spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                if (parent.getItemAtPosition(position).equals("Select Country")) {
                    //Do Nothing
                } else {
                    String item = parent.getItemAtPosition(position).toString();
                    collector += item + "\n";
                    Toast.makeText(MainActivity.this, "Selected Country is: " + item, Toast.LENGTH_SHORT).show();
                }
            }
        });*/


    }
}