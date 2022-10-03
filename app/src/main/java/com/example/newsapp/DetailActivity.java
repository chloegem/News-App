package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


//TO VIEW NEWS ARTICLE - PART 5
public class DetailActivity extends AppCompatActivity {

    TextView dTitle, dAuthor, dPublisher, dLocation, dDetails;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Article Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dTitle = findViewById(R.id.details_Title);
        dAuthor = findViewById(R.id.details_author);
        dPublisher = findViewById(R.id.details_publisher);
        dLocation = findViewById(R.id.details_loc);
        dDetails = findViewById(R.id.details_details);

        NewsDatabase db = new NewsDatabase(this);
        Intent intent = getIntent();

        id = intent.getIntExtra("ID",0);

        NewsArticle newsArticle = db.getNews(id);

        dTitle.setText(newsArticle.getTitle());
        dAuthor.setText(newsArticle.getAuthor());
        dPublisher.setText(newsArticle.getPublisher());
        dLocation.setText(newsArticle.getLocation());
        dDetails.setText(newsArticle.getDetails());
        Toast.makeText(getApplicationContext(), "ID"+newsArticle.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news_delete,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        if (item.getItemId() == R.id.delete) {
            NewsDatabase db = new NewsDatabase(this);
            Intent intent = getIntent();
            id = intent.getIntExtra("Article Selected!", 0);
            db.deleteNews(id);
            Toast.makeText(getApplicationContext(), "Article Deleted!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(DetailActivity.this, MainPage.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}