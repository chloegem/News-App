package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import java.util.List;


//CREATE ADAPTER FOR NEWS
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<NewsArticle> newsArticles;

    Adapter(Context context, List<NewsArticle> newsArticles){
        this.inflater = LayoutInflater.from(context);
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String title = newsArticles.get(position).getTitle();
        String author = newsArticles.get(position).getAuthor();

        holder.nTitle.setText(title);
        holder.nAuthor.setText("By: " + author);
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nTitle, nAuthor;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            nTitle = itemView.findViewById(R.id.nTitle);
            nAuthor = itemView.findViewById(R.id.nAuthor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(view.getContext(), DetailActivity.class);
                    i.putExtra("ID", newsArticles.get(getAdapterPosition()).getId());
                    view.getContext().startActivity(i);
                }
            });
        }
    }
}
