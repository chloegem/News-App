package com.example.newsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NewsDatabase extends SQLiteOpenHelper {

    public static final int DB_VERSION = 2;
    public static String DB_NAME = "NewsDB.db";
    public static String DB_TABLE = "NewsTable";

    public static String COLUMN_ID = "NewsID";
    public static String COLUMN_TITLE = "NewsTitle";
    public static String COLUMN_AUTHOR = "NewsAuthor";
    public static String COLUMN_PUBLISHER = "NewsPublisher";
    public static String COLUMN_LOCATION = "NewsLocation";
    public static String COLUMN_DETAILS = "NewsDetails";


    public NewsDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + DB_TABLE +
                "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITLE + "TEXT," +
                COLUMN_AUTHOR + "TEXT," +
                COLUMN_PUBLISHER + "TEXT," +
                COLUMN_LOCATION + "TEXT," +
                COLUMN_DETAILS + "TEXT" + ")";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i>=i1)
            return;
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(sqLiteDatabase);
    }

    public long addNews(NewsArticle newsArticle){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, newsArticle.getTitle());
        cv.put(COLUMN_AUTHOR, newsArticle.getAuthor());
        cv.put(COLUMN_PUBLISHER, newsArticle.getPublisher());
        cv.put(COLUMN_LOCATION, newsArticle.getLocation());
        cv.put(COLUMN_DETAILS, newsArticle.getDetails());

        long ID = db.insert(DB_TABLE,null, cv);
        Log.d("Inserted","id -->" + ID);
        return ID;
    }

    public List<NewsArticle> getNewsArticle(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<NewsArticle> allNews = new ArrayList<>();

        String queryStatement = "SELECT * FROM " + DB_TABLE;
        Cursor cursor = db.rawQuery(queryStatement,null);

        if(cursor.moveToFirst()){
            do{

                NewsArticle newsArticle = new NewsArticle();
                newsArticle.setId(cursor.getInt(0));
                newsArticle.setTitle(cursor.getString(1));
                newsArticle.setAuthor(cursor.getString(2));
                newsArticle.setPublisher(cursor.getString(3));
                newsArticle.setLocation(cursor.getString(4));
                newsArticle.setDetails(cursor.getString(5));

                allNews.add(newsArticle);
            }while(cursor.moveToNext());
        }
        return allNews;

    }
}
