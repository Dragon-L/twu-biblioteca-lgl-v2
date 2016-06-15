package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> allBooks;

    public Books(){
        allBooks = new ArrayList<Book>();
        allBooks.add(new Book("15","Refactoring","Martin Fowler","1994",false));
        allBooks.add(new Book("34","REST in Practice","Jim Webber","1996",false));
        allBooks.add(new Book("26","Analysis Patterns","Martin Fowler","1997",false));
        allBooks.add(new Book("44","A good book","LGL","2016",true));
    }

    public List<Book> getBooks() {
        return allBooks;
    }

    public boolean CheckoutBook(String bookId){
        for (Book book:allBooks){
            if (book.getBookId().equals(bookId) && !book.getIsBorrowed()){
                book.setIsBorrowed(true);
                return true;
            }
        }
        return false;
    }

    public boolean ReturnBook(String bookId){
        for (Book book:allBooks){
            if (book.getBookId().equals(bookId) && book.getIsBorrowed()){
                book.setIsBorrowed(false);
                return true;
            }
        }
        return false;
    }
}
