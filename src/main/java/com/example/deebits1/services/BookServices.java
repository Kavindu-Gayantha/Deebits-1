package com.example.deebits1.services;

import com.example.deebits1.model.Books;
import com.example.deebits1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServices implements BookServiceInterface{

    @Autowired
    private BookRepository bookRepository;

    //rest api methods
    @Override  // create a book in db
    public Books createBook(Books books) {
        return bookRepository.save(books);
    }

    @Override  // update a book name , id and the category
    public Books updateBook(Books books) {
        Optional<Books> booksDb = this.bookRepository.findById((long) books.getId());

        if(booksDb.isPresent()){
            Books bookUpdate = booksDb.get();
            bookUpdate.setName(books.getName());
            bookUpdate.setCategory(books.getCategory());
            bookUpdate.setId(books.getId());

            bookRepository.save(bookUpdate);
            return bookUpdate;
        }
        else {
            throw new ResourceNotFoundException("record not to be find" + books.getId());
        }
//        return books;
    }

    @Override  // get a book name, id and the category from the db
    public Books getBook(long bookId) {
        Optional<Books> booksDb = this.bookRepository.findById(bookId);

        if(booksDb.isPresent()){
            return booksDb.get();
        }else {
            throw new ResourceNotFoundException("record not to be find" + bookId);
        }
    }

    @Override  // delete a book from the db
    public void deleteBook(long bookId) {
        Optional<Books> bookDb = this.bookRepository.findById(bookId);

        if(bookDb.isPresent()){
            this.bookRepository.delete(bookDb.get());
        }else
        {
            throw new ResourceNotFoundException("record not to be find" + bookId);

        }
    }

    @Override   // list all the boook in the db
    public List<Books> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Books> getBookById(long id) {
        return this.bookRepository.findById(id);
    }

    private static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String record_not_to_be_find) {

        }
    }
//    @Autowired
//    private BookRepository bookRepository;
//    @Override
//    public void run(String... args) throws Exception {
//        this.bookRepository.save(new Books("book1","children_category"));
//        this.bookRepository.save(new Books("book2","novels"));
//        this.bookRepository.save(new Books("book3","short stories"));
//
//    }

}
