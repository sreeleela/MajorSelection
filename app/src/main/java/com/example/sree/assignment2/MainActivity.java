package com.example.sree.assignment2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button done;
    EditText major;
    EditText firstName;
    EditText lastName;
    EditText age;
    EditText emailId;
    EditText phNo;
    private static final int REQUEST_CODE = 123;
    String finalDegree;
    String finalMajor;
    String education;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        age = (EditText) findViewById(R.id.age);
        emailId = (EditText) findViewById(R.id.email);
        phNo = (EditText) findViewById(R.id.phno);
        done = (Button) findViewById(R.id.done);
        major = (EditText) findViewById(R.id.major);

        SharedPreferences sharedPref = getSharedPreferences("mypref", 0);
        String savedFirstName = sharedPref.getString("enteredFirstName", "");
        firstName.setText(savedFirstName);
        String savedLastName = sharedPref.getString("enteredLastName", "");
        lastName.setText(savedLastName);
        String savedAge = sharedPref.getString("enteredAge", "");
        age.setText(savedAge);
        String savedEmailId = sharedPref.getString("enteredEmailId", "");
        emailId.setText(savedEmailId);
        String savedPhNo = sharedPref.getString("enteredPhNo", "");
        phNo.setText(savedPhNo);
        String savedEducation = sharedPref.getString("enteredEducation", "");
        major.setText(savedEducation);

        //Saving data
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create object of SharedPreferences.
                SharedPreferences sharedPref = getSharedPreferences("mypref", 0);
                //now get Editor
                SharedPreferences.Editor editor = sharedPref.edit();
                //put your value
                editor.putString("enteredFirstName", firstName.getText().toString());
                editor.putString("enteredLastName", lastName.getText().toString());
                editor.putString("enteredAge", age.getText().toString());
                editor.putString("enteredEmailId", emailId.getText().toString());
                editor.putString("enteredPhNo", phNo.getText().toString());
                editor.putString("enteredEducation", major.getText().toString());
                //commits your edits
                editor.commit();
            }
        });

        //hide keyboard
        major.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(major.getWindowToken(), 0);
                if(hasFocus)
                {
                    Intent degreeSelection = new Intent(view.getContext(), DegreeActivity.class);
                    degreeSelection.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivityForResult(degreeSelection,123);
                }
            }
        });

        //major data
        major.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Intent degreeSelection = new Intent(view.getContext(), DegreeActivity.class);
                degreeSelection.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(degreeSelection,123);
                return false;
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCodeReceived, Intent data)
        {
            super.onActivityResult(requestCode,resultCodeReceived,data);
            if (requestCode != REQUEST_CODE)
            {
                return;
            }
            switch (resultCodeReceived)
            {
                case RESULT_OK:
                    finalDegree = data.getStringExtra("finalDegree");
                    finalMajor = data.getStringExtra("finalMajor");
                    if(finalDegree.equals("Doctor of Philosophy (Ph.D.)"))
                        finalDegree = "Ph.D.";
                    else if(finalDegree.equals("Doctor of Education (Ed.D.)"))
                        finalDegree = "Ed.D.";
                    else if(finalDegree.equals("Master of Arts (MA)"))
                        finalDegree = "MA";
                    else if (finalDegree.equals("Master of Science (MS)"))
                        finalDegree = "MS";
                    else if(finalDegree.equals("Master of Fine Arts (MFA)"))
                        finalDegree = "MFA";
                    education = finalDegree + " " + finalMajor;
                    major.setText(education);
                    break;
                case RESULT_CANCELED:
                    break;
            }
        }
    }
