package com.twu.biblioteca.model;

public class Movie {
    private final String id;
    private final String name;
    private final String director;
    private boolean isBorrowed;
    private String rating;

    public Movie(String id,String name,String director,String rating,boolean isBorrowed){
        this.id = id;
        this.name = name;
        this.director = director;
        this.rating = rating;
        this.isBorrowed = isBorrowed;
    }

    public String getId(){
        return id;
    }

    public String getName(){ return name;}

    public String getDirector(){ return director;}

    public String getRating(){ return rating;}

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed){
        this.isBorrowed = isBorrowed;
    }
}
