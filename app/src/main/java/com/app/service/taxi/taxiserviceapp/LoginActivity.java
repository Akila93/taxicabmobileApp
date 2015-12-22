package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import org.json.JSONException;
import org.json.JSONObject;

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
                //url should edit when we use online db. commented because I can't test it on android virtual devices.
                /*String url ="http://10.0.2.2/db_manager/login_account_check.php?name="+user.getText()+"&amp;pass="+pass.getText()+"&amp;account="+(customer.isChecked()?"customer":"driver")+"";
                JSONObject jsonobj = JSONfunctions.getJSONfromURL(url);
                try {
                    JSONObject resultObj = jsonobj.getJSONObject("response");
                    int val = resultObj.getInt("success");
                    if(val == 0)
                        throw new Exception("Oh json");
                    Intent startIntent = new Intent("com.app.taxi.service.MAIN_TABHOST_WINDOW");
                    startIntent.putExtra("isCustomer",customer.isChecked());
                    startActivity(startIntent);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    //user.setText(e.toString());
                    e.printStackTrace();
                }*/
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
            }
        });

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driver.setChecked(true);
                customer.setChecked(false);
            }
        });
    }

    protected void onPause(){
        super.onPause();
    }
}
