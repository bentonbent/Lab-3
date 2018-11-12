package com.example.csmyp7.mobilelab3_someapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.csmyp7.mobilelab3_someapp.SignupActivity.MYSPs;

public class LoginActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;//testing views

    EditText e1, e2;
    Button advance;
    String name, password;
    //String defaultPassword, defaultName,;

    SharedPreferences logShare;
private static final String myDefaultName="defaultNameKey";
private static final String myDefaultPassword="defaultPasswordKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logShare = getSharedPreferences(MYSPs, Context.MODE_PRIVATE);
        SharedPreferences.Editor logEdit = logShare.edit();
        logEdit.putString(myDefaultName, "admin");
        logEdit.putString(myDefaultPassword, "admin");
        logEdit.commit();


        //testing views
        tv1=findViewById(R.id.textView10);
        tv2=findViewById(R.id.textView11);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);


        advance = findViewById(R.id.buttonLogin);
        advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = e1.getText().toString();
                password = e2.getText().toString();

                logShare = getSharedPreferences(MYSPs, Context.MODE_PRIVATE);
                //String nameDefault=getResources().getString(R.string.fName);
                String myName = logShare.getString("fNameKey", myDefaultName);
                String myPassword = logShare.getString("passwordKey", myDefaultPassword);

                tv1.setText(myName);
                tv2.setText(myPassword);
                //tv3.setText(String.valueOf(name));
                //tv4.setText("pass: "+password+" "+myPassword);

                if (name.equals(myName) && password.equals(myPassword)) {
                    Intent myMain = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myMain);
                }
            }

            ;
        });
    }



    public void mySignup(View v){
        Intent mySign = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(mySign);
    }



    public void myMainActivity(View v){
        //nest inside if statements, verify password and username

        //SharedPreferences mySharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //String defaultValue = getResources().getString(R.string.fName);
        //String myName = mySharedPref.getString(getString(R.string.fName), defaultValue);
        Intent myMain = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(myMain);
    }
}

