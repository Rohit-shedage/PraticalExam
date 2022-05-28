package com.example.palindrome;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//Palindrome Number
//
//A number is said to be a Palindrome if the reverse of its digit is number itself. For eg. 121, 959, 1441, etc.
public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.editText);
        t1 = (TextView)findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int a,sum=0,temp,rev;
                int num = Integer.parseInt(e1.getText().toString());
                temp = num;
                while(num>0)
                {
                    rev =num%10;
                    num=num/10;
                    sum = sum * 10 + rev;
                }
                if(temp ==sum)
                    t1.setText("Number is Palindrome");
                else
                    t1.setText("Number is Not Palindrome");
            }
        });
    }
}