package com.telkom.siborder;

import android.support.v7.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

/**
 * Created by andika on 1/15/18.
 */

public class MyActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    private static final int ERRO_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (isServicesOK()){
            init();
        }
    }

    private void init() {
        Button BtnMap = (Button) findViewById(R.id.btnMap);
        BtnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(MyActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MyActivity.this);

        if (available == ConnectionResult.SUCCESS) {
            Log.d(TAG, "isServicesOK: Google Play servies is working");
            return true;
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG,"isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MyActivity.this, available, ERRO_DIALOG_REQUEST);
            dialog.show();
        }else {
            Toast.makeText(this,"We can't make map request", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}