package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Akila_chathuranga on 12/15/2015.
 */
public class SendActivity extends Activity{
    private Button sendBtn;
    private EditText starting_point,ending_point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_layout);

        sendBtn=(Button)findViewById(R.id.btnSend);
        starting_point = (EditText)findViewById(R.id.starting_point_text);
        ending_point = (EditText)findViewById(R.id.ending_point_text);
        //define editText as above. ids can be found on res->layout->sms_layout.xml

        String msg = (starting_point.getText()).toString();
        msg+=" from ";
        msg+=(ending_point.getText()).toString();


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get details from editText fields
                //create a string massage.
                //submit it to db.
            }
        });
    }

}
