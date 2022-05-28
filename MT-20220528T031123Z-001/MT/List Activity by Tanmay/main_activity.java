package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lv1;
    EditText inp;
    Button ins,del,search;
    ArrayList <String> itms = new ArrayList<String>();
    ArrayAdapter myadap;
    String item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.lvs);
        inp = findViewById(R.id.it);
        ins = findViewById(R.id.ins);
        del = findViewById(R.id.de);
        search = findViewById(R.id.se);
        myadap = new ArrayAdapter(this, android.R.layout.simple_list_item_1,itms);
        lv1.setAdapter(myadap);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = inp.getText().toString();
                itms.add(item);
                Toast.makeText(MainActivity.this, "Inserted "+item, Toast.LENGTH_SHORT).show();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = inp.getText().toString();
                itms.remove(item);
                Toast.makeText(MainActivity.this, "Deleted "+item, Toast.LENGTH_SHORT).show();

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = inp.getText().toString();
                Integer k =itms.indexOf(item);
                if(k == -1)
                {
                    Toast.makeText(MainActivity.this, "Not Found "+item, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Found at index "+k, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}