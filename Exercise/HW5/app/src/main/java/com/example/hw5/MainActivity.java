package com.example.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar rating_bar;
    private Button submit;
    private ImageView bg_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Meow! Growl......", Toast.LENGTH_SHORT).show();
        
        rating_bar = (RatingBar) findViewById(R.id.rating);
        submit = (Button) findViewById(R.id.submit);
        bg_image = (ImageView) findViewById(R.id.bg_image);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rating_bar.getRating() > 2) {
                    bg_image.setImageResource(R.drawable.image3);
                    Toast.makeText(MainActivity.this, "Roar! Growl!!!", Toast.LENGTH_SHORT).show();
                } else if(rating_bar.getRating() < 2) {
                    bg_image.setImageResource(R.drawable.image2);
                    Toast.makeText(MainActivity.this, "Woof-woof! Arf-arf!", Toast.LENGTH_SHORT).show();
                } else {
                    bg_image.setImageResource(R.drawable.image1);
                    Toast.makeText(MainActivity.this, "Meow! Growl......", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
