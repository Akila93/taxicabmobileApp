package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Akila_chathuranga on 12/16/2015.
 */
public class LoginActivity extends Activity {
    private Button loginBtn;
    private EditText user,pass;
    private RadioButton customer,driver;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        loginBtn = (Button)findViewById(R.id.btnLogin);
        user = (EditText)findViewById(R.id.loginUser);
        pass = (EditText)findViewById(R.id.loginPass);
        customer = (RadioButton)findViewById(R.id.radioBtnCustomer);
        driver = (RadioButton)findViewById(R.id.radioBtnDriver);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent("com.app.taxi.service.MAIN_TABHOST_WINDOW");
                startActivity(startIntent);
            }
        });
    }
}
