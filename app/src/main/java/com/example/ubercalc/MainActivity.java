package com.example.ubercalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //put an override before a new function is made
    int totalMiles = 0;
    int totalPrice;
    int mileRate;
    private Spinner selectedCar;
    private EditText mileTotaltext;
    private String finalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnClick);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                selectedCar = findViewById(R.id.vehicleDrop);
                String selectedCarText = selectedCar.getSelectedItem().toString();
                mileTotaltext = findViewById(R.id.mileNum);
                totalMiles = Integer.parseInt (mileTotaltext.getText().toString());
                // checks the value and adjusts the extra fee
                if (selectedCarText == "Sedan"){
                    mileRate = totalMiles;

                } else if (selectedCarText == "Smart Car") {
                    mileRate = totalMiles + 2;

                } else if (selectedCarText == "MiniVan") {
                    mileRate = totalMiles + 5;

                }
                totalPrice = (int) Math.ceil( mileRate * 3.25 + 3 );

//                 finalPrice = (totalPrice.toString());
                Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        //variable name variable value is a key value pair
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        //creates editor
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //applies edits to value
        editor.putString("MileString", String.valueOf(totalPrice));
        editor.apply();
    }


    class HandleTheClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            //Toast.maketext(MainActivity.this, "I am a toast message", Toast.LENGTH_LONG).show();
            Intent intent = new Intent (MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }
}