package com.example.stringoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    EditText ed1;
    RadioGroup rg1;
    RadioButton rd1,rd2,rd3,rd4;
    TextView te1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rd1=findViewById(R.id.r1);
        rd2=findViewById(R.id.r2);
        rd3=findViewById(R.id.r3);
        rd4=findViewById(R.id.r4);
        te1=findViewById(R.id.t1);
        ed1=findViewById(R.id.e1);
        bt1=findViewById(R.id.b1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable c1= ed1.getEditableText();
                String st1 =c1.toString();

                if(rd1.isChecked())
                {
                    String di= st1.toUpperCase();
                    te1.setText(di);
                }
                if(rd2.isChecked())
                {
                    String di2= st1.toLowerCase();
                    te1.setText(di2);
                }
                if(rd3.isChecked())
                {
                    String di3= st1.substring(st1.length()-5);
                    te1.setText(di3);

                }
                if(rd4.isChecked())
                {
                    String di4= st1.substring(0,5);
                    te1.setText(di4);
                }


            }
        });




    }
}

