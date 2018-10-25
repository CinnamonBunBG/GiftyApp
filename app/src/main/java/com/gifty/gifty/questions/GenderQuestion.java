package com.gifty.gifty.questions;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.gifty.gifty.R;

//A class that deals with the gender question screen

public class GenderQuestion extends AppCompatActivity implements View.OnClickListener {
    ImageButton femaleButton;
    ImageButton maleButton;
    public static String obtainGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender);

        femaleButton = findViewById(R.id.female);
        maleButton = findViewById(R.id.male);
        //set the listeners
        femaleButton.setOnClickListener(this);
        maleButton.setOnClickListener(this);

    }


    //Handles the clicks
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.female:
            {
                Intent intent = new Intent(getApplicationContext(),AgeQuestion.class);
                obtainGender="female";
                startActivity(intent);
                break;

            }
            case R.id.male:
            {
                Intent intent = new Intent(getApplicationContext(),AgeQuestion.class);
                obtainGender = "male";
                startActivity(intent);
                break;
            }


        }


    }


}