package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akila_chathuranga on 12/17/2015.
 */
public class RequestsActivity extends Activity {
    private ListView listView;
    ArrayAdapter<Request_Msg> adapter;
    ArrayList<Request_Msg> list = new ArrayList<Request_Msg>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requests_layout);

       this.listView = (ListView) findViewById(R.id.request_list);
        this.adapter = new Request_Adapter(this,getRequests());
        listView.setAdapter(adapter);

    }

    public List<Request_Msg> getRequests(){
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
