package com.codewithme.expense_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.OnMapReadyCallback;



public class MainActivity extends AppCompatActivity{
private EditText mEmail;
private EditText mPass;
private Button btnLogin;
private TextView mForgotPasword;
private TextView mSignupHere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginDetails();
    }

    private void loginDetails(){
        mEmail=findViewById(R.id.email_login);
        mPass = findViewById(R.id.password_login);
        btnLogin=findViewById(R.id.btn_login);
        mForgotPasword = findViewById(R.id.forgot_password);
        mSignupHere = findViewById(R.id.signup_reg);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mEmail.getText().toString().trim();
                String pass = mPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email required..");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mPass.setError("Password required..");
                    return;
                }
               startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

        //Registration activity


        mSignupHere.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));

            }
        });

        //Reset password activity

      mForgotPasword.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(getApplicationContext(),ResetActivity.class));
          }
      });
    }
}
