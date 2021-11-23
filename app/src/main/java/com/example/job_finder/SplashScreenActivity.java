package com.example.job_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.splash_screen );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent( SplashScreenActivity.this,Choose_login_and_reg.class);
                startActivity(i);
            }
        }, 2000);
    }
}