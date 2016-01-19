package com.app.service.taxi.taxiserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Akila_chathuranga on 12/17/2015.
 */
public class ProfileActivity extends Activity {
    private boolean isCustomer;
    private EditText name,pass,confirm_pass,NIC,license_no,phone_no,city,street,door_no;
    private Button edit,logout;


    private void loadFields(){
        // load account info from db to text fields using json. use my example in loginActivity.java.
        //read php files in group chat.read JSONfunction.java for more.
        //tip-> this.name.setText("Ak93");
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        this.isCustomer = getIntent().getBooleanExtra("isCustomer", true);

        logout = (Button)findViewById(R.id.logoutBtn);
        name = (EditText)findViewById(R.id.profile_name);
        pass = (EditText)findViewById(R.id.profile_pass);
        confirm_pass = (EditText)findViewById(R.id.profile_confirmedPass);
        NIC = (EditText)findViewById(R.id.profile_NIC);
        license_no = (EditText)findViewById(R.id.profile_licenseNumber);
        phone_no = (EditText)findViewById(R.id.profile_phoneNumber);
        city = (EditText)findViewById(R.id.profile_city);
        street = (EditText)findViewById(R.id.profile_street);
        door_no = (EditText)findViewById(R.id.profile_door_num);
        edit = (Button)findViewById(R.id.editBtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent("com.app.taxi.service.ACCESS_TAB_ACTIVITY");
                startActivity(startIntent);
                finish();
            }
        });

        this.loadFields();

        name.setEnabled(false);
        pass.setEnabled(false);
        confirm_pass.setEnabled(false);
        phone_no.setEnabled(false);
        NIC.setEnabled(false);
        license_no.setEnabled(false);
        door_no.setEnabled(false);
        street.setEnabled(false);
        city.setEnabled(false);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edit.getText().equals("Edit")){
                    this.setProfileEditable(true);
                    edit.setText("Save");
                    return;
                }
                this.saveProfile();
                this.setProfileEditable(false);
                edit.setText("Edit");
                return;
            }

            public void saveProfile(){
                //here u code how to save edited profile fields to db using json.use my example in loginActivity.java.
                //if u need to change parameters of this method change.
                //tip---this.name.getText(); to get name after editing.
            }

            public void setProfileEditable(boolean value){
                if(value){
                    name.setEnabled(true);
                    pass.setEnabled(true);
                    confirm_pass.setEnabled(true);
                    phone_no.setEnabled(true);

                    if(isCustomer){
                        NIC.setEnabled(false);
                        license_no.setEnabled(false);

                        door_no.setEnabled(true);
                        street.setEnabled(true);
                        city.setEnabled(true);
                    }else {
                        door_no.setEnabled(false);
                        street.setEnabled(false);
                        city.setEnabled(false);

                        NIC.setEnabled(true);
                        license_no.setEnabled(true);
                    }
                    return;
                }else {
                    name.setEnabled(false);
                    pass.setEnabled(false);
                    confirm_pass.setEnabled(false);
                    phone_no.setEnabled(false);
                    NIC.setEnabled(false);
                    license_no.setEnabled(false);
                    door_no.setEnabled(false);
                    street.setEnabled(false);
                    city.setEnabled(false);
                    return;
                }

            }
        });


    }

}
