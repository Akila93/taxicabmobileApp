package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Akila_chathuranga on 12/22/2015.
 */
public class Request_DetailsActivity extends Activity {
    private TextView detail_request,request_status_detailed;
    private EditText minimumAmount;
    private Button accept;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_details);

        detail_request = (TextView)findViewById(R.id.request1_detailed);
        request_status_detailed = (TextView)findViewById(R.id.request_status_detailed);
        minimumAmount = (EditText)findViewById(R.id.minimum_amount);
        accept = (Button)findViewById(R.id.accept);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here to accept request.
                //loginActivity.java example with php files in group chat.
                //minimumAmount.getText(); to get typed value.
            }
        });
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
