package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    SharedPreferences share;
    SharedPreferences.Editor edit;
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
        author.setText("By: " + newsArticle.getAuthor());
        publisher.setText(newsArticle.getPublisher());
        location.setText(newsArticle.getLocation());
        details.setText(newsArticle.getDetails());
        Toast.makeText(getApplicationContext(),"Article Selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news_delete,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        if(item.getItemId() == R.id.delete){
            NewsDatabase db = new NewsDatabase(this);
            Intent i = getIntent();
            id = i.getIntExtra("ID",0);
            db.deleteNote(id);
            Toast.makeText(getApplicationContext(),"Article Deleted!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetailActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    return super.onOptionsItemSelected(item);
    }

    public void sharedPref()
    {
        share = this.getSharedPreferences("com.lau.shared", Context.MODE_PRIVATE);
        edit = share.edit();
        name = share.getString("token_a", "");
        user.setText("Welcome " + name);
    }


}