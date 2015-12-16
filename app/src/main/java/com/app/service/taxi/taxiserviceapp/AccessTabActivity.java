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
        setContentView(R.layout.access_layout);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab1");
        tab1.setIndicator("LoginActivity");
        Intent tab1Intent = new Intent("com.app.taxi.service.LOGIN_ACTIVITY");
        tab1.setContent(tab1Intent);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Tab2");
        tab1.setIndicator("SignUpActivity");
        Intent tab2Intent = new Intent("com.app.taxi.service.SIGNUP_ACTIVITY");
        tab1.setContent(tab2Intent);

    }
}
