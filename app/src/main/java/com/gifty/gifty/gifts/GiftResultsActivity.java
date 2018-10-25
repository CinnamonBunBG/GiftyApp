package com.gifty.gifty.gifts;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gifty.gifty.AddEvent;
import com.gifty.gifty.R;
import com.gifty.gifty.database.DatabaseGifty;

//A class that deals with the results from the questions
public class GiftResultsActivity extends AppCompatActivity{

    private DatabaseGifty myDBHelper;
    private SQLiteDatabase myDB;
    private Button remind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gift);
        remind = findViewById(R.id.reminder);


        remind.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddEvent.class);
                startActivity(intent);

            }

        });

        TextView listGifts = findViewById(R.id.list_of_gifts);
        listGifts.setText(listGifts());

    }


    //A method that generates the query and fetches the gifts corresponding to the answers of the user
    private String listGifts() {
        String giftsss="";
        String selectedGender = Gift.getGender();
        String selectedAge = Gift.getAge();
        String selectedBudget = Gift.getBudget();
        String selectedPersonality = Gift.getPersonality();
        Cursor cursor;
        myDBHelper = new DatabaseGifty(this);
        myDB = myDBHelper.getReadableDatabase();
        String [] selectionArgs = {selectedAge, selectedBudget, selectedPersonality};

        try{
            myDBHelper.openDataBase();
        }catch (SQLException s){
            throw new Error("Could not open db");
        }

        if (selectedGender == "female")
            cursor=myDB.rawQuery("SELECT gift FROM Female WHERE age = ? AND budget = ? AND personality = ?",selectionArgs);
        else
            cursor=myDB.rawQuery("SELECT gift FROM Male WHERE age = ? AND budget = ? AND personality = ?",selectionArgs);


        cursor.moveToFirst();
        giftsss = cursor.getString(0);
        cursor.close();

        return giftsss;

    }


}
