package com.example.ubercalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button button = (Button) findViewById(R.id.btnClickReview);
    Button returnButton = (Button) findViewById(R.id.btnReturn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // applies the string
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String myString = sharedPreferences.getString("MileString", "");
        String myRide = sharedPreferences.getString("CarString", "");
        String myPrice = sharedPreferences.getString("PriceString", "");


        TextView mileView = (TextView) findViewById(R.id.mileResult);
        TextView carView = (TextView) findViewById(R.id.vehicleResult);
        TextView priceView = (TextView) findViewById(R.id.priceResult);
        mileView.setText(myString);
        carView.setText(myRide);
        priceView.setText(myPrice);

        button.setOnClickListener(new View.OnClickListener() {
// return and confirm buttons move you to the first page and back
            @Override
            public void onClick(View v) {

//                 finalPrice = (totalPrice.toString());
                Intent intent = new Intent (SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                 finalPrice = (totalPrice.toString());
                Intent intent = new Intent (SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }










}
