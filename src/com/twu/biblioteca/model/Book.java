package com.twu.biblioteca.model;

public class Book {
    private final String bookId;
    private final String bookName;
    private final String author;
    private final String publishedYear;
    private boolean isBorrowed;

    public Book(String bookId, String bookName, String author, String publishedYear,boolean isBorrowed) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isBorrowed = isBorrowed;
    }

    public String getBookId(){
        return bookId;
    }

    public String getBookName(){ return bookName;}

    public String getAuthor(){ return author;}

    public String getPublishedYear(){ return publishedYear;}

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed){
        this.isBorrowed = isBorrowed;
    }
}
