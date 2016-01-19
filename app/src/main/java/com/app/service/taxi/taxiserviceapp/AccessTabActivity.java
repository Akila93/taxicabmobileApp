package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Akila_chathuranga on 12/16/2015.
 */
public class AccessTabActivity extends TabActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        TabHost mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("Login").setContent(new Intent(this  ,LoginActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("SignUp").setContent(new Intent(this , SignUpActivity.class )));
        mTabHost.setCurrentTab(0);

    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
