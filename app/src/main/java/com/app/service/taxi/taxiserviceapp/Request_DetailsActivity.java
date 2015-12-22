package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Akila_chathuranga on 12/22/2015.
 */
public class Request_DetailsActivity extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_details);
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
