package com.example.deebits1.controller;

import com.example.deebits1.model.Books;
import com.example.deebits1.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// end points are located here

@RestController
@RequestMapping("/api")
public class BookController {

//    @Autowired
//    private BookRepository bookRepository;
//
//    @GetMapping("allBooks") //end point - get
//    public List<Books> getBooks(){
//        return this.bookRepository.findAll();
//    }

    @Autowired
    private BookServices bookServices;

    //get -end point to get all the books
    @GetMapping("books")
    public ResponseEntity<List<Books>> getAllBooks(){
        return ResponseEntity.ok().body(bookServices.getAllBooks());
    }
    @GetMapping("getBook/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable long id){
        return ResponseEntity.ok().body(bookServices.getBookById(id));
    }

    //post -end point
    @PostMapping("addBook")
    public ResponseEntity<Books> addBook(@RequestBody Books books){
//        this.bookServices.createBook(books);
          return ResponseEntity.ok().body(this.bookServices.createBook(books));

    }
    //update -end point
    @PutMapping("updateBook/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable long id, @RequestBody Books books){
        books.setId(id);
        return ResponseEntity.ok().body(this.bookServices.updateBook(books));

    }
    //delete -end point
    @DeleteMapping("deleteBook/{id}")
    public HttpStatus deleteBook(@PathVariable long id){
        this.bookServices.deleteBook(id);

        return HttpStatus.OK;
    }




}
