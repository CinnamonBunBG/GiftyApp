package com.gifty.gifty;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gifty.gifty.login.Login;

public class Welcome extends AppCompatActivity {


    //A class that handles the welcome screen
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        //Make it visible for 4 seconds
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Welcome.this,Login.class);
                startActivity(intent);
                finish();
            }
        },4000);

    }

}
