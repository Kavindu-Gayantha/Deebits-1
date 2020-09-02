package com.example.deebits1.services;

import com.example.deebits1.model.Books;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    Books createBook(Books books);
    Books updateBook(Books books);
    Books getBook(long bookId);
    void deleteBook(long bookId);
    List<Books> getAllBooks();

    Optional<Books> getBookById(long id);
}
