package com.labexercise4.suryanshbhardwaj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class scanqr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanqr);
    }

    public void onClick(View v) {

        Intent i = new Intent(scanqr.this, Main2Activity.class);
        startActivity(i);

    }

    public void logout(View v) {
        Intent i = new Intent(scanqr.this, loginpage.class);
        startActivity(i);
    }

    public void goback(View v) {
        Intent i = new Intent(scanqr.this, MainActivity.class);
        startActivity(i);
    }
}
