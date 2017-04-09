package com.labexercise4.suryanshbhardwaj.myapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity_Firebase extends AppCompatActivity {

    @VisibleForTesting
    public ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("loading");
            mProgressDialog.setIndeterminate(false);

        }

        mProgressDialog.show();
        timerDelayRemoveDialog(5000,mProgressDialog);
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    public void timerDelayRemoveDialog(long time, final Dialog d){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                d.dismiss();
            }
        }, time);
    }
}
