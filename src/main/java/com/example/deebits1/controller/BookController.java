package com.example.deebits1.controller;

import com.example.deebits1.model.Books;
import com.example.deebits1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("books") //end point - get
    public List<Books> getBooks(){
        return this.bookRepository.findAll();
    }




}
