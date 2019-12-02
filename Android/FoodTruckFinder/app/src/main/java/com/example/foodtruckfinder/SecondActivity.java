package com.example.foodtruckfinder;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SecondActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String EXTRA_MESSAGE = "FoodTruckFinder.MESSAGE";
    private GoogleMap mMap;
    TextView name, style, operation, rating, rec1, rec2, price1, price2;

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

        String restaurant = getIntent().getStringExtra("restaurant");
        renderPage(restaurant);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void renderPage (String restaurant) {
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
            jObject = new JSONObject(byteArrayOutputStream.toString());
            JSONObject target = jObject.getJSONObject(restaurant);
            name.setText(target.getString("name"));
            style.setText(target.getString("type"));
            operation.setText(target.getString("operation"));
            rating.setText((String) target.getString("rating"));
            JSONObject rec = target.getJSONObject("recommendation");
            rec1.setText(rec.getJSONObject("r1").getString("name"));
            price1.setText(rec.getJSONObject("r1").getString("price"));
            rec2.setText(rec.getJSONObject("r2").getString("name"));
            price2.setText(rec.getJSONObject("r2").getString("price"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
