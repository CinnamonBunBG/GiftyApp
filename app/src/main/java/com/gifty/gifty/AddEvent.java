package com.gifty.gifty;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

//A class that deals with the reminder function
public class AddEvent extends AppCompatActivity {

    private Button addEvent;
    private String titleEvent, descEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);
        addEvent=findViewById(R.id.event_button);


        addEvent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Calendar calendarr = Calendar.getInstance();
                titleEvent = ((EditText)findViewById(R.id.edit_text_title)).getText().toString();
                descEvent = ((EditText)findViewById(R.id.edit_text_description)).getText().toString();
                Intent intent1 = new Intent(Intent.ACTION_EDIT);
                intent1.setType("vnd.android.cursor.item/event");
                intent1.putExtra("title",titleEvent);
                intent1.putExtra("description",descEvent);
                intent1.putExtra("allDay",true);
                intent1.putExtra("beginTime", calendarr.getTimeInMillis());
                intent1.putExtra("endTime",calendarr.getTimeInMillis()+60*60*1000);
                startActivity(intent1);

            }

        });



    }



}
