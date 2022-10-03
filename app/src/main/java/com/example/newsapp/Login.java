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
public class Login extends AppCompatActivity {

    SharedPreferences shared;
    SharedPreferences.Editor myEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared = this.getSharedPreferences("com.lau.shared", Context.MODE_PRIVATE);
        myEdit = shared.edit();
    }

    public void onClick(View v){
    EditText user = (EditText) findViewById(R.id.user);

    String user_val = user.getText().toString();

        Toast.makeText(getApplicationContext(), "Welcome " + user_val, Toast.LENGTH_LONG).show();
        Intent i = new Intent(Login.this, MainPage.class);
        startActivity(i);
    }


}