package com.telkom.siborder;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Integer delay = 1000;
        ImageView iv = findViewById(R.id.iv);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.transition);

        myanim.setDuration(delay);
        iv.startAnimation(myanim);

        final Intent login = new Intent(this, com.telkom.siborder.LoginActivity.class);

        Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() {
            public void run() {
                startActivity(login);
                finish();
            }
        };
        handler.postDelayed(runnable, delay);
    }
}