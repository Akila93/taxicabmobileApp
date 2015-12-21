package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Akila_chathuranga on 12/20/2015.
 */
public class Request_Adapter extends ArrayAdapter<Request_Msg> {


    private final List<Request_Msg> list;
    private final Activity context;
    private final boolean customer_login;


    static class ViewHolder {
        protected TextView msg,msg_status;
        protected Button acceptBtn,cancelBtn;
        protected EditText minimum_amount_text;
    }
    public Request_Adapter(Activity context, List<Request_Msg> list) {
        super(context, R.layout.row, list);
        this.context = context;
        this.list = list;
        this.customer_login = false;
    }
    public Request_Adapter(Activity context, List<Request_Msg> list, boolean customer_login) {
        super(context, R.layout.row1, list);
        this.context = context;
        this.list = list;
        this.customer_login = customer_login;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {

            LayoutInflater inflator = context.getLayoutInflater();

            if(this.customer_login) {

                convertView = inflator.inflate(R.layout.row1, null);
                viewHolder = new ViewHolder();
                viewHolder.msg = (TextView) convertView.findViewById(R.id.request);
                viewHolder.msg_status = (TextView) convertView.findViewById(R.id.request_status);
                viewHolder.cancelBtn = (Button) convertView.findViewById(R.id.cancel_request);
                viewHolder.cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                convertView.setTag(viewHolder);
                convertView.setTag(R.id.request, viewHolder.msg);
                convertView.setTag(R.id.cancel_request, viewHolder.cancelBtn);
                convertView.setTag(R.id.request_status, viewHolder.msg_status);
            }else {
                convertView = inflator.inflate(R.layout.row, null);
                viewHolder = new ViewHolder();
                viewHolder.msg = (TextView) convertView.findViewById(R.id.request1);
                viewHolder.minimum_amount_text = (EditText) convertView.findViewById(R.id.minimum_amount);
                viewHolder.msg_status = (TextView) convertView.findViewById(R.id.request_status1);
                viewHolder.acceptBtn = (Button) convertView.findViewById(R.id.accept);
                viewHolder.acceptBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                convertView.setTag(viewHolder);
                convertView.setTag(R.id.request1, viewHolder.msg);
                convertView.setTag(R.id.accept, viewHolder.acceptBtn);
                convertView.setTag(R.id.minimum_amount,viewHolder.minimum_amount_text);
                convertView.setTag(R.id.request_status1, viewHolder.msg_status);
            }
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.msg.setText(list.get(position).getMsg());
        viewHolder.msg_status.setText(list.get(position).getStatus());
        return convertView;
    }


}
