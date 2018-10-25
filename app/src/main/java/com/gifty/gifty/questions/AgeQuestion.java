package com.gifty.gifty.questions;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.gifty.gifty.R;

//A class that handles the age question screen
public class AgeQuestion extends AppCompatActivity implements View.OnClickListener {
    public static String ages;

    ImageButton childButton;
    ImageButton adultButton;
    ImageButton teenButton;
    ImageButton elderlyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age);
        childButton = findViewById(R.id.child);
        teenButton =  findViewById(R.id.teenager);
        adultButton =  findViewById(R.id.adult);
        elderlyButton =  findViewById(R.id.elderly);
        //set the listeners
        childButton.setOnClickListener(this);
        teenButton.setOnClickListener(this);
        adultButton.setOnClickListener(this);
        elderlyButton.setOnClickListener(this);

    }


    //Handles the clicks
    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.child:
            {
                Intent intent = new Intent(getApplicationContext(),BudgetQuestion.class);
                ages = "child";
                startActivity(intent);
                break;

            }
            case R.id.teenager:
            {
                Intent intent = new Intent(getApplicationContext(),BudgetQuestion.class);
                ages = "teen";
                startActivity(intent);
                break;
            }
            case R.id.adult:
            {
                Intent intent = new Intent(getApplicationContext(),BudgetQuestion.class);
                ages = "adult";
                startActivity(intent);
                break;

            }
            case R.id.elderly:
            {
                Intent intent = new Intent(getApplicationContext(),BudgetQuestion.class);
                ages = "elderly";
                startActivity(intent);
                break;
            }




        }



    }
}

