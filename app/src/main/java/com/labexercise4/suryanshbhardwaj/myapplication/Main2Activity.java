package com.labexercise4.suryanshbhardwaj.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main2Activity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    TextView em;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanqr);

        em=(TextView)findViewById(R.id.email_all);
        Intent i = getIntent();
        String text = i.getStringExtra ("TextBox");
// Now set this value to EditText
        em.setText(text);

    }

    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    public void goback(View v){
        Intent i = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(i);
    }
    public void logout(View v){
        Intent i = new Intent(Main2Activity.this,loginpage.class);
        startActivity(i);
    }

    @Override
    public void handleResult(Result result) {
        //Do anything with result here :D
       // Log.w("handleResult",result.getText( ));
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Your attendance has been marked");
        builder.setMessage(result.getText());
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        final MediaPlayer mp = MediaPlayer.create(Main2Activity.this, R.raw.clip);
        mp.start();
        // Hide after some seconds
        final Handler handler  = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
            }
        };
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });
        handler.postDelayed(runnable, 1100);
        //Resume scanning
        mScannerView.resumeCameraPreview(this);

    }
}
