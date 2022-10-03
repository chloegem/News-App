package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//LOGIN AFTER SPLASH SCREEN - PART 2
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
    EditText user = (EditText) findViewById(R.id.user);

    String user_val = user.getText().toString();

        Toast.makeText(getApplicationContext(), "Welcome " + user_val, Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }
}