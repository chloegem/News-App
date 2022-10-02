package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView title, author, publisher, location, details;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("News Article");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.title = findViewById(R.id.details_Title);
        this.author = findViewById(R.id.details_author);
        this.publisher = findViewById(R.id.details_publisher);
        this.location = findViewById(R.id.details_loc);
        this.details = findViewById(R.id.details_details);

        NewsDatabase db = new NewsDatabase(this);
        Intent i = getIntent();

        id = i.getIntExtra("ID",0);
        NewsArticle newsArticle = db.getNews(id);

        title.setText(newsArticle.getTitle());
        author.setText(newsArticle.getAuthor());
        publisher.setText(newsArticle.getPublisher());
        location.setText(newsArticle.getLocation());
        details.setText(newsArticle.getDetails());
        Toast.makeText(getApplicationContext(),"id"+newsArticle.getId(), Toast.LENGTH_SHORT).show();


    }
}