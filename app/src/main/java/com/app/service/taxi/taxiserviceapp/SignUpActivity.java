package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by Akila_chathuranga on 12/16/2015.
 */
public class SignUpActivity extends Activity {
    private Button signupBtn;
    private RadioButton customer,driver;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        signupBtn = (Button)findViewById(R.id.btnSignup);
        customer = (RadioButton)findViewById(R.id.radioBtnCust_signup);
        driver = (RadioButton)findViewById(R.id.radioBtnDriv_signup);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent("com.app.taxi.service.MAIN_TABHOST_WINDOW");
                startActivity(startIntent);
            }
        });
    }
}
