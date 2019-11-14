package com.example.imagetest;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String imageLabel = "m8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView simpleImageView = (ImageView) findViewById(R.id.simpleImageView);
        simpleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageLabel == "m8") {
                    simpleImageView.setImageResource(R.drawable.vantage);
                    imageLabel = "vantage";
                } else {
                    simpleImageView.setImageResource(R.drawable.m8);
                    imageLabel = "m8";
                }
            }
        });
    }
}