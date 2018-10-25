package com.gifty.gifty.questions;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.gifty.gifty.R;
import com.gifty.gifty.gifts.GiftResultsActivity;

public class PersonalityQuestion extends AppCompatActivity{

    RadioGroup personalityGroup;
    Button done;
    public static String personality;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personality);

        personalityGroup = findViewById(R.id.personality_group);
        //Set the listeners
        personalityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.active: {
                        personality = "sport";
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case R.id.artsy: {
                        personality= "art";
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.geeky: {
                        personality = "geek" ;
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case R.id.techy: {
                        personality="tech";
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.foodie: {
                        personality="food";
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case R.id.makeup:{
                        personality="style";
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.musical:{
                        personality="music";
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.outdoors: {
                        personality="outdoors";
                        Intent intent = new Intent(getApplicationContext(), GiftResultsActivity.class);
                        startActivity(intent);
                        break;
                    }


                }
            }
        });





    }



}


