package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//TO ADD A NEWS ARTICLE - PART 4
public class addNews extends AppCompatActivity {

    EditText news_title, news_author, news_publisher, news_location, news_details;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setTitle("Add News Article");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        news_title = findViewById(R.id.title);
        news_author = findViewById(R.id.author);
        news_publisher = findViewById(R.id.publisher);
        news_location = findViewById(R.id.location);
        news_details = findViewById(R.id.details);
        button = findViewById(R.id.button_add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsArticle newsArticle = new NewsArticle(news_title.getText().toString(), news_author.getText().toString(), news_publisher.getText().toString(),news_location.getText().toString(),news_details.getText().toString());
                NewsDatabase db = new NewsDatabase(addNews.this);
                db.addNews(newsArticle);

                Toast.makeText(getApplicationContext(),"News Article Saved!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(addNews.this, MainPage.class); //create new activity
                startActivity(i);
            }
        });
       }
}