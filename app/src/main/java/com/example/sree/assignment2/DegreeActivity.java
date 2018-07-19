package com.example.sree.assignment2;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DegreeActivity extends AppCompatActivity implements DegreeSelectionListener,BackFromDegree,BackFromMajor,MajorSelectionListener{

    String[] major;
    String[] degree;
    String finalDegree;
    String finalMajor;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree);
        getDegrees();
        FragmentManager fragments = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragments.beginTransaction();
        DegreeFragment degreeFragment = new DegreeFragment();
        degreeFragment.setDegree(degree);
        fragmentTransaction.add(R.id.fragment_container,degreeFragment);
        fragmentTransaction.commit();
    }

    public void getDegrees(){
        try {
            InputStream degreeFileData = getAssets().open("degrees");
            BufferedReader in = new BufferedReader( new InputStreamReader(degreeFileData));
            ArrayList<String> degreeData = new ArrayList<String>();
            String eachDegree;
            while ((eachDegree = in.readLine()) != null) {
                degreeData.add(eachDegree);
            }
            degree = degreeData.toArray(new String[degreeData.size()]);
        } catch (IOException e) {
            Log.e("rew", "read Error", e);
        }
    }

    public void getMajors(String majorFileName){
        try {
            InputStream majorFileData = getAssets().open(majorFileName);
            BufferedReader in = new BufferedReader( new InputStreamReader(majorFileData));
            ArrayList<String> majorData = new ArrayList<String>();
            String eachMajor;
            while ((eachMajor = in.readLine()) != null) {
                majorData.add(eachMajor);
            }
            major = majorData.toArray(new String[majorData.size()]);
        } catch (IOException e) {
            Log.e("rew", "read Error", e);
        }
    }

    @Override
    public void getMajorForDegree(int position,String degree,View view){
        finalDegree = degree;
        if(finalDegree.equals("Professional Master's Degrees"))
        {
            getMajor(0, "", view);
            return;
        }

        getMajors(degree);
        FragmentManager fragments = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragments.beginTransaction();
        MajorFragment majorFragment = new MajorFragment();
        majorFragment.setMajor(major);
        fragmentTransaction.replace(R.id.fragment_container,majorFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void getMajor(int position, String major,View view) {
        finalMajor = major;
        Intent mainActivity = new Intent();
        mainActivity.putExtra("finalDegree", finalDegree);
        mainActivity.putExtra("finalMajor", finalMajor);
        setResult(RESULT_OK,mainActivity);
        finish();
    }

    @Override
    public void backFromDegree(View view){
        this.finish();
    }

    @Override
    public void backFromMajor(View view){
        super.onBackPressed();
    }
}