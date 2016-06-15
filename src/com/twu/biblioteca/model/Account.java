package com.twu.biblioteca.model;

public class Account {
    private final String libraryNumber;
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;

    public Account(String libraryNumber, String name, String emailAddress, String phoneNumber){
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber(){
        return libraryNumber;
    }

    public String getName(){
        return name;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

}
