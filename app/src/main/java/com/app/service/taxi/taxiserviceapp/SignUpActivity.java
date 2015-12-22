package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Akila_chathuranga on 12/16/2015.
 */
public class SignUpActivity extends Activity {
    private Button signupBtn;
    private RadioButton customer,driver;
    private EditText name,pass,confirm_pass,NIC,license_no,phone_no,city,street,door_no;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        signupBtn = (Button)findViewById(R.id.btnSignup);
        customer = (RadioButton)findViewById(R.id.radioBtnCust_signup);
        driver = (RadioButton)findViewById(R.id.radioBtnDriv_signup);
        name = (EditText)findViewById(R.id.signup_name);
        pass = (EditText)findViewById(R.id.signup_pass);
        confirm_pass = (EditText)findViewById(R.id.signup_confirmedPass);
        NIC = (EditText)findViewById(R.id.signup_NIC);
        license_no = (EditText)findViewById(R.id.signup_licenseNumber);
        phone_no = (EditText)findViewById(R.id.signup_phoneNumber);
        city = (EditText)findViewById(R.id.city);
        street = (EditText)findViewById(R.id.street);
        door_no = (EditText)findViewById(R.id.door_num);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //u can use customer.isChecked(); method to signup as a customer or driver
                //some fields are not editable in customer mode,driver mode since they are not required for db.
                //code here.read JSONfunction.java for more.
                Intent startIntent = new Intent("com.app.taxi.service.MAIN_TABHOST_WINDOW");
                startIntent.putExtra("isCustomer",customer.isChecked());
                startActivity(startIntent);
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driver.setChecked(false);
                customer.setChecked(true);

                NIC.setEnabled(false);
                license_no.setEnabled(false);

                door_no.setEnabled(true);
                street.setEnabled(true);
                city.setEnabled(true);




            }
        });

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driver.setChecked(true);
                customer.setChecked(false);

                door_no.setEnabled(false);
                street.setEnabled(false);
                city.setEnabled(false);

                NIC.setEnabled(true);
                license_no.setEnabled(true);


            }
        });
    }

    protected void onPause(){
        super.onPause();
        //finish();
    }
}
