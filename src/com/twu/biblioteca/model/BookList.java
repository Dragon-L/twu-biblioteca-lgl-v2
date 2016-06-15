package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> bookList;

    public BookList(Books books) {
        bookList = new ArrayList<Book>();

        for (Book book:books.getBooks()){
            if (book.getIsBorrowed() == false){
                bookList.add(book);
            }
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void updateBookList(Books books){
        bookList.clear();

        for (Book book:books.getBooks()){
            if (book.getIsBorrowed() == false){
                bookList.add(book);
            }
        }
    }

    public boolean removeBook(String bookId) {
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }
}
