package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

//SPLASH SCREEN - PART 1
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread() {

            public void run() {

                try{
                sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }

            }

        };
        thread.start();

    }
}