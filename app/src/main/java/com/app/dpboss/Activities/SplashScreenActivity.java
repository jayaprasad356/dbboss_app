package com.app.dpboss.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.app.dpboss.R;
import com.app.dpboss.helper.Session;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler;
    Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler();
        GotoActivity();
    }


    private void GotoActivity()
    {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent=new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

//                Session session = new Session(SplashActivity.this);
//                if (session.getBoolean("is_logged_in")){
//                    Intent intent=new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//
//                }else{
//                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//
//                }



            }
        },2000);
    }
}