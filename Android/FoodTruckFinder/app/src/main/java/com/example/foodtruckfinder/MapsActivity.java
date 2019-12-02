package com.example.foodtruckfinder;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MapsActivity extends FragmentActivity implements View.OnClickListener{

    public static final String EXTRA_MESSAGE = "FoodTruckFinder.MESSAGE";

    LinearLayout xian_cuisine, pako_takos, quickbite, halal_grill, tasty_kabob, restaurant_list;
    Spinner spinner;
    EditText search;
    List<String> names, styles;

    JSONObject details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_page);

        spinner = (Spinner) findViewById(R.id.spinner);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                // hide selection text
//                ((TextView)view).setText(null);
//                // if you want you can change background here
//
//                String type = String.valueOf(spinner.getSelectedItem());
//
//
//            }
//            public void onNothingSelected(AdapterView<?> arg0) {}
//        });
        spinner.setOnItemSelectedListener(filterPage);

//        parseJSON();
//        System.out.println(names);
//        System.out.println(styles);

        restaurant_list = (LinearLayout) findViewById(R.id.restaurant_list);

        xian_cuisine = (LinearLayout) findViewById(R.id.xian_cuisine);
        xian_cuisine.setOnClickListener(this);

        pako_takos = (LinearLayout) findViewById(R.id.pakos_takos);
        pako_takos.setOnClickListener(this);

        quickbite = (LinearLayout) findViewById(R.id.quickbite);
        quickbite.setOnClickListener(this);

        halal_grill = (LinearLayout) findViewById(R.id.halal_grill);
        halal_grill.setOnClickListener(this);

        tasty_kabob = (LinearLayout) findViewById(R.id.tasty_kabob);
        tasty_kabob.setOnClickListener(this);

        search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(searchPage);

    }

    @Override
    public void onClick(View v) {
        // handling onClick Events
        switch (v.getId()) {
            case R.id.xian_cuisine:
                goTo("xian_cuisine");
                break;
            case R.id.pakos_takos:
                goTo("pako_takos");
                break;
            case R.id.quickbite:
                goTo("quickbite");
                break;
            case R.id.halal_grill:
                goTo("halal_grill");
                break;
            case R.id.tasty_kabob:
                goTo("tasty_kabob");
                break;
        }
    }

    private void goTo(String restaurant) {
        Intent intent = new Intent(MapsActivity.this, SecondActivity.class);
        intent.putExtra("restaurant", restaurant);
        startActivity(intent);
    }

//    private void parseJSON () {
//        InputStream inputStream = getResources().openRawResource(R.raw.truck_info);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        int ctr;
//        try {
//            ctr = inputStream.read();
//            while (ctr != -1) {
//                byteArrayOutputStream.write(ctr);
//                ctr = inputStream.read();
//            }
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            details = new JSONObject(byteArrayOutputStream.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private TextWatcher searchPage = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String input = s.toString().toLowerCase();
            for (int i = 0; i < restaurant_list.getChildCount(); i++) {
                LinearLayout v = (LinearLayout) restaurant_list.getChildAt(i);

                v.setVisibility(LinearLayout.VISIBLE);

                LinearLayout text = (LinearLayout) ((LinearLayout) v.getChildAt(1));
                String name = ((TextView) text.getChildAt(1)).getText().toString().toLowerCase();
                String style = ((TextView) text.getChildAt(2)).getText().toString().toLowerCase();

                if (!name.contains(input) && !style.equals(input)) {
                    v.setVisibility(LinearLayout.GONE);
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    };

    private AdapterView.OnItemSelectedListener filterPage = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // hide selection text
            ((TextView)view).setText(null);
            // if you want you can change background here

            String input = String.valueOf(spinner.getSelectedItem()).toLowerCase();
            if (input.equals("all")) {
                for (int i = 0; i < restaurant_list.getChildCount(); i++) {
                    LinearLayout v = (LinearLayout) restaurant_list.getChildAt(i);
                    v.setVisibility(LinearLayout.VISIBLE);
                }
            } else {
                for (int i = 0; i < restaurant_list.getChildCount(); i++) {
                    LinearLayout v = (LinearLayout) restaurant_list.getChildAt(i);

                    v.setVisibility(LinearLayout.VISIBLE);

                    LinearLayout text = (LinearLayout) ((LinearLayout) v.getChildAt(1));
                    String style = ((TextView) text.getChildAt(2)).getText().toString().toLowerCase();

                    if (!style.equals(input)) {
                        v.setVisibility(LinearLayout.GONE);
                    }
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
