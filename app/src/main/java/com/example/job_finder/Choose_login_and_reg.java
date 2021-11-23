package com.example.job_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose_login_and_reg extends AppCompatActivity {

    private Button mLogin, mRegister;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_choose_login_and_reg );

        mLogin = (Button) findViewById ( R.id.login_button );
        mRegister = (Button) findViewById ( R.id.Signup_button );

        mLogin.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Intent i = new Intent ( Choose_login_and_reg.this, LoginActivity.class );
                startActivity ( i );
            }
        } );

        mRegister.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Intent i2 = new Intent ( Choose_login_and_reg.this, RegisterActivity.class );
                startActivity ( i2 );
            }
        } );
    }
}