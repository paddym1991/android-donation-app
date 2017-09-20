package app.donation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import app.donation.R;

public class Donate extends AppCompatActivity {

    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private EditText amountText;
    private TextView totalText;
    private int totalDonated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton  = (Button)       findViewById(R.id.donateButton);
        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
        amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);
        amountText    = (EditText) findViewById(R.id.amountText);
        totalText     = (TextView) findViewById(R.id.totalText);


        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);

        progressBar.setMax(10000);

        if(donateButton != null) {
            Log.v("Donate", "Really got the donate button");
        }

        String totalDonatedStr = "Total so far: €0";
        totalText.setText(totalDonatedStr);
    }

    public void donateButtonPressed (View view) {
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.payPal ? "PayPal" : "Direct";

        int donatedAmount = amountPicker.getValue();
        if (donatedAmount == 0) {
            String text = amountText.getText().toString();
            if (!text.equals("")) {
                donatedAmount = Integer.parseInt(text);
            }
        }
        if (totalDonated >= progressBar.getMax()) {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
            Log.v("Donate","Target Exceeded: " + totalDonated);
        }
        else {
            totalDonated = totalDonated + donatedAmount;
            progressBar.setProgress(totalDonated);
            Log.v("Donate", donatedAmount + " donated by " + method + "\nCurrent total " + totalDonated);

            String totalDonatedStr = "Total so far: €" + totalDonated;
            totalText.setText(totalDonatedStr);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_donate, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuReport : startActivity (new Intent(this, Report.class));
                break;
        }
        return true;
    }
}



//package com.example.donation;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.NumberPicker;
//import android.widget.ProgressBar;
//import android.widget.RadioGroup;
//
//public class Donate extends AppCompatActivity {
//
//    private Button donateButton;
//    private RadioGroup paymentMethod;
//    private ProgressBar progressBar;
//    private NumberPicker amountPicker;
//    private int totalDonated;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_donate);
//
//        donateButton  = (Button)       findViewById(R.id.donateButton);
//        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
//        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
//        amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);
//
//        amountPicker.setMinValue(0);
//        amountPicker.setMaxValue(1000);
//
//        progressBar.setMax(10000);
//    }
//
//    public void donateButtonPressed (View view)
//    {
//        int amount = amountPicker.getValue();
//        int radioId = paymentMethod.getCheckedRadioButtonId();
//        String method = radioId == R.id.payPal ? "PayPal" : "Direct";
//        totalDonated = totalDonated + amount;
//        progressBar.setProgress(totalDonated);
//
//        Log.v("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);
//        Log.v("Donate", "Current total " + totalDonated);
//
//    }
//}