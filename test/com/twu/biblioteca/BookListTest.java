package com.twu.biblioteca;

import com.twu.biblioteca.model.BookList;
import com.twu.biblioteca.model.Books;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookListTest {
    BookList bookList;
    Books books;

    @Before
    public void setUp() throws Exception{
        books = new Books();
        bookList = new BookList(books);
    }

    @Test
    public void should_return_a_list_of_all_books_when_call_getBookList(){
        List<Book> books = bookList.getBookList();
        assertThat(books.get(0).getBookId(),equalTo("15"));
        assertThat(books.get(1).getBookId(),equalTo("34"));
        assertThat(books.get(2).getBookId(),equalTo("26"));
    }
}
