package com.library.model;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { this.isIssued = issued; }

    @Override
    public String toString() {
        return String.format("[ID: %-3d] %-25s | Author: %-20s | Status: %s",
                id, title, author, (isIssued ? "ISSUED" : "AVAILABLE"));
    }
}