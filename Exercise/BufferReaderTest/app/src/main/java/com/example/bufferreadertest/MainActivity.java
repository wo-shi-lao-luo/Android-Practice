package com.example.bufferreadertest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.ClickMe);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                InputStream is = getResources().openRawResource(R.raw.poem);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String readLine = null;

                try {
                    while ((readLine = br.readLine()) != null) {
                        Toast.makeText(getApplicationContext(), readLine, Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
