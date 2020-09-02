package com.example.deebits1.model;

import javax.persistence.*;


@Entity  //making an jpa entity
@Table(name = "Books") // books table
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_category")
    private String category;

    public Books(String book_name, String book_category) {
        super();
        this.name=book_name;
        this.category=book_category;

    }
    public Books(){

    }

    //getters setters to get and set id,name,category
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }





}
