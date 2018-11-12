package com.example.csmyp7.mobilelab3_someapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {

    TextView date;
    EditText et1, et2, et3, et4, et5, et6;
    Button mySubmit;

    public static final String MYSPs = "MySharedPreferences_mobile-lab-3_someapp";
    public static final String fName ="fNameKey";
    public static final String lName ="lNameKey";
    public static final String email ="emailKey";
    public static final String uni="uniKey";
    public static final String myPass="passwordKey";
    public static final String myPass2="passwordKey2";
    public static final String joinDate="dateKey";

    Calendar myCalendar= Calendar.getInstance();
    int day = myCalendar.get(Calendar.DAY_OF_MONTH);
    int month = myCalendar.get(Calendar.MONTH);
    int yr = myCalendar.get(Calendar.YEAR);
    String startDate= (month+1)+"/"+ day+"/"+yr;

    SharedPreferences myShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //date= findViewById(R.id.myDate);
        et1= findViewById(R.id.editText1);
        et2= findViewById(R.id.editText2);
        et3= findViewById(R.id.editText3);
        et4= findViewById(R.id.editText4);
        et5= findViewById(R.id.editText5);
        et6= findViewById(R.id.editText6);
        mySubmit= findViewById(R.id.buttonSubmit);

        myShare=getSharedPreferences(MYSPs, MODE_PRIVATE);

        mySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = et1.getText().toString();
                String lastName = et2.getText().toString();
                String Email = et3.getText().toString();
                String University = et4.getText().toString();
                String password1 = et5.getText().toString();
                String password2 = et6.getText().toString();
                //String myStart= startDate;
                //Context context = getActivity();

                //SharedPreferences mySharedPrefs = this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor myEdit = myShare.edit();
                if (!firstName.isEmpty())
                    myEdit.putString(fName, firstName);
                if (!lastName.isEmpty())
                    myEdit.putString(lName, lastName);
                if (!Email.isEmpty())
                    myEdit.putString(email, Email);
                if (!University.isEmpty())
                    myEdit.putString(uni, University);
                if (!password1.isEmpty()) {
                    myEdit.putString(myPass, password1);
                }
                if (!password2.isEmpty()) {
                    myEdit.putString(myPass2, password2);
                }
                myEdit.putString(joinDate, startDate);
                myEdit.commit();

                Intent myLog=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(myLog);
            }
        });
    }



    //public void myLogin(View v){//nest inside if form is complete continue to Login Activity
    //}
}
