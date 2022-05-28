package com.example.numericoperations;
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
                int num = Integer.parseInt(ed1.getText().toString());

                if (rd1.isChecked()) {
                    if ((num % 2) == 0)
                        te1.setText("Even");
                    else
                        te1.setText("Odd");
                }
                if (rd2.isChecked()) {
                    if (num > 0)
                        te1.setText("Positive");
                    else
                        te1.setText("Negative");

                }
                if (rd3.isChecked()) {
                    String s=""+num * num;
                    te1.setText(s);

                }
                if (rd4.isChecked()) {
                    for (int i = num - 1; i > 0; i--)
                        num = num * i;
                    String s=""+num ;
                    te1.setText(s);
                }
            }
        });




    }
}