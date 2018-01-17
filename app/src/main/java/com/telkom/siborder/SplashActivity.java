package com.telkom.siborder;

import android.content.Intent;
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
        ImageView iv = findViewById(R.id.iv);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.transition);
        iv.startAnimation(myanim);
        final Intent login = new Intent(this, com.telkom.siborder.LoginActivity.class);

        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(login);
                    finish();
                }
            }
        };
        timer.start();
    }
}