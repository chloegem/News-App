package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

//MAIN PAGE - PART 3
public class MainPage extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    List<NewsArticle> newsArticleList;

    SharedPreferences shared;
    SharedPreferences.Editor myEdit;
    String user_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerViewAdd);
        NewsDatabase newsDatabase = new NewsDatabase(this);
        newsArticleList = newsDatabase.getNewsArticle();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,newsArticleList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.add);
        Intent i = new Intent(MainPage.this, addNews.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

    public void sharedPref()
    {
        shared = this.getSharedPreferences("com.lau.shared", Context.MODE_PRIVATE);
        myEdit = shared.edit();
        user_val = shared.getString("token_a", "");
    }
}