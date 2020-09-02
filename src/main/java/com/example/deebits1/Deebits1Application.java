package com.example.deebits1;

import com.example.deebits1.model.Books;
import com.example.deebits1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Deebits1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Deebits1Application.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
		this.bookRepository.save(new Books("book1","children_category"));
		this.bookRepository.save(new Books("book2","novels"));
		this.bookRepository.save(new Books("book3","short stories"));

	}
}
