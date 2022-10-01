package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView news_title, news_author, news_publisher, news_location, news_details;
    Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        news_title = findViewById(R.id.title);
        news_author = findViewById(R.id.author);
        news_publisher = findViewById(R.id.publisher);
        news_location = findViewById(R.id.location);
        news_details = findViewById(R.id.details);

    }
}