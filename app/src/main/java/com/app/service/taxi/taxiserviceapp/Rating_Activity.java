package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Akila_chathuranga on 12/22/2015.
 */
public class Rating_Activity extends Activity {

    private Button submit;
    private Activity activity;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_layout);
        this.submit = (Button)findViewById(R.id.submit_ratingBtn);
        this.activity = this;

        this.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
