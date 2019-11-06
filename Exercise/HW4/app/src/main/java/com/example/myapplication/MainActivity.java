package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText priceAmount;
    TextView tipPercent, tipAmount, taxPercent, taxAmount, totalAmount;
    SeekBar tipSeekBar, taxSeekBar;
    double price = 0, tip = 0.15, tax = 0.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceAmount = findViewById(R.id.amount);
        tipPercent = findViewById(R.id.tipPercentTextView);
        tipSeekBar = findViewById(R.id.tipPercentSeekBar);
        tipAmount = findViewById(R.id.tipTextView);
        taxPercent = findViewById(R.id.taxPercentTextView);
        taxSeekBar = findViewById(R.id.taxPercentSeekBar);
        taxAmount = findViewById(R.id.taxTextView);
        totalAmount = findViewById(R.id.totalTextView);

        priceAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                price = Double.parseDouble(s.toString());
            }
        });

        tipSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tip = progress / 100.0;
            }
        });

        taxSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tax = progress / 100.0;
            }
        });
    }

    

}
