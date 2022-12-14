package com.example.newsapp;


//CREATE OBJECT NEWS ARTICLE
public class NewsArticle {
    int id;
    String title, author, publisher, location, details;

    NewsArticle(){
    }

    public NewsArticle(int id, String title, String author, String publisher, String location, String details) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.location = location;
        this.details = details;
    }

    public NewsArticle(String title, String author, String publisher, String location, String details){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.location = location;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
