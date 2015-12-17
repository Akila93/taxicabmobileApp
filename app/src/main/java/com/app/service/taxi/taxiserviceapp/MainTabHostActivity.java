package com.app.service.taxi.taxiserviceapp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Akila_chathuranga on 12/17/2015.
 */
public class MainTabHostActivity extends TabActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        TabHost mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("Profile").setContent(new Intent(this  ,ProfileActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Notification").setContent(new Intent(this , RequestsActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("third").setIndicator("Massage").setContent(new Intent(this  ,SendActivity.class )));
        mTabHost.setCurrentTab(0);
    }
}
