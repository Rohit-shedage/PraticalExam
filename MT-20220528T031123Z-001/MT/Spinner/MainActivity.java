package com.example.spinneritems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    EditText item;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = findViewById(R.id.editText1);
        spin = findViewById(R.id.spinner);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        List <String> list = new ArrayList<>();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itm = item.getText().toString();

                if(itm.isEmpty()){
                    Toast.makeText(MainActivity.this,"No input given in textBox",Toast.LENGTH_SHORT).show();
                }

                list.add(itm);
                ArrayAdapter <String> arrAdp;
                arrAdp = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,list);
                arrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(arrAdp);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itm = item.getText().toString();
              //  Toast.makeText(MainActivity.this,itm,Toast.LENGTH_SHORT).show();
                if(itm.isEmpty()){
                    Toast.makeText(MainActivity.this,"No input given in textBox",Toast.LENGTH_SHORT).show();
                }
                Iterator itr= list.iterator();
                while (itr.hasNext()){
                    String x = (String)itr.next();
                    if(x.equals(itm))

                        itr.remove();
                }


            }
        });

    }
}