package com.twu.biblioteca;

import com.twu.biblioteca.controller.core.BookController;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BookList;
import com.twu.biblioteca.model.Books;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookControllerTest {
    Books books;
    BookList bookList;
    BookController bookController;

    @Before
    public void setUp() throws Exception{
        books = new Books();
        bookList = new BookList(books);
        bookController = new BookController(books,bookList);
    }


    @Test
    public void should_return_false_when_call_CheckoutBook_input_the_wrong_bookId(){
        boolean isSuccess = bookController.CheckoutBook("100");
        List<Book> books = bookController.getBookList();

        assertThat(isSuccess,equalTo(false));
        assertThat(books.get(0).getBookId(),equalTo("15"));
        assertThat(books.get(1).getBookId(),equalTo("34"));
        assertThat(books.get(2).getBookId(),equalTo("26"));
    }

    @Test
    public void should_remove_the_book_and_return_true_when_call_CheckoutBook_input_the_right_bookId(){
        boolean isSuccess = bookController.CheckoutBook("34");
        List<Book> books = bookController.getBookList();

        assertThat(isSuccess,equalTo(true));
        assertThat(books.get(0).getBookId(),equalTo("15"));
        assertThat(books.get(1).getBookId(),equalTo("26"));
    }

    @Test
    public void should_add_the_book_to_list_and_return_true_when_call_ReturnBook_and_input_the_right_bookId(){
        boolean isSuccess = bookController.ReturnBook("44");
        List<Book> books = bookController.getBookList();

        assertThat(isSuccess,equalTo(true));
        assertThat(books.get(0).getBookId(),equalTo("15"));
        assertThat(books.get(1).getBookId(),equalTo("34"));
        assertThat(books.get(2).getBookId(),equalTo("26"));
        assertThat(books.get(3).getBookId(),equalTo("44"));
    }

    @Test
    public void should_return_false_when_call_ReturnBook_and_the_book_already_returned(){
        boolean isSuccess = bookController.ReturnBook("15");
        List<Book> books = bookController.getBookList();

        assertThat(isSuccess,equalTo(false));
        assertThat(books.get(0).getBookId(),equalTo("15"));
        assertThat(books.get(1).getBookId(),equalTo("34"));
        assertThat(books.get(2).getBookId(),equalTo("26"));
    }

    @Test
    public void should_return_false_when_call_ReturnBook_and_input_the_wrong_bookId(){
        boolean isSuccess = bookController.ReturnBook("100");
        List<Book> books = bookController.getBookList();

        assertThat(isSuccess,equalTo(false));
        assertThat(books.get(0).getBookId(),equalTo("15"));
        assertThat(books.get(1).getBookId(),equalTo("34"));
        assertThat(books.get(2).getBookId(),equalTo("26"));
    }

}
