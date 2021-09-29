package com.example.bhargavdesai_project1;

//database, constructor and getter setter methods

public class Manga {
    private String title;
    private String author;
    private String description;
    private String picture;
    private int price;
    private int publication_year;

    public Manga(String title, String author, String description, String picture, int price, int publication_year) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.publication_year = publication_year;
    }

    public Manga(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }
}
