package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Button buttonPrev, buttonNext;
    int[] images = {R.drawable.puppy_image_1, R.drawable.puppy_image_2, R.drawable.puppy_image_3, R.drawable.puppy_image_4};
    int position = 0;
    TextView easterEgg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        buttonPrev = findViewById(R.id.buttonPrevious);
        buttonNext = findViewById(R.id.buttonNext);
        easterEgg = findViewById(R.id.textEasterEgg);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(images[position]);
                return  imageView;
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position>0)
                {
                    position --;
                }
                else if(position<0)
                {
                    position = 0;
                }
                imageSwitcher.setImageResource(images[position]);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position<images.length)
                {
                    position ++;
                }
                if(position>=images.length)
                {
                    position = 0;
                }
                imageSwitcher.setImageResource(images[position]);
            }
        });

        easterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Parth S. Pujari", Toast.LENGTH_SHORT).show();
            }
        });
    }
}