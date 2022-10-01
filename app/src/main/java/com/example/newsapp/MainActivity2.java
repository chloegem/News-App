package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.news_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.add);
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}