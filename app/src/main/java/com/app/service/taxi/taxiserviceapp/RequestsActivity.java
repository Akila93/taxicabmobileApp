package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akila_chathuranga on 12/17/2015.
 */
public class RequestsActivity extends Activity {
    private ListView listView;
    private ToggleButton onlineBtn;
    ArrayAdapter<Request_Msg> adapter;
    ArrayList<Request_Msg> list = new ArrayList<Request_Msg>();
    private boolean isCustomer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requests_layout);
        this.isCustomer = getIntent().getBooleanExtra("isCustomer", true);

        this.onlineBtn = (ToggleButton)findViewById(R.id.btnOnline);

        this.onlineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //write code to set db->driver->avalability using json.
                //example ->loginActivity.java and php file in group chat
                //read About ToggleButton methods.
            }
        });
        this.listView = (ListView) findViewById(R.id.request_list);
        if(this.isCustomer) {
            this.onlineBtn.setEnabled(false);
            this.adapter = new Request_Adapter(this, getRequests(),true,this);
        }else {
            this.onlineBtn.setEnabled(true);
            this.adapter = new Request_Adapter(this, getRequests(), false,this);

        }
        listView.setAdapter(adapter);

    }

    public List<Request_Msg> getRequests(){
        // here u need to read database for request and add them to list.
        //better if u can manage list as a stack since recent request should notice first by users
        // limit list items 10-20.
        list.add(new Request_Msg("I want to go Nuwara. I'm from kurunagala."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        list.add(new Request_Msg("I want to go Galle. I'm from wakwalla."));
        return this.list;
    }
}
