package com.gifty.gifty;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gifty.gifty.questions.GenderQuestion;

//A class that deals with the main screen

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    private Button activityButton;
    private Button infoButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityButton = findViewById(R.id.start_button);
        infoButton = findViewById(R.id.info_button);

        //Set listeners for the buttons

        activityButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GenderQuestion.class);
                startActivity(intent);

            }

        });

        infoButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Information.class);
                startActivity(intent);

            }

        });


        actionBar = getSupportActionBar();


    }








}
