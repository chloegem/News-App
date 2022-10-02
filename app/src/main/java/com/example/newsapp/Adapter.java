package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<NewsArticle> newsArticles;

    Adapter(Context context, List<NewsArticle> newsArticles){
        this.inflater = LayoutInflater.from(context);
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = newsArticles.get(position).getTitle();
        String author = newsArticles.get(position).getAuthor();

        holder.nTitle.setText(title);
        holder.nAuthor.setText(author);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nTitle, nAuthor;

        public ViewHolder(@NonNull View view){
            super(view);
            nTitle = view.findViewById(R.id.nTitle);
            nAuthor = view.findViewById(R.id.nTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "Item Clicked", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }
}
