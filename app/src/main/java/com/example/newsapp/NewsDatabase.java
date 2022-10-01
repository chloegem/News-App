package com.example.newsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class NewsDatabase extends SQLiteOpenHelper {

    public static final int DB_VERSION = 2;
    public static String DB_NAME = "NewsDB.db";
    public static String DB_TABLE = "NewsTable";

    public static String COLUMN_TITLE = "NewsTitle";
    public static String COLUMN_AUTHOR = "NewsAuthor";
    public static String COLUMN_PUBLISHER;
    public static String COLUMN_LOCATION;
    public static String COLUMN_DETAILS;


    public NewsDatabase(@Nullable Context context) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
