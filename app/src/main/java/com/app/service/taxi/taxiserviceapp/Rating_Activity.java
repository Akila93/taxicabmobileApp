package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

/**
 * Created by Akila_chathuranga on 12/22/2015.
 */
public class Rating_Activity extends Activity {

    private Button submit;
    private Activity activity;
    private RatingBar currentRating,yourRating;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_layout);
        this.submit = (Button)findViewById(R.id.submit_ratingBtn);
        this.activity = this;

        this.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code how to submit your rating to driver.
                //it shoud update current rating.
                activity.onBackPressed();
            }
        });
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
