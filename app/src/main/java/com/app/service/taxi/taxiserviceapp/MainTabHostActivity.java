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

        Intent profileIntent = new Intent(this  ,ProfileActivity.class );
        profileIntent.putExtra("isCustomer",getIntent().getBooleanExtra("isCustomer",true));

        Intent requestIntent = new Intent(this  ,RequestsActivity.class );
        requestIntent.putExtra("isCustomer",getIntent().getBooleanExtra("isCustomer",true));

        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("Profile").setContent(profileIntent));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Notification").setContent(requestIntent));
        if(getIntent().getBooleanExtra("isCustomer",true)) {
            mTabHost.addTab(mTabHost.newTabSpec("third").setIndicator("Massage").setContent(new Intent(this, SendActivity.class)));
        }else {

            Intent feedbackIntent = new Intent("com.app.taxi.service.FEEDBACK_ACTIVITY");
            mTabHost.addTab(mTabHost.newTabSpec("third").setIndicator("Feedbacks").setContent(feedbackIntent));
        }
        mTabHost.setCurrentTab(0);
    }


}
