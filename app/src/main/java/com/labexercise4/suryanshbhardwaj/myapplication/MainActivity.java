package com.labexercise4.suryanshbhardwaj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView em;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        em=(TextView)findViewById(R.id.email_all);
        Intent i = getIntent();
        String text = i.getStringExtra ("TextBox");
// Now set this value to EditText
        em.setText(text);
        //em.setEnable(false);
    }

    public void abc(View v)
    {

        Intent i = new Intent(MainActivity.this,Main2Activity.class);
        i.putExtra ( "TextBox", em.getText().toString() );
        startActivity(i);

    }

    public void logout(View v){
        Intent i = new Intent(MainActivity.this,loginpage.class);
        startActivity(i);
    }

    public void depart(View view)
    {

        Intent i = new Intent(MainActivity.this,departure_scanqr.class);
        i.putExtra ( "TextBox", em.getText().toString() );
        startActivity(i);

    }

}
