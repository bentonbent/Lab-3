package com.example.csmyp7.mobilelab3_someapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.csmyp7.mobilelab3_someapp.SignupActivity.MYSPs;

public class MainActivity extends AppCompatActivity {

    TextView mtvDate, mtvName, mtvEmail, mtvUni;
    String myDate, myName, myEmail, myUni;

    SharedPreferences mainShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtvDate=findViewById(R.id.textView2);
        mtvName=findViewById(R.id.textView4);
        mtvEmail=findViewById(R.id.textView6);
        mtvUni=findViewById(R.id.textView8);

        mainShare = this.getSharedPreferences(MYSPs, Context.MODE_PRIVATE);
        myDate=mainShare.getString("dateKey", "");
        String aName = mainShare.getString("fNameKey", "");
        String bName = mainShare.getString("lNameKey", "");
        myName=aName+" "+bName;
        myEmail = mainShare.getString("emailKey", "");
        myUni=mainShare.getString("uniKey", "");

        mtvDate.setText(myDate);
        mtvName.setText(myName);
        mtvEmail.setText(myEmail);
        mtvUni.setText(myUni);
    }

    public void logoutB(View v){
        Intent logB = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(logB);
    }
}
