package com.example.switchtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.widget.ImageView;
import android.widget.Switch;
import android.widget.CompoundButton;

import android.widget.RatingBar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate a Switch
        final Switch simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);
        final ImageView simpleImageView = (ImageView) findViewById(R.id.simpleImageView);
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar);
        Button submitButton = (Button) findViewById(R.id.submitButton);

        //set the current state of a Switch
        simpleSwitch.setChecked(true);

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if ( simpleSwitch.isChecked() ) {
                    simpleSwitch.setText("M8");
                    simpleImageView.setImageResource(R.drawable.m8);
                    simpleRatingBar.setRating((float) 4.0);
                } else {
                    simpleSwitch.setText("Vantage");
                    simpleImageView.setImageResource(R.drawable.vantage);
                    simpleRatingBar.setRating((float) 4.0);
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = "Rating :: " + simpleRatingBar.getRating();
                Toast t = Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG);
//                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
                t.show();
            }
        });
    }
}
