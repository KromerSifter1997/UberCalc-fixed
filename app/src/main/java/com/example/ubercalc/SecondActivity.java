package com.example.ubercalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // applies the string
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String myString = sharedPreferences.getString("MileString", "");
        //if it works the toast will display it, if not it will be blank
        Toast.makeText(this, myString, Toast.LENGTH_LONG).show();

        TextView textView = (TextView) findViewById(R.id.mileResult);
        textView.setText(myString);
    }
}