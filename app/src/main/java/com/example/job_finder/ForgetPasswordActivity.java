package com.example.job_finder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button mForgotPasswordButton;
    private EditText mEmail;
    private FirebaseAuth mAuth;
    private boolean flag = false;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+", email;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_forget_password );

        mAuth = FirebaseAuth.getInstance ();
        flag = false;
        mForgotPasswordButton = (Button) findViewById ( R.id.resetPasswordButton );
        mEmail = (EditText) findViewById ( R.id.resetPasswordEmail );

        mForgotPasswordButton.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                email = mEmail.getText ().toString ();
                if(email.equals ( "" )){
                    Toast.makeText ( ForgetPasswordActivity.this, "Email is Empty...", Toast.LENGTH_SHORT ).show ();
                    return;
                }

                //Below Codes check if the email is Valid or not
                if(!email.matches ( emailPattern )){
                    Toast.makeText ( ForgetPasswordActivity.this, "Invalid email address, enter valid email id..", Toast.LENGTH_SHORT ).show ();
                    return;
                }

                mAuth.fetchSignInMethodsForEmail ( email ).addOnCompleteListener ( new OnCompleteListener <SignInMethodQueryResult> ( ) {
                    @Override
                    public void onComplete ( @NonNull Task <SignInMethodQueryResult> task ) {
                        mAuth.sendPasswordResetEmail ( mEmail.getText ().toString () ).addOnCompleteListener ( new OnCompleteListener <Void> ( ) {
                            @Override
                            public void onComplete ( @NonNull Task <Void> task ) {
                                if(task.isSuccessful ()){
                                    flag = true;
                                    Toast.makeText ( ForgetPasswordActivity.this, "Password reset instructions send to your email", Toast.LENGTH_SHORT ).show ();
                                }else{
                                    Toast.makeText ( ForgetPasswordActivity.this, task.getException ().getMessage (), Toast.LENGTH_SHORT ).show ();
                                    if(flag==false){
                                        Toast.makeText ( ForgetPasswordActivity.this, "Email address not found...", Toast.LENGTH_SHORT ).show ();
                                    }
                                }
                            }
                        } );
                    }
                } );
            }
        } );
    }

    @Override
    public void onBackPressed () {
        Intent btnClick = new Intent ( ForgetPasswordActivity.this, LoginActivity.class );
        startActivity ( btnClick );
        super.onBackPressed ();
        finish ();
        return;
    }
}