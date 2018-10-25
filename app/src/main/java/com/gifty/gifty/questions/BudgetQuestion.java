package com.gifty.gifty.questions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.gifty.gifty.R;
//A class that handles the budget question screen
public class BudgetQuestion extends AppCompatActivity {



    public static String obtainPrice;
    private RadioGroup budgetGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget);
        budgetGroup =  findViewById(R.id.budget_group);
        //Set the listeners
        budgetGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.price1:
                    {
                        Intent intent = new Intent(getApplicationContext(), PersonalityQuestion.class);
                        obtainPrice = "1";
                        startActivity(intent);
                        break;

                    }
                    case R.id.price2:
                    {
                        Intent intent = new Intent(getApplicationContext(), PersonalityQuestion.class);
                        obtainPrice = "2";
                        startActivity(intent);
                        break;
                    }
                    case R.id.price3:
                    {
                        Intent intent = new Intent(getApplicationContext(), PersonalityQuestion.class);
                        obtainPrice = "3";
                        startActivity(intent);
                        break;

                    }
                    case R.id.price4:
                    {
                        Intent intent = new Intent(getApplicationContext(), PersonalityQuestion.class);
                        obtainPrice = "4";
                        startActivity(intent);

                        break;
                    }
                    case R.id.price5:
                    {
                        Intent intent = new Intent(getApplicationContext(), PersonalityQuestion.class);
                        obtainPrice = "5";
                        startActivity(intent);
                        break;

                    }

                }

            }
        });
    }



}

