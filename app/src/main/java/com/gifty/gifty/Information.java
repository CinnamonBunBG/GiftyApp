package com.gifty.gifty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gifty.gifty.questions.GenderQuestion;

public class Information extends AppCompatActivity {

    //A class that deals with the information screen
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        startButton = findViewById(R.id.start_button);

        //Set the listeners
        startButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GenderQuestion.class);
                startActivity(intent);

            }

        });




    }

}
