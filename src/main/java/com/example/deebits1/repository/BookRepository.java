package com.example.deebits1.repository;

import com.example.deebits1.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Books,Long>{



}
