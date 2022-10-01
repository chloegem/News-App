package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(){
    EditText user = (EditText) findViewById(R.id.user);

    String user_val = user.getText().toString();

        Toast.makeText(getApplicationContext(), "Signed In" + user_val, Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(i);
    }
}