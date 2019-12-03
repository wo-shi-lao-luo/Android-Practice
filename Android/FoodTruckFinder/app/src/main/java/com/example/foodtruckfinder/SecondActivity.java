package com.example.foodtruckfinder;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    TextView name, style, operation, rating, rec1, rec2, price1, price2;
    ImageView head_bg, rec1_pic, rec2_pic;
//    Switch location, operating;
    Button report;
    LatLng location;
    String restaurant_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_truck_detail);

        name = (TextView) findViewById(R.id.restaurant_name);
        style = (TextView) findViewById(R.id.style);
        operation = (TextView) findViewById(R.id.operation_time);
        rating = (TextView) findViewById(R.id.rating);
        rec1 = (TextView) findViewById(R.id.recommendation1);
        price1 = (TextView) findViewById(R.id.price1);
        rec2 = (TextView) findViewById(R.id.recommendation2);
        price2 = (TextView) findViewById(R.id.price2);

        head_bg = (ImageView) findViewById(R.id.head_bg);
        rec1_pic = (ImageView) findViewById(R.id.rec1_image);
        rec2_pic = (ImageView) findViewById(R.id.rec2_image);

//        location = (Switch) findViewById(R.id.location_switch);
//        operating = (Switch) findViewById(R.id.operating_switch);

        report = (Button) findViewById(R.id.report_btn);

        String restaurant = getIntent().getStringExtra("restaurant");
        renderPage(restaurant);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(SecondActivity.this, Html.fromHtml("<i><b>Thank you, we've got your report!</b></i>"), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

//        location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast toast = Toast.makeText(SecondActivity.this, Html.fromHtml("<i><b>Thank you, we've got your report!</b></i>"), Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//        operating.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast toast = Toast.makeText(SecondActivity.this, Html.fromHtml("<i><b>Thank you, we've got your report!</b></i>"), Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(location).title(restaurant_name));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 17));
    }

    public void renderPage (String restaurant) {
        Resources resources = getResources();
        int head_bg_id = resources.getIdentifier(restaurant + "_bg", "drawable", getPackageName());
        head_bg.setImageDrawable(getDrawable(head_bg_id));
        int rec1_pic_id = resources.getIdentifier(restaurant + "_rec1", "drawable", getPackageName());
        rec1_pic.setImageDrawable(getDrawable(rec1_pic_id));
        int rec2_pic_id = resources.getIdentifier(restaurant + "_rec2", "drawable", getPackageName());
        rec2_pic.setImageDrawable(getDrawable(rec2_pic_id));

        InputStream inputStream = getResources().openRawResource(R.raw.truck_info);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        JSONObject jObject;
        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Get data from JSON
            jObject = new JSONObject(byteArrayOutputStream.toString());
            JSONObject target = jObject.getJSONObject(restaurant);

            //Render restaurant's name, style, and operation time.
            restaurant_name = target.getString("name");
            name.setText(restaurant_name);
            style.setText(target.getString("type"));
            operation.setText(target.getString("operation"));

            //Render restaurant rating and rating background
            double rating_num = target.getDouble("rating");
            rating.setText((String) target.getString("rating"));
            if (rating_num <= 3.5) {
                rating.setBackground(getDrawable(R.drawable.rating_mid_bg));
            }

            //Render recommendations' pictures and texts
            JSONObject rec = target.getJSONObject("recommendation");
            rec1.setText(rec.getJSONObject("r1").getString("name"));
            price1.setText(rec.getJSONObject("r1").getString("price"));
            rec2.setText(rec.getJSONObject("r2").getString("name"));
            price2.setText(rec.getJSONObject("r2").getString("price"));

            //Move map camera
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            location = new LatLng(target.getJSONArray("location").getDouble(0), target.getJSONArray("location").getDouble(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
        int currentTime = Calendar.getInstance().get(Calendar.HOUR);
        System.out.println("```````");
        System.out.println(currentTime);
    }
}
