package com.example.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText nameText;
    Button buttonAdd, buttonUpdate, buttonDelete, buttonClear;

    ArrayList <String> names = new ArrayList<>();
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        nameText = findViewById(R.id.editTextString);
        buttonAdd = findViewById(R.id.buttonAddString);
        buttonClear = findViewById(R.id.buttonClearString);
        buttonDelete = findViewById(R.id.buttonDeleteString);
        buttonClear = findViewById(R.id.buttonClearString);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, names);
        listView.setAdapter(adapter);

        //Set Selected Item
        listView.setOnItemClickListener((adapterView, view, i, l) -> nameText.setText(names.get(i)));

        //Handle events
        buttonAdd.setOnClickListener(view -> add());

        buttonUpdate.setOnClickListener(view -> update());

        buttonDelete.setOnClickListener(view -> delete());

        buttonClear.setOnClickListener(view -> clear());

        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void add()
    {
        String name = nameText.getText().toString();

        if(!name.isEmpty())
        {
            adapter.add(name);

            adapter.notifyDataSetChanged();

            nameText.setText("");

            Toast.makeText(this, "Added" + name, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Nothing To Add", Toast.LENGTH_SHORT).show();
        }
    }
    public void update() {
        String name = nameText.getText().toString();

        int pos = listView.getCheckedItemPosition();

        if (!name.isEmpty() & name.length() > 0) {
            adapter.remove(names.get(pos));

            adapter.insert(name, pos);

            adapter.notifyDataSetChanged();

            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nothing to Update", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete()
    {

        int pos = listView.getCheckedItemPosition();

        if(pos > -1)
        {

            adapter.remove(names.get(pos));

            adapter.notifyDataSetChanged();
        }
    }

    public void clear()
    {
        adapter.clear();
    }
}