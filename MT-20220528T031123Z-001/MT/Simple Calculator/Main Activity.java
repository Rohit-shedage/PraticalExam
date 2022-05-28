package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button symbolDot, symbolEqual, symbolSubtract, symbolDivide, symbolMultiply, symbolClear, symbolAddition;

    EditText editNumbers;

    float value1, value2;

    boolean valueAdd, valueSub, valueDiv, valueMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.number0);
        button1 = (Button) findViewById(R.id.number1);
        button2 = (Button) findViewById(R.id.number2);
        button3 = (Button) findViewById(R.id.number3);
        button4 = (Button) findViewById(R.id.number4);
        button5 = (Button) findViewById(R.id.number5);
        button6 = (Button) findViewById(R.id.number6);
        button7 = (Button) findViewById(R.id.number7);
        button8 = (Button) findViewById(R.id.number8);
        button9 = (Button) findViewById(R.id.number9);
        symbolDot = (Button) findViewById(R.id.symbolDot);
        symbolClear = (Button) findViewById(R.id.symbolClear);
        symbolSubtract = (Button) findViewById(R.id.symbolSubtract);
        symbolDivide = (Button) findViewById(R.id.symbolDivide);
        symbolMultiply = (Button) findViewById(R.id.symbolMultiply);
        symbolAddition = (Button) findViewById(R.id.symbolAddition);
        symbolEqual = (Button) findViewById(R.id.symbolEqual);
        editNumbers = (EditText) findViewById(R.id.editNumbers);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + "9");
            }
        });
        symbolDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText(editNumbers.getText() + ".");
            }
        });
        symbolClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNumbers.setText("");
            }
        });
        symbolSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNumbers != null) {
                    value1 = Float.parseFloat(editNumbers.getText() + "");
                    valueAdd = true;
                }
                editNumbers.setText("");
            }
        });
        symbolDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNumbers != null) {
                    value1 = Float.parseFloat(editNumbers.getText() + "");
                    valueDiv = true;
                }
                editNumbers.setText("");
            }
        });
        symbolMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNumbers != null) {
                    value1 = Float.parseFloat(editNumbers.getText() + "");
                    valueMul = true;
                }
                editNumbers.setText("");
            }
        });
        symbolAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNumbers != null) {
                    value1 = Float.parseFloat(editNumbers.getText() + "");
                    valueAdd = true;
                }
		    editNumbers.setText("");
            }
        });
        symbolEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                value2 = Float.parseFloat(editNumbers.getText() + "");

                if(valueAdd == true)
                {
                    editNumbers.setText(value1 + value2 + "");
                    valueAdd = false;
                }
                if(valueSub == true)
                {
                    editNumbers.setText(value1 - value2 + "");
                    valueSub = false;
                }
                if(valueDiv == true)
                {
                    editNumbers.setText(value1 / value2 + "");
                    valueDiv = false;
                }
                if(valueMul == true)
                {
                    editNumbers.setText(value1 * value2 + "");
                    valueMul = false;
                }
            }
        });
    }
}