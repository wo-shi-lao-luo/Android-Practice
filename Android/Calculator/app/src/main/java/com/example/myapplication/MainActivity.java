package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView display;
    Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, multiply, divide, plus, minus, equal, clear;
    String operator = null;
    String v1, v2;
    Double result;
    Boolean reset = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n0 = findViewById(R.id.n0);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);
        display = (TextView) findViewById(R.id.display);

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("1");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "1");
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                        display.setText("2");
                        reset = false;
                        result = null;
                }
                else display.setText(display.getText() + "2");
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("3");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "3");
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("4");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "4");
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("5");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "5");
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("6");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "6");
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("7");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "7");
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("8");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "8");
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("9");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "9");
            }
        });

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number") || display.getText().equals("0") || reset || result != null) {
                    display.setText("0");
                    reset = false;
                    result = null;
                }
                else display.setText(display.getText() + "0");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number"));
                else {
                    if (v1 != null && operator != null) {
                        v2 = display.getText().toString();
                        result = calculate(v1, operator, v2);
                        show(result);
                    }
                    v1 = display.getText().toString();
                    operator = "+";
                    reset = true;
                    result = null;
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number"));
                else {
                    if (v1 != null && operator != null) {
                        v2 = display.getText().toString();
                        result = calculate(v1, operator, v2);
                        show(result);
                    }
                    v1 = display.getText().toString();
                    operator = "-";
                    reset = true;
                    result = null;
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number"));
                else {
                    if (v1 != null && operator != null) {
                        v2 = display.getText().toString();
                        result = calculate(v1, operator, v2);
                        show(result);
                    }
                    v1 = display.getText().toString();
                    operator = "*";
                    reset = true;
                    result = null;
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display.getText().equals("Number"));
                else {
                    if (v1 != null && operator != null) {
                        v2 = display.getText().toString();
                        result = calculate(v1, operator, v2);
                        show(result);
                    }
                    v1 = display.getText().toString();
                    operator = "/";
                    reset = true;
                    result = null;
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator != null) {
                    v2 = display.getText().toString();
                    result = calculate(v1, operator, v2);
                    show(result);
                }
                v1 = null;
                v2 = null;
                operator = null;
                result = null;
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = null;
                v2 = null;
                operator = null;
                result = null;
                display.setText("Number");
            }
        });

    }

    private double calculate(String a, String operator, String b) {
        if (operator == "+") {
            return Double.parseDouble(a) + Double.parseDouble(b);
        }
        else if (operator == "-") {
            return Double.parseDouble(a) - Double.parseDouble(b);
        }
        else if (operator == "*") {
            return Double.parseDouble(a) * Double.parseDouble(b);
        }
        else {
            return Double.parseDouble(a) / Double.parseDouble(b);
        }
    }

    private void show(double result){
        if (Math.round(result) == result) {
            long resultI = Math.round(result);
            display.setText(Long.toString(resultI));
        }
        else display.setText(Double.toString(result));
    }


}
