package com.twu.biblioteca.controller.core;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BookList;
import com.twu.biblioteca.model.Books;

import java.util.List;

public class BookController {
    private Books books;
    private BookList bookList;

    public BookController(Books books,BookList bookList){
        this.books = books;
        this.bookList = bookList;
    }

    public boolean CheckoutBook(String bookId) {
        if (books.CheckoutBook(bookId)){
            bookList.updateBookList(books);
            return true;
        }
        return false;
    }

    public boolean ReturnBook(String bookId) {
        if (books.ReturnBook(bookId)){
            bookList.updateBookList(books);
            return true;
        }
        return false;
    }

    public List<Book> getBookList(){
        return bookList.getBookList();
    }

}
